/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package assignment.part1_chatapp;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author rasek
 */

public class LoginTest {
    
    //Creating variables for the unit test
     String USERNAME_ERROR = "Username is not correctly formatted; please ensure that your username "
            + "contains an underscore and is no more than five characters in length.";

     String PASSWORD_SUCCESS = "Password successfully captured.";

     String PASSWORD_ERROR = "Password is not correctly formatted; please ensure that the password "
            + "contains at least eight characters, a capital letter, a number, and a special character.";

     String CELL_SUCCESS = "Cell number successfully captured.";

     String CELL_ERROR = "Cell number is incorrectly formatted or does not contain an international code; "
            + "please correct the number and try again.";
    
        
     Login login = new Login();

    //Test of register user invalid username method, of class Login.
    @Test
    void registerUser_invalidUsername_kyleBang_returnsExactUsernameError() {
        String msg = login.registerUser("kyle!!!!!!!", "Ch&&sec@ke99!", "+27838968976");
        assertEquals(USERNAME_ERROR, msg);
    }
    
    
    //Test of messageForCellCapture_validSouthAfricanNumber method, of class Login.  
    @Test
    void messageForCellCapture_validSouthAfricanNumber() {
        assertEquals(CELL_SUCCESS, login.messageForCellCapture("+27838968976"));
    }

    
    //Test of messageForCellCapture_invalidLocalStyleNumber method, of class Login.
    @Test
    void messageForCellCapture_invalidLocalStyleNumber() {
        assertEquals(CELL_ERROR, login.messageForCellCapture("08966553"));
    }

    
    //Test of registerUser_invalidCell_returnsExactCellError method, of class Login.
    @Test
    void registerUser_invalidCell_returnsExactCellError() {
        String msg = login.registerUser("kyl_1", "Ch&&sec@ke99!", "08966553");
        assertEquals(CELL_ERROR, msg);
    }

    
    //Test of checkUserName_kyl_1_isCorrectlyFormatted method, of class Login.
    @Test
    void checkUserName_kyl_1_isCorrectlyFormatted() {
        assertTrue(login.checkUserName("kyl_1"));
    }

    
    //Test of login_successful_returnsTrue method, of class Login.
    @Test
    void login_successful_returnsTrue() {
        login.registerUser("a_b", "Abcdef1!", "+27123456789");
        assertTrue(login.loginUser("a_b", "Abcdef1!"));
    }

    
    //Test of login_failed_returnsFalse method, of class Login.
    @Test
    void login_failed_returnsFalse() {
        login.registerUser("a_b", "Abcdef1!", "+27123456789");
        assertFalse(login.loginUser("a_b", "Wrongpass1!"));
    }

    
    //Test of registerUser_invalidUsername_noUnderscore_returnsExactUsernameError method, of class Login.
    @Test
    void registerUser_invalidUsername_noUnderscore_returnsExactUsernameError() {
        String msg = login.registerUser("abcde", "Ch&&sec@ke99!", "+27838968976");
        assertEquals(USERNAME_ERROR, msg);
    }

    
    //Test of messageForPasswordCapture_validComplexPassword method, of class Login.
    @Test
    void messageForPasswordCapture_validComplexPassword() {
        assertEquals(PASSWORD_SUCCESS, login.messageForPasswordCapture("Ch&&sec@ke99!"));
    }

    
    //Test of messageForPasswordCapture_invalidPassword method, of class Login.
    @Test
    void messageForPasswordCapture_invalidPassword() {
        assertEquals(PASSWORD_ERROR, login.messageForPasswordCapture("password"));
    }

    
    //Test of registerUser_invalidPassword_returnsExactPasswordError method, of class Login.
    @Test
    void registerUser_invalidPassword_returnsExactPasswordError() {
        String msg = login.registerUser("kyl_1", "password", "+27838968976");
        assertEquals(PASSWORD_ERROR, msg);
    }

    
    //Test of checkUserName_rejectsTooLong method, of class Login.
    @Test
    void checkUserName_rejectsTooLong() {
        assertFalse(login.checkUserName("ab_cd_"));
    }

    
    //Test of checkCellPhoneNumber_rejectsWithoutPlus method, of class Login.
    @Test
    void checkCellPhoneNumber_rejectsWithoutPlus() {
        assertFalse(login.checkCellPhoneNumber("27123456789"));
    }

    
    //Test of returnLoginStatus_withoutRegisteredUser_mentionsNoRegistration method, of class Login.
    @Test
    void returnLoginStatus_withoutRegisteredUser_mentionsNoRegistration() {
        assertTrue(login.returnLoginStatus().contains("no user registered"));
    }
    
}
