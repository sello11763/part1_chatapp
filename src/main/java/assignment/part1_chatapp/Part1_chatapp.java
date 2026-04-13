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
         Login login = new Login();

        System.out.println("=== REGISTER ===");
        String registerMessage = login.registerUser();
        System.out.println(registerMessage);

        if (!login.isRegistered()) {
            return;
        }

        System.out.println("\n=== LOGIN ===");
        login.loginUser();
        System.out.println(login.returnLoginStatus());
        
    }
}
