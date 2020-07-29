/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book3_exercise;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author cis2mye
 */
public class allEx {
    //ex15
    public static boolean searchArray(int value,int count, int[] list){
        for (int i = 0; i <  count; i++){
            if(value == list[i]) return true;
        }
        return false;
    }
    
    public static int binarySearch(int[] list, int key){
        int low = 0;
        int high = list.length - 1;
        
        while (high >= low){
            int mid = (low + high) / 2;
            if (list[mid] == key) return mid;
            if (list[mid] < key) low = mid + 1;
            if (list[mid] > key) high = mid - 1;
        }
        
        return -1;
    }
    
    public static int linearSearch(int[] list, int key){
        for (int i = 0; i < list.length; i++){
            if (key == list[i])
                return i;
        }
        return -1;
    }
    
    public static int[] eliminateDuplicates(int[] list){
        int[] array = new int[10];
        Scanner terminal = new Scanner(System.in);
        Scanner input;
        
        System.out.println("Enter: ");
        input = new Scanner(terminal.nextLine());
        
        int count1 = 0;
        int count2 = 0;
        while(input.hasNextInt()){
            int in = input.nextInt();
            list[count1] = in;
            if(!searchArray(in, count2, array)){
                array[count2] = in;
                count2++;
            }
            count1++;
            if(count1 >= 10) break;
        }
        
        return array;
    }
    
    //ex16
    public static void display1(int[] list, int value){
         long startTime1 = System.nanoTime();
         
         linearSearch(list, value);
         
         long endTime1 = System.nanoTime();
         long executionTime1= endTime1 -startTime1;
         
         long startTime2 = System.nanoTime();
         
         binarySearch(list, value);
         
         long endTime2 = System.nanoTime();
         long executionTime2 = endTime2 - startTime2;
         
         System.out.println("1. Result for " + value + " is: " + executionTime1);
         System.out.println("2. Result for " + value + " is: " + executionTime2);
         
    }
    
    public static void ex16(){
        int[] array = new int[100000000];
        
        for (int i = 0; i < array.length; i++){
            array[i] = i+1;
        }
        
       display1(array, 1);
       display1(array, 25000000);
       display1(array, 50000000);
       display1(array, 75000000);
       display1(array, 100000000);
        
        
    }
    
    //ex17
    public static void selectionSortUpdate(int[] list1, String[] list2){
        for (int i = 0; i < list1.length; i++){
            int temp = i;
            
            for (int k = i + 1 ; k < list1.length; k++){
                if (list1[k] < list1[temp]) temp = k;
            }
            
            int temp1 = list1[i];
            list1[i] = list1[temp];
            list1[temp] = temp1;
            
            String temp2 = list2[i];
            list2[i] = list2[temp];
            list2[temp] = temp2;
        }         
    }
    
    public static void ex17(){
        Scanner terminal = new Scanner(System.in);
        Scanner input;
        
        System.out.println("Enter the number of students: ");
        int number = terminal.nextInt();
        terminal.nextLine();
        
        System.out.println("Now enter the students and their scores (in a line): " );
        int count = 0;
        
        String[] names = new String[number];
        int[] scores = new int[number];
        
        while (count < number){
            input = new Scanner(terminal.nextLine());
            String name = input.next();
            int score = input.nextInt();
            
            names[count] = name;
            scores[count] = score;
            count++;
        }
        
        selectionSortUpdate(scores, names);
        
        for (int i = 0; i < number; i++){
            System.out.println("Student " + names[i] + " has score " + scores[i]);
        }
    }
    
    //ex18
    public static void swap(int[] list,int beg, int end){
        int temp = list[beg];
        list[beg] = list[end];
        list[end] = temp;
    }
    
    public static void bubbleSort(int[] list, int count){
        for (int i = 0; i < count; i++){
            for (int k = i; k < count - 1; k++) if(list[k] > list[k+1]) swap(list, k, k+1);
        }
    }
    
    public static void ex18(){
        Scanner terminal = new Scanner(System.in);
        Scanner input;
        
        System.out.println("Enter the elements: ");
        input = new Scanner(terminal.nextLine());
        
        int count = 0;
        int[] list = new int[10];
        while(input.hasNext()){
            int in = input.nextInt();
            list[count] = in;
            count++;
            if(count >= 10) break;
        }
        
        bubbleSort(list, count);
        
        System.out.println("result: " + Arrays.toString(list));
    }
    
    //ex19
    public static int getList(int[] list){
         Scanner terminal = new Scanner(System.in);
        Scanner input;
        
        System.out.println("Enter the elements: ");
        input = new Scanner(terminal.nextLine());
        
        int count = 0;
        while(input.hasNext()){
            int in = input.nextInt();
            list[count] = in;
            count++;
            if(count >= 10) break;
        }
        
        return count;
    }
    
    public static boolean isSorted(int[] list, int count){
        for (int i = 0; i < count - 1; i++) if(list[i] < list[i+1]) return false;
        return true;
    }
    
    public static void ex19(){
        int[] list = new int[10];
        int count = getList(list);
        System.out.println("LIst: " + Arrays.toString(list));
        
        if (isSorted(list, count)) System.out.println("Yes, sorted");
        else System.out.println("NO!");
    }
    
    public static void ex21(){
        Scanner terminal = new Scanner(System.in);
        Scanner input;
        
        System.out.println("Enter the elements: ");
        input = new Scanner(terminal.nextLine());
        
        int count = 0;
        double max = 0;
        
        double[] list = new double[10];
        while(input.hasNext()){
            int in = input.nextInt();
            list[count] =(double) in;
            if (list[count] > max) max = list[count];
            count++;
            if(count >= 10) break;
        }
        
        for (int i = 0; i < count; i++){
            list[i] = list[i] / max;
            System.out.println("-" + list[i]);
        }
    }
    
    public static void ex22(){
        Scanner terminal = new Scanner(System.in);
        
        System.out.println("Enter string: ");
        String input = terminal.nextLine();
        
        int result = 0;
        char[] vowels = {'a', 'o','i','u','e' , 'A','O','I','U','E'};
        for (int i = 0; i < input.length(); i++){
            for (char k : vowels){
                if (input.charAt(i) == k) result++;
            }
        }
        
        System.out.println("result: " + result);
    }
    
    public static void ex23(){
        boolean[] lockers = new boolean[100];
        
        for (boolean locker : lockers) locker = false;
        
        //algorithm
        for (int i = 0; i < 100; i++){
            int index = i;
            while (index < 100){
                lockers[index] = !lockers[index];
                index = index + (i + 1);
            }
        }
        
        //output
        for (int i = 0; i < lockers.length; i++){
            if (lockers[i]) System.out.print(" " + i);
        }
    }
    
    public static void ex24(){
        String[] suits = {"Spades" , " Clubs", "Hearts", "Diamonds"};
        String[] faces = {"2", "3" ,"4" ,"5","6", "7", "8", "9" , "10", "J", "Q", "K","A"};
        boolean[] found = new boolean[4];
        
        for (boolean e : found) e = false;
        
        int count = 0;
        int times = 0;
        while(count < 4){
            int card =(int)(Math.random() * 52);
            
            int suitsk = card / 13;
            int facesk = card % 13;
            
            if(!found[suitsk]) {
                System.out.println(faces[facesk] + " of " + suits[suitsk]);
                found[suitsk] = true;
                count++;
            }
            
            times++;
        }
        
        System.out.println("Array: " + Arrays.toString(found));
        System.out.println("Number of picks: " + times);
    }
    
    //ex26
    public static boolean isSorted(int[] list){
        
        for (int i = 0; i< list.length - 1; i++){
            if (list[i] > list[i+1]) return false;
        }
        
        return true;
    }
    
    //ex27
    public static boolean isSortedConstant(int[] list){
        
        if (list.length < 2) return true;
        if (list[1] - list[0] < 0) return false;
        int interval = list[1] - list[0]; 
        
        for (int i = 1; i< list.length - 1; i++){
            if (list[i+1] - list[i] != interval) return false;
        }
        
        return true;
    }
    
    //ex28
    public static boolean checkall(boolean[] checked){
        for (int i = 0; i < checked.length; i++){
            if (!checked[i]) return false;
        }
        return true;
    }
    
    public static void printwhat(int times, int count, int[] list, boolean[] checked, int[] value){
        if (times != 0) 
        for (int i = 0; i < count; i++){
            if (!checked[i]) {
                value[count - times] = list[i];
                checked[i] = true;
                if (checkall(checked)) System.out.println(Arrays.toString(value));
                printwhat(times - 1, count, list, checked, value);
                checked[i] =false;
            }
        }
    }
    
    public static void ex28(){
        int[] list = new int[10];
        int count = getList(list);
        
        boolean[] checked = new boolean[count];
        int[] value = new int[count];
        
        for (int i = 0; i < count; i++) checked[i] = false;       
        
        
        printwhat(count, count, list, checked, value);
    }
}
