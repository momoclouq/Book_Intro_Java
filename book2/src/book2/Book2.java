/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book2;

import java.util.Scanner;

/**
 *
 * @author cis2mye
 */
public class Book2 {

    /**
     * @param args the command line arguments
     */
    public static int max(int num1, int num2){
        int result;
        if(num1 > num2)
            result = num1;
        else result = num2;
        return result;
    }
    
    public static void intInput(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number 1: ");
        int num1 = input.nextInt();
        
        System.out.print("Enter number 2:");
        int num2 = input.nextInt();
        
        System.out.println("Max: " + max(num1, num2));
    }
    
    public static int hexToDecimal(String hex){
        int decimalValue = 0;
        for (int i =0; i < hex.length(); i++){
            char hexChar = hex.charAt(i);
            decimalValue = decimalValue * 16 + hexCharToDecimal(hexChar);
        }
        return decimalValue;
    }
    
    public static int hexCharToDecimal(char ch){
        if (ch >= 'A' && ch <= 'F')
            return 10 + ch - 'A';
        else return ch - '0';
    }
    
    public static double max(double a1, double a2){
        if (a1 > a2) return a1;
        else return a2;
    }
    
    public static void main(String[] args) {
        //chapter 6: methods
        intInput();
        //in java there is only call by value
        
        //case study: converting hexadecimals to decimals
        Scanner scan = new Scanner(System.in);
        boolean conti = true;
        while(conti){
            String hex;
            System.out.print("Please enter hex number: ");
            hex = scan.nextLine();
            System.out.println("Answer: " + hexToDecimal(hex));
            System.out.print("Continue? (Y/n)");
            hex = scan.nextLine();
            if (hex.equals("N") || hex.equals("n")) break; 
        }
        
        //overloading method
        //methods with same names but different arguments
        
        //scope of variable: local or global variables
        
        //case study: generating random characters
        final int NUMBER_OF_CHARS = 175;
        final int CHARS_PER_LINE = 25;
        
        for(int i = 0; i < NUMBER_OF_CHARS; i++){
            char ch = RandomCharacter.getRandomLowerCaseLetter();
            if((i + 1) % CHARS_PER_LINE == 0)
                System.out.println(ch);
            else System.out.print(ch);
        }
        
        
        System.out.println("This is the end of book2");
    }
    
}
