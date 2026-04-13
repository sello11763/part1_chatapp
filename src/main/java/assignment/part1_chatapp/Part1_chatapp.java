/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package assignment.part1_chatapp;


/**
 *
 * @author rasek
 */

public class Part1_chatapp {

    public static void main(String[] args) {

        //Creates a login object that handles registration/login logic.
        Login login = new Login();
        
        //Calls the login.registerUser method and prints the relavant output.
        System.out.println("=== REGISTER ===");
        String registerMessage = login.registerUser();
        System.out.println(registerMessage);

        if (!login.isRegistered()) {
            return;
        }

        //Calls the login.loginUser method and prints the relavant output.
        System.out.println("\n=== LOGIN ===");
        login.loginUser();
        System.out.println(login.returnLoginStatus());
        
    }
}
