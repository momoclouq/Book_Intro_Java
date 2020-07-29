/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter10;

import java.util.Scanner;

/**
 *
 * @author cis2mye
 */
public class PalindromeIgnoreNonAlphanumeric {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String s = input.nextLine();
        
        System.out.println("Ignoring nonalphanumeric characters, \nis " + s + " a palindrome? " + isPalindrome(s));
    }
    
    public static boolean isPalindrome(String s){
        String s1 = filter(s);
        String s2 = reverse(s1);
        return s2.equals(s1);
    }
    
    public static String filter(String s){
        StringBuilder stringBuilder = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++){
            if (Character.isLetterOrDigit(s.charAt(i))){
                stringBuilder.append(s.charAt(i));
            }
        }
        
        return stringBuilder.toString();
    }
    
    public static String reverse(String s){
        StringBuilder stringBuilder = new StringBuilder(s);
        stringBuilder.reverse();
        return stringBuilder.toString();
    }
}
