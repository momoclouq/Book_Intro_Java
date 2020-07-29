/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book3_exercise;

import static java.lang.Character.isDigit;
import java.util.Scanner;

/**
 *
 * @author cis2mye
 */
public class ex1 {
    
    public static boolean checkStringInt(String input){
        for (int i = 0; i < input.length(); i++){
            if (!isDigit(input.charAt(i))) return false;
        }
        return true;
    }
    
    public static void run(){
        Scanner input = new Scanner(System.in);
        Scanner wholestring;
        
        /*
        //input for number of students
        int numstu = 0;
        System.out.println("Enter the number of students: ");
        while(true){
            if (input.hasNextInt()) {
                numstu = input.nextInt();
                break;
            }
            System.out.println("Wrong input! Enter the number again: ");
            input.nextLine();
        }
        input.nextLine();
        
        //create an array to store the scores
        int[] scores = new int[numstu];
        
        //Enter input numbers and get the best score
        int best = 0;
        System.out.println("Enter " + numstu + " scores: ");
        System.out.println("Every students that dont have a score will be assigned as 0!");

       wholestring = new Scanner(input.nextLine());
       int count = 0;
       
       while(wholestring.hasNext() && count < numstu){
           String in = wholestring.next();
           if (!checkStringInt(in)) {
               System.out.println("Wrong input! Try again: ");
               count = 0;
               wholestring = new Scanner(input.nextLine());
           }
           else {
               scores[count] = Integer.parseInt(in);
               if (best < scores[count]) best = scores[count];
               count++;
           }
          
       }
       
       for (int i = count; i< numstu; i++){
           scores[i] = 0;
       }
        
        //get the best score
        for (int i = 0; i < numstu; i++){
            char grade;
            if (scores[i] >= best - 5) grade = 'A';
            else if (scores[i] >= best - 10) grade = 'B';
            else if (scores[i] >= best - 15) grade = 'C';
            else if (scores[i] >= best - 20) grade = 'D';
            else grade = 'F';
            
            System.out.println("Student " + (i+1) + " score is " + scores[i] + " and grade is "+ grade);
        }
        */
        //exercise 2
        //input.nextLine();
        int[] number2 = new int[11];
        System.out.println("enter 11 numbers in a line: ");
        
        for (int i = 0; i < 10; i++){
            number2[i] = input.nextInt();
        }
        
        int value = input.nextInt();
        input.nextLine();
        number2[10] = value;
        
        for (int i = 0; i < 11; i++){
            if (number2[i] > value) System.out.println("element "+ (i+1) + " is larger");
            if (number2[i] == value) System.out.println("element "+ (i+1) + " is equal");
            if (number2[i] < value) System.out.println("element "+ (i+1) + " is lesser");
        }
    }
}
