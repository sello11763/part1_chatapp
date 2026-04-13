/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.part1_chatapp;

import java.util.Scanner;

/**
 *
 * @author rasek
 */

//Creating a class called login
public class Login {
    
    
    //Creating a scanner
     Scanner scanner = new Scanner(System.in);
 private String registeredUsername;
    private String registeredPassword;
    private String registeredCellPhone;
    private String registeredFirstName;
    private String registeredLastName;
    private boolean registered;   
    private boolean lastLoginSuccess;

    
    //Creating a method to check the username
    public boolean checkUserName(String username) {
        return username != null
                && username.contains("_")
                && username.length() <= 5;
    }

    
    //Creating a method to check password complexity with at least 8 characters, capital letter, digit, special character.     
    public boolean checkPasswordComplexity(String password) {
        return password != null
                && password.length() >= 8
                && password.matches(".*[A-Z].*")
                && password.matches(".*\\d.*")
                && password.matches(".*[^a-zA-Z0-9].*");
    }

    //Creating a method to check cellphone number that contains international code and at least 10 characters
    public boolean checkCellPhoneNumber(String cellPhoneNumber) {
        return cellPhoneNumber != null
                && cellPhoneNumber.matches("^\\+27\\d{9}$");
    }

    
    //Creating registers using prompts. Returns one of the required outcome messages.     
    public String registerUser() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter cellphone number (with international code, "
                + "should contain no more than 10 characters long): ");
        String cell = scanner.nextLine();
        return registerUser(username, password, cell);
    }

    public String registerUser(String username, String password, String cellPhoneNumber) {
        return registerUser(username, password, cellPhoneNumber, null, null);
    }

    
    //Creating registration to display names for the assignment welcome message          
    public String registerUser(String username, String password, String cellPhoneNumber,
            String firstName, String lastName) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted; please ensure that your username "
                    + "contains an underscore and is no more than five characters in length.";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password "
                    + "contains at least eight characters, a capital letter, a number, and a special character.";
        }
        if (!checkCellPhoneNumber(cellPhoneNumber)) {
            return "Cell number is incorrectly formatted or does not contain an international code; "
                    + "please correct the number and try again.";
        }
        registeredUsername = username;
        registeredPassword = password;
        registeredCellPhone = cellPhoneNumber;
        registeredFirstName = firstName;
        registeredLastName = lastName;
        registered = true;
        return "User has been registered successfully.";
    }
    
    public String messageForCellCapture(String cellPhoneNumber) {
        if (checkCellPhoneNumber(cellPhoneNumber)) {
            return "Cell number successfully captured.";
        }
        return "Cell number is incorrectly formatted or does not contain an international code; "
                + "please correct the number and try again.";
    }

    public String messageForPasswordCapture(String password) {
        if (checkPasswordComplexity(password)) {
            return "Password successfully captured.";
        }
        return "Password is not correctly formatted; please ensure that the password "
                + "contains at least eight characters, a capital letter, a number, and a special character.";
    }

    //Prompts for login details and compares with stored registration.     
    public Boolean loginUser() {
        if (!registered) {
            lastLoginSuccess = false;
            return Boolean.FALSE;
        }
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        return loginUser(username, password);
    }

    //Creating a method for login user to verify the login details
    public Boolean loginUser(String username, String password) {
        if (!registered) {
            lastLoginSuccess = false;
            return Boolean.FALSE;
        }
        lastLoginSuccess = registeredUsername.equals(username) && registeredPassword.equals(password);
        return lastLoginSuccess ? Boolean.TRUE : Boolean.FALSE;
    }

    //Creating a method to return login status that returns necessary messaging for succeful login and failed login
    public String returnLoginStatus() {
        if (!registered) {
            return "Login failed: no user registered.";
        }
        if (!lastLoginSuccess) {
            return "Username or password incorrect, please try again.";
        }
        if (registeredFirstName != null && registeredLastName != null) {
            return "Welcome " + registeredFirstName + " ," + registeredLastName + " it is great to see you.";
        }
        return "Welcome " + registeredUsername + ", it is great to see you again.";
    }    

    public boolean isRegistered() {
        return registered;
    }

    public String getRegisteredUsername() {
        return registeredUsername;
    }

    public String getRegisteredPassword() {
        return registeredPassword;
    }

    public String getRegisteredCellPhone() {
        return registeredCellPhone;
    }

    public boolean isLastLoginSuccess() {
        return lastLoginSuccess;
    }
    
}

    

