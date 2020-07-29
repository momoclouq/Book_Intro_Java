/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book3_exercise;

import java.util.Scanner;

/**
 *
 * @author cis2mye
 */
public class ex3_4 {
    public static void ex3(){
        Scanner terminal = new Scanner(System.in);
        Scanner input;
        
        int[] array = new int[50];
        for (int e : array) e = 0;
        
        System.out.println("Enter the integers between 1 and 50: ");
        
        input = new Scanner(terminal.nextLine());
        while(input.hasNext()){
            int in = Integer.parseInt(input.next());
            if (in == 0) break;
            array[in-1]++;
        }
        
        for (int i = 0; i < 50; i++){
            if (array[i] != 0) System.out.println((i+1) + " occurs " + array[i] + " times");
        }
    }
    
    public static void ex4(){
        Scanner terminal = new Scanner(System.in);
        Scanner input;
        
        System.out.println("Enter x number of scores: ");
        input = new Scanner(terminal.nextLine());
        
        int count = 0;
        int total = 0;
        
        int[] array = new int[100];
        
        while (input.hasNext()){
            String in = input.next();
            if (Integer.parseInt(in) < 0) break;
            array[count] = Integer.parseInt(in);
            total = total + Integer.parseInt(in);
            count++;
            if (count >= 100) break;
        }
        
        double average = (double) total / (count);
        System.out.println("----------------- aver: " + average);
        for (int i = 0; i < count; i++){
            if (array[i] < average) System.out.println("Element " + i + " is lesser than average");
            if (array[i] == average) System.out.println("Element " + i + " is equal to average");
            if (array[i] > average) System.out.println("Element " + i + " is higher than average");
        }
    }
}
