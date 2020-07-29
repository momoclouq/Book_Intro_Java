/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book3;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author cis2mye
 */

public class Book3 {

    /**
     * @param args the command line arguments
     */
    public static void randomShuffling(double[] myList){
        for (int i = 0; i < myList.length; i++){
            int j = (int)(Math.random() * myList.length);
            
            double temp = myList[i];
            myList[i] = myList[j];
            myList[j] = temp;
        }
}
    
    public static void displayArray(double[] myList){
        System.out.println("-start-");
        for (int i = 0; i < myList.length; i++){
            System.out.println(myList[i]);
        }
        System.out.println("-end-");
    }
    
    public static void displayArray(int[] myList){
        System.out.println("-start-");
        for (int i = 0; i < myList.length; i++){
            System.out.println(myList[i]);
        }
        System.out.println("-end-");
    }
    
    public static double[] reverseS(double[] myList){
        /*
        double[] reverse = new double[myList.length];
        for( int i = myList.length - 1; i >= 0; i--){
            reverse[i] = myList[myList.length - i - 1];
        }
        return reverse;
*/
        double[] reverse = new double[myList.length];
        for (int i = 0, j = myList.length - 1; i < myList.length; i++, j--){
            reverse[j] = myList[i];
        }
        return reverse;
    }
    
    public static void main(String[] args) {
        /*
        //chapter 7: single-dimension array
        //declaring array:
        //int[] array1; or int array1[];
        //elementType[] arrayRefVar[] = new elementType[arraySize];
        double[] myList = new double[10];
        
        for (int i = 0; i < 10; i++){
            myList[i] = 1;
        }
        
        //actually myList is not an array but a reference to that array
        
        //initializing arrays
        double[] myList2 = {1.9, 2.9, 3.9 ,4.9};
        //this equals: double[] myList2 = new double[4];
        //myList2[0] = 1.9; ...
        
        
        //processing arrays
        Scanner input = new Scanner(System.in);
        System.out.print("Enter " +myList.length + " values: ");
        for (int i = 0; i < 10; i++){
            myList[i] = Math.random() * 100;
        }
        
        //displaying an array
        System.out.println("array: ");
        for (int i = 0; i < 10; i++)
            System.out.println(myList[i]);
        //tips: array with char type can be printed by only one println
        
        //find the smallest index of the largest element in the array
        double max = 0;
        int smallest = -1;
        for (int i = 0; i < 10; i++){
            if (myList[i] > max) {
                max = myList[i];
                smallest = i;
            } 
        }
        System.out.println("The largest element is: " + max + " at the " + smallest + "th index.");
        
        //array shuffling
        randomShuffling(myList);
        displayArray(myList);
        
        //foreach loop
        for (double e : myList){
            e = e + 1.0;
        }
        displayArray(myList);
        
        int x = 30;
        double[] myList3 = new double[x];
        x = 50;
        System.out.println("length = " + myList3.length);
        
        int k = (int)(Math.random() * myList.length);
        System.out.println("k = " + k + " and myList[k] = " + myList[k]);
        
        
        //copying arrays
        //3 ways: use a for loop, use System.arraycopy, use the clone() method.
        
        double[] myList4 = new double[10];
        System.arraycopy(myList, 0, myList4, 0, 10);
        displayArray(myList4);
        
        //returning an array from a method
        displayArray(reverseS(myList));
        
        //count the occurence of characters in an 100-element array
        //book
        
        //variable-length argument lists
        //you can pass a variable number of arguments of the same type to a method.
        //typeName... parameterName
        //only one varaible-length parameter may be specified in a method and it must be the last parameter.
        VarArgsDemo test1 = new VarArgsDemo();
        test1.printk();
        
        //linear search
        int[] list = {1,2,3,4,12,535,0,-1,3,5};
        System.out.println("Answer: " + LinearSearch.linearSearch(list, 12));
        System.out.println("Answer: " + LinearSearch.linearSearch(list, 32));
        
        //binary search
        Arrays.sort(list);
        System.out.println("Answer1: " + BinarySearch.binarySearch(list,12));
        System.out.println("Answer1: " + BinarySearch.binarySearch(list,32));
        
        //selectionSort
        System.out.println("After sorting: ");
        SelectionSort.selectionSort(list);
        displayArray(list);
        
        //Arrays class
        //using java.util.Arrays class/util
        int[] list1 = {1,2,3,4,5,6,1};
        Arrays.sort(list);
        Arrays.sort(list, 1, 3);//sort from [1] to [3-1]
        Arrays.binarySearch(list, 11);
        Arrays.equals(list, list1);
        System.out.println(Arrays.toString(list));
        
        //you can create a main method in other classes and use it!, can pass arguements also (String[])
        */
        //chapter 8: multi-dimension array
        //syntax: elementType[][] arrayRefVar;
        
        int[][] matrix = new int[5][5];
        int[][] array2a = {{1,2,3},{4,5,6}, { 7,8,9},{10,11,12}};
        //is this equivalent to int[][] array2a = new int[4][3];
        
        //length of a multi-dimension array is the the first number: new int[4][3][2] -> .length = 4
        
        //ragged array: two-dimensional array with different-sized subarray
        int[][] triangleArray = new int[5][];
        triangleArray[0] = new int[5];
        triangleArray[1] = new int[4];
        triangleArray[2] = new int[3];
        triangleArray[3] = new int[2];
        triangleArray[4] = new int[1];
         
        int[][] arraytest = new int[5][6];
        int[] s1 = {1,2,4,5,6,8,9,2,1};
        arraytest[0] = s1;
        System.out.println("0,1: " + arraytest[0][1]);
        System.out.println("0,1: " + arraytest[0][2]);
        //conclusion: when just initialized as new int[5][6], the sub array is not fixed, when passed an actual array, it will a fixed size
        
        
    }
    
}
