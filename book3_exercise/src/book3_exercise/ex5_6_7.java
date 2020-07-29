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
public class ex5_6_7 {
    public static void ex5(){
        Scanner terminal = new Scanner(System.in);
        Scanner input;
        
        System.out.println("Enter numbers: ");
        
        input = new Scanner(terminal.nextLine());
        int odd = 0;
        int even = 0;
        
        
        while(input.hasNext()){
            try {
                int in = Integer.parseInt(input.next());
                if (in == 0) break;
            if (in % 2 == 0) even++;
            if (in % 2 == 1) odd++;
            } catch (NumberFormatException e){
            }
        }
        
        System.out.println("Odd: " + odd);
        System.out.println("Even: "+ even);
    }
    
    
    public static void ex6(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the limit: ");
      
        int limit = input.nextInt();
        boolean[] flag = new boolean[limit+1];
        
        for (int i = 0; i < limit + 1; i++) flag[i] = true;
        
        for (int i = 2; i <= limit; i++){
            for (int k = 2; k < i; k++) if (i % k == 0) flag[i] = false;
        }
        
        for (int i = 0; i < limit+1; i++){
            if (flag[i]) System.out.println((i) + " is prime!");
        }
        
        System.out.println("Not!");
    }
    
    public static void ex7(){
        Scanner input = new Scanner(System.in);
        System.out.println("Start?");

        while(true){
            String what = input.nextLine();
            if(what.charAt(0) == 'Y' || what.charAt(0) == 'y') break;
            System.out.println("Start?");
        }
        
        int[] array = new int[10];
        int count = 200;
        while (count > 0){
            int value = (int) (Math.random() * 10);
            array[value]++;
            count--;
        }
        
        int sum = 0;
        for(int e : array){
            System.out.print("-" + e);
            sum = sum + e;
        }
        
        System.out.println(" ssss: " + sum);
    }
    
    //exercise 7.8
    public static int average (int[] array){
        Scanner terminal = new Scanner(System.in);
        Scanner input;
        
        System.out.println("Enter values (10 maximum): ");
        input = new Scanner(terminal.nextLine());
        
        int count = 0;
        int total = 0;
        while(input.hasNext()){
            int in = input.nextInt();
            array[count] = in;
            total = total + array[count];
            count++;
            if (count == 10) break;
        }
        
        return (total / count);
    }
    
    public static double average (double[] array){
        Scanner terminal = new Scanner(System.in);
        Scanner input;
        
        System.out.println("Enter values (10 maximum): ");
        input = new Scanner(terminal.nextLine());
        
        int count = 0;
        double total = 0;
        while(input.hasNext()){
            double in = input.nextDouble();
            array[count] = in;
            total = total + array[count];
            count++;
            if (count == 10) break;
        }
        
        return (total / count);
    }
    
    //exercise 7.9 done
    //public static double max(double[] array)
    
    //exercise 7.10
    public static int indexOfLargestElement (double[] array){
        Scanner terminal = new Scanner(System.in);
        Scanner input;
        
        System.out.println("Enter the values: ");
        input = new Scanner(terminal.nextLine());
        
        int count = 0;
        int best = 0;
        while(input.hasNext()){
            int in = input.nextInt();
            array[count] = in;
            if (array[count] >= array[best]) best = count;
            count++;
            if (count >= 10) break;
        }
        
        return best+1;
    }
    
    //exercise 7.11
    //done
    
    //exercise 7.12
    public static double[] reverse(double[] array){
        Scanner terminal = new Scanner(System.in);
        Scanner input;
        
        System.out.println("Enter the values: ");
        input = new Scanner(terminal.nextLine());
        
        int count = 0;
        while(input.hasNext()){
            double in = input.nextDouble();
            array[count] = in;
            count++;
            if (count >= 10) break;
        }
        
        //reverse
        for(int i = count - 1; i >= (count/2); i--){
            double temp = array[i];
            array[i] = array[count - 1 - i];
            array[count - 1 -i] = temp;        
         }
        
        //show array
        for (int i = 0; i < count; i++){
            System.out.print("-" + array[i]);
        }
        
        return array;
    }
    
    //7.13
    public static int getRandom(int... numbers){
        return numbers[(int)(Math.random() * numbers.length)];
    }
    
}
