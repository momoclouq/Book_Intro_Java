/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author cis2mye
 */
public class Exercises {
    public static void main(String[] args){
        //maxArrayList test = new maxArrayList();
        //test.start();
        //shuffleArrayList.start();
        //E11_9.start();
                //E11_11.start();
       //perfectSquare.start();
       //E11_18.start();
       //E11_19.start();
    }
}

class Triangle extends GeometricObject{
    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;
    
    Triangle(){
        
    }
    
    Triangle(double side1, double side2, double side3) throws IllegalTriangleException{
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;   
    }
    
    public double getSide1(){
        return side1;
    }
    
    public double getSide2(){
        return side2;
    }
    
    public double getSide3(){
        return side3;
    }
    
    public double getArea(){
        double s = (side1 + side2 + side3) / 2;
        
        double area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
        return area;
    }
    
    public double getPerimeter(){
        return (side1 + side2 + side3);
    }
    
    @Override
    public String toString(){
        return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;
    }
}

class MyDate{
    private int year;
    private int month;
    private int day;
    
    public MyDate(){
        GregorianCalendar calendar = new GregorianCalendar();
        this.year = calendar.get(GregorianCalendar.YEAR);
        this.month = calendar.get(GregorianCalendar.MONTH);
        this.day = calendar.get(GregorianCalendar.DAY_OF_MONTH);
    }
    
    public MyDate(long elapsedTime){
        GregorianCalendar newC = new GregorianCalendar();
        newC.setTimeInMillis(elapsedTime);
        this.year = newC.get(GregorianCalendar.YEAR);
        this.month = newC.get(GregorianCalendar.MONTH);
        this.day = newC.get(GregorianCalendar.DAY_OF_MONTH);
    }
    
    public MyDate(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }
    
    //getters
    public int getMonth(){
        return month;
    }
    
    public int getYear(){
        return year;
    }
    
    public int getDay(){
        return day;
    }
    
    public void setDate(long elapsedTime){
        GregorianCalendar newC = new GregorianCalendar();
        newC.setTimeInMillis(elapsedTime);
        this.year = newC.get(GregorianCalendar.YEAR);
        this.month = newC.get(GregorianCalendar.MONTH);
        this.day = newC.get(GregorianCalendar.DAY_OF_MONTH);
    }
    
    @Override
    public String toString(){
        return day + "\\" + month + "\\" + year;
    }
}

class Person{
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    
    public Person(){
        
    }
    
    public Person(String name){
        this.name = name;
    }
}

class Student extends Person{
    private String classStatus;
    private final String s1 = "freshman";
    private final String s2 = "sophomore";
    private final String s3 = "junior";
    private final String s4 = "senior";
    
    public Student(){
        
    }
    
    public Student(String name, int status){
        super(name);
        if (status == 1) this.classStatus = s1;
        if (status == 2) this.classStatus = s2;
        if (status == 3) this.classStatus = s3;
        if (status == 4) this.classStatus = s4;
    }
}

class Employee extends Person{
    private String office;
    private double salary;
    private MyDate dateHired;
    
    public Employee(){
        
    }
    
    public Employee(String name, String office){
        super(name);
        this.office = office;
    }
}

class Faculty extends Employee{
    private String rank;
    private double officeHours;
    
    public Faculty(){
        
    }
    
    public Faculty(String name, String office, String rank){
        super(name, office);
        this.rank = rank;
    }
}

class Staff extends Employee{
    private String title;
    
    public Staff(){
        
    }
    
    public Staff(String name, String office, String title){
        super(name, office);
        this.title = title;
    }
}

class maxArrayList{
    public static void start(){
        ArrayList<Integer> list = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the numbers, end with 0:");
        int value;
        value = input.nextInt();

        while (value != 0){
                list.add(value);
                value = input.nextInt();
            }
        
        System.out.println("The max value: " + max(list));
    }
    
    public static Integer max(ArrayList<Integer> list){
        if (list.isEmpty() || list.size() == 0) return null;
        Integer output = list.get(0);
        
        for (Integer item: list){
            if (item.compareTo(output) > 0) output = item;
        }
        
        return output;
    }
}

class shuffleArrayList{
    public static void start(){
        //initial preparation
        Integer[] array = new Integer[100];
        for (int i = 0; i <array.length; i++){
            array[i] = i;
        }
        
        //the program
        ArrayList<Integer> output = new ArrayList<>(Arrays.asList(array));
        shuffle(output);
        System.out.println(output.size());
        System.out.println(output);
    }
    
    public static void shuffle(ArrayList<Integer> output){
        int size = output.size();
        ArrayList<Integer> temp = new ArrayList<>();
        while (temp.size() < size){
            int position = (int)(Math.random() * (output.size()));
            temp.add(output.get(position));
            output.remove(position);
        }
        output.addAll(temp);
    }
}

class E11_9{
    public static void start(){
        System.out.print("Enter the array size: ");
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        
        //set up the matrix
        int[][] matrix = new int[size][size];
        
        for (int r = 0; r < size; r++){
            for (int c = 0; c < size; c++){
                int value = (int) (Math.random() * 2);
                if (value < 1) value = 0;
                else value = 1;
                
                matrix[r][c] = value;
                System.out.print(value + " ");
            }
            System.out.println();
        }
        
        //set up the arraylist
        ArrayList<Integer> numR = new ArrayList<>();
        ArrayList<Integer> numC = new ArrayList<>();
        setUp(numR, size);
        setUp(numC, size);
        
        for (int r = 0; r < size; r++){
            for (int c = 0; c < size; c++){
                if (matrix[r][c] == 1) {
                    numC.set(c, numC.get(c) + 1);
                    numR.set(r, numR.get(r) + 1);
                }
            }
        }
        
        findMax(numC, "column");
        findMax(numR, "row");
        
    }
    
    public static void findMax(ArrayList<Integer> num, String descript){
        Integer max = 0;
        ArrayList<Integer> output = new ArrayList<>();
        
        for (int i = 0; i< num.size(); i++){
            if (num.get(i).compareTo(max) > 0) max = num.get(i);
        }
        
        for (int i = 0; i < num.size(); i++){
            if (num.get(i).compareTo(max) == 0) output.add(i);
        }
        
        System.out.println(descript + ": " + output + "-" + max);
    }
    
    public static void setUp(ArrayList<Integer> num, int size){
        for (int i = 0; i<size; i++)
            num.add(0);
    }
}

class E11_11{
    public static void start(){
        ArrayList<Integer> list = new ArrayList<>();
        
        System.out.print("Enter 5 numbers: ");
        Scanner input = new Scanner(System.in);
        
        int count = 5;
        while (count >= 1){
            int value = input.nextInt();
            list.add(value);
            count--;
        }
        System.out.println(list);
        removeDuplicate(list);
        System.out.println(list);
        
    }
    
    public static void sort(ArrayList<Integer> list, int choice){
        Integer[] array = new Integer[list.size()];
            list.toArray(array);
        
        if (choice == 0){
            Arrays.sort(array);
            list.clear();
            list.addAll(new ArrayList<>(Arrays.asList(array)));
        }
        
        if (choice == 1){
            Arrays.sort(array, Collections.reverseOrder());
            list.clear();
            list.addAll(new ArrayList<>(Arrays.asList(array)));
        }
    }
    
    public static int sum(ArrayList<Integer> list){
        int sum = 0;
        for (Integer item: list)
            sum = sum + item;
        return sum;
    }
    
    public static void removeDuplicate(ArrayList<Integer> list){
        ArrayList<Integer> temp = new ArrayList<>();
        
        for (Integer item: list){
            if (!temp.contains(item)) temp.add(item);
        }
        
        list.clear();
        list.addAll(temp);
    }
}

class perfectSquare{
    public static void start(){
        System.out.print("Enter an integer number: ");
        Scanner input = new Scanner(System.in);
        
        int number = input.nextInt();
        input.nextLine();
        
        System.out.println("The smallest number n for m * n to be a perfect square is " + findN(number));
        System.out.println("m * n = " + (number * findN(number)));
    }
    
    public static int findN(int number){
        ArrayList<Integer> primeList = new ArrayList<>();
        ArrayList<Integer> countPrime = new ArrayList<>();
        calculateMaxPrime(primeList, countPrime, number);
        
        int result = 1;
        if (primeList.size() == countPrime.size()){
            for (int i = 0; i < primeList.size(); i++){
                if (countPrime.get(i) % 2 == 1) result = result * primeList.get(i);
            }
        }
        
        System.out.println(primeList);
        System.out.println(countPrime);
        
        return result;
    }
    
    public static void calculateMaxPrime(ArrayList<Integer> primeList, ArrayList<Integer> countPrime, int number){
        int temp = number;
        boolean numIsPrime = false;
        
        //get the primelist
        for (int i = 2; i < number; i++){
            if (isPrime(i) && temp % i == 0) {
                countPrime.add(0);
                primeList.add(i);
            }
            
            while(isPrime(i) && (temp % i == 0)){
                countPrime.set(countPrime.size() - 1, countPrime.get(countPrime.size() - 1) + 1);
                temp = temp / i;
            }
            if (temp == 1)
                break;
        }
        
        if (temp == number){
            countPrime.add(1);
            primeList.add(number);
        }
    }
    
    public static boolean isPrime(int number){
        for (int i = 2; i < (int)(Math.sqrt(number)) + 1; i++){
            if (number % i == 0) return false;
        }
        return true;
    }
}

class E11_18{
    public static void start(){
        String test = "abcdefghjk";
        ArrayList<Character> array = new ArrayList<>(toCharacterArray(test));
        
        System.out.println(array);
    }
    
    public static ArrayList<Character> toCharacterArray(String s){
        ArrayList<Character> temp = new ArrayList<>();
        
        for (int i = 0; i <s.length(); i++){
            temp.add(s.charAt(i));
        }
        
        return temp;
    }
}

class E11_19{
    public static void start(){
        Scanner input = new Scanner(System.in);
        //number of objects
        System.out.print("Enter the number of objects: ");
        int objectNum = input.nextInt();
        input.nextLine();
        
        //weights
        ArrayList<Integer> weights = new ArrayList<>();
        System.out.print("Enter the weights of the objects: ");
        
        for (int i = 0 ; i < objectNum; i++){
            int value = input.nextInt();
            weights.add(new Integer(value));
        }
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        algorithmX(list, weights);
        
        print(list);
    }
    
    public static void algorithmX(ArrayList<ArrayList<Integer>> list, ArrayList<Integer> weights){
        int temp = 10;
        list.add(new ArrayList<Integer>());
        
        ArrayList<Integer> tempList = new ArrayList<>(weights);
        System.out.println(tempList);
        
        while (!tempList.isEmpty()){
            ArrayList<Integer> temp2 = new ArrayList<>(tempList);
            
             for (int i = 0; i< tempList.size(); i++){
                if (temp >= tempList.get(i).intValue()){
                    temp = temp - tempList.get(i).intValue();
                    list.get(list.size() - 1).add(tempList.get(i));
                    temp2.remove(tempList.get(i));
                } 
            }
             
             tempList.clear();
             tempList.addAll(temp2);
             temp = 10;
             list.add(new ArrayList<Integer>());
        }
        
        list.remove(list.size() - 1);
    }
    
    public static void print(ArrayList<ArrayList<Integer>> list){
        for (int i = 0; i < list.size(); i++){
            System.out.println("Container " + (i+1) + " contains objects with weight " + list.get(i));
        }
    }
}