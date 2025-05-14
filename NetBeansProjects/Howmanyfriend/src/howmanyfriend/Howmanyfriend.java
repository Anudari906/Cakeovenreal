/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package howmanyfriend;

import inpututilities.InputUtilities;

/**
 *
 * @author anudari
 */
public class Howmanyfriend {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String userName;
        int numFriends; 
        
        InputUtilities myInput = new InputUtilities();
        
        userName = myInput.askUserForText("What is your name?"); 
        
        numFriends = myInput.askUserForInt("How many friends do you have");
        
        System.out.println("Hello "+ userName + " You have "+ numFriends);
    }
    
}
