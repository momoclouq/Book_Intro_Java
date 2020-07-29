/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter10;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author cis2mye
 */
public class Exercises {
    public static void main (String[] args){
        /*
        Time now = new Time();
        System.out.println(now);
        now = new Time(555550000);
        System.out.println(now);
        now.setTime(1111110);
        System.out.println(now);
        
        MyPoint point1 = new MyPoint(1,2);
        MyPoint point2 = new MyPoint(4,5);
        System.out.println("Dis: " + MyPoint.distance(point1, point2));
        
        primeFactor.start();
        displayPrime.start();
*/
        
        /*
        ATM atm = new ATM();
        atm.start();
*/
        /*
        Queue queue = new Queue();
        for (int i = 1; i<=20;i++){
            queue.enqueue(i);
        }
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);
        
        MyDate day1 = new MyDate();
        MyDate day2 = new MyDate(1);
        System.out.println(day1);
        System.out.println(day2);
*/
        //divisibleBy23.start();
        
        //findSquare.start();
        
        //findPrime.start();
        
        //approximateE.start();
        
        
    }
}

//10.1
class showCurrentTime {
    private long millis;
    private long totalSecond;
    private long currentSecond;
    private long totalMinute;
    private long currentMinute;
    private long totalHour;
    private long currentHour;
    
    public showCurrentTime(long millis){
        this.millis = millis;
        
        totalSecond = this.millis / 1000;
        currentSecond = totalSecond % 60;
        totalMinute = totalSecond / 60;
        currentMinute = totalMinute % 60;
        totalHour = totalMinute / 60;
        currentHour = totalHour % 24;
    }
    
    public long getSecond(){
        return currentSecond;
    }
    
    public long getMinute(){
        return currentMinute;
    }
    
    public long getHour(){
        return currentHour;
    }
}

class Time{
    private long hour;
    private long minute;
    private long second;
    
    public Time(){
        showCurrentTime time = new showCurrentTime(System.currentTimeMillis());
        hour = time.getHour();
        minute = time.getMinute();
        second = time.getSecond();
    }
    
    public Time(long millis){
         showCurrentTime time = new showCurrentTime(millis);
        hour = time.getHour();
        minute = time.getMinute();
        second = time.getSecond();
    }
    
    public Time(long hour, long minute, long second){
        
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }
    
    public long getHour(){
        return hour;
    }
    
    public long getMinute(){
        return minute;
    }
    
    public long getSecond(){
        return second;
    }
    
    public void setTime(long elapseTime){
        showCurrentTime time = new showCurrentTime(elapseTime);
        hour = time.getHour();
        minute = time.getMinute();
        second = time.getSecond();
    }
    
    @Override
    public String toString(){
        return hour + ":" + minute + ":" + second;
    }
}

class MyInteger{
    private int value;
    
    public MyInteger(int value){
        this.value = value;
    }
    
    public boolean isEven(){
        return value % 2 == 0;
    }
    
    public boolean isOdd(){
        return !isEven();
    }
    
    public boolean isPrime(){
        for (int i = 2; i < (int) (Math.sqrt(value)); i++) if (value % i == 0) return false; 
        return true;
    }
    
    public static boolean isEven(int x){
        return x % 2 == 0;
    }
    
    public static boolean isOdd(int x){
        return !isEven(x);
    }
    
    public static boolean isPrime(int x){
         for (int i = 2; i < (int) (Math.sqrt(x)); i++) if (x % i == 0) return false; 
        return true;
    }
    
    public boolean equals(int value){
        return this.value == value;
    }
    
    public boolean equals(MyInteger x){
        return this.value == x.value;
    }
    
    public static int parseInt(char[] array){
        String resultS = new String(array);
        return Integer.parseInt(resultS);
    }
}

class MyPoint{
    private int x;
    private int y;
    
    public MyPoint(){
        x = 0;
        y = 0;
    }
    
    public MyPoint(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public double distance(MyPoint point){
        return Math.sqrt(Math.pow(this.x - point.x, 2) + Math.pow(this.y - point.y, 2));
    }
    
    public static double distance(MyPoint point1, MyPoint point2){
        return Math.sqrt(Math.pow(point1.x - point2.x, 2) + Math.pow(point1.y - point2.y, 2));
    }
}

class primeFactor{
    public static void start(){
        int number;
        int temp;
        StackOfIntegers stack = new StackOfIntegers();
        
        System.out.print("enter the number: ");
        Scanner input = new Scanner(System.in);
        number = Integer.valueOf(input.nextLine());
        temp = number;
        
        int num = 2;
        while (temp > 1){
                num = nextPrime(num, temp);
                temp = temp / num;
                stack.push(num);
       }
        
        int size = stack.getSize();
        for (int i = 0; i < size; i++){
            System.out.print(stack.pop() + " ");
        }
        System.out.println("");
    }
    
    public static int nextPrime(int num, int number){
        for (int i = num; i < (int) (Math.sqrt(number)) + 1; i++){
           if (number % i == 0) return i;
        }

        return number;
    }
}

class displayPrime{
    public static void start(){
        StackOfIntegers stack = new StackOfIntegers();
        
        final int value = 120;
        
        int currentPrime = 2;
        while (currentPrime < value){
            stack.push(currentPrime);
            currentPrime = nextPrime(currentPrime);
        }
        
        for (int i = 0; i < stack.getSize(); i++){
            System.out.print(stack.pop() + " ");
        }
    }
    
    public static int nextPrime(int currentPrime){
        int value = currentPrime + 1;
        
        while (!isPrime(value)){
            value++;
        }
        
        return value;
    }
    
   public static boolean isPrime(int number){
       for (int i = 2; i < (int) (Math.sqrt(number)) + 1; i++){
           if (number % i == 0) return false;
       }
       return true;
   }
}

class ATM{
    private static Account allAcc[] = new Account[10];
    
    public static void start(){
        
        //setting up accounts
        for (int i = 0; i < allAcc.length; i++){
            allAcc[i] = new Account(i, 100);
        }
        
        //program loop
        while (true){
            System.out.print("Enter an id: ");
            Scanner input = new Scanner(System.in);
            
            //get id
            int id = getValue(0,9, input, "id");
            
            
            //get choice
            boolean Insession = true;
            while (Insession){
                displayMenu();
                int choice = getValue(1,4, input, "choice");
            
                switch(choice){
                    case 1: System.out.println("The balance is " + allAcc[id].getBalance());
                        break;
                 case 2: 
                     System.out.print("Enter the amount to withdraw: ");
                     double withdrawValue = input.nextDouble();
                     allAcc[id].withdraw(withdrawValue);
                     break;
                   case 3:
                      System.out.print("Enter the amount to deposit: ");
                     double depositValue = input.nextDouble();
                        allAcc[id].deposit(depositValue);
                        break;
                    case 4:
                        Insession = false;
                    break;
                 }
                System.out.println("");
            }
        }
    }
    
    private static int getValue(int limitX, int limitY, Scanner input,String text){
        int value = -1;
        
        while (true){
                try {
                    value = input.nextInt();
                } catch (Exception e){
                    System.out.print("Enter an " + text + ": ");
                }
                if (value != -1 && value >= limitX && value <= limitY) break;
            }
        
        input.nextLine();
        return value;
    }
    
    private static void displayMenu(){
        System.out.println("Main menu");
        System.out.println("1: check balance");
        System.out.println("2: withdraw");
        System.out.println("3: deposit");
        System.out.println("4: exit");
        System.out.print("Enter a choice: ");
    }
}

class Tax{
    private int filingStatus;
    public static final int SINGLE_FILER = 0;
    public static final int MARRIED_JOINTLY_OR_QUALIFYING_WIDOW = 1;
    public static final int MARRIED_SEPARATELY = 2;
    public static final int HEAD_OF_HOUSEHOLD = 3;
    
    private int[][] brackets;
    private double[] rates;
    private double taxableIncome;

    public Tax(){
        
    }
    
    public Tax(int filingStatus, int[][] brackets, double[] rates,double taxableIncome){
        this.filingStatus = filingStatus;
        this.brackets = brackets;
        this.rates = rates;
        this.taxableIncome = taxableIncome;
    }
    
    //too long but easy
}

class Queue{
    private int[] elements;
    private int size;
    
    public Queue(){
        elements = new int[8];
        size = 0;
    }
    
    public void enqueue(int v){
        elements[size] = v;
        size++;
        
        if (size >= elements.length){
            int[] newElements = new int[elements.length * 2];
            System.arraycopy(elements, 0, newElements, 0, elements.length);
            elements = newElements;
        }
    }
    
    public int dequeue(){
        int value = elements[0];
        
        for (int i = 0; i < size-1; i++){
            elements[i] = elements[i+1];
        }
        size--;
        return value;
    }
    
    public boolean empty(){
        return (size == 0);
    }
    
    public int getSize(){
        return this.size;
    }
    
    @Override
    public String toString(){
        String output = "";
        for (int i = 0; i < size; i++){
            output = output + elements[i] + " ";
        }
        
        return output;
    }
}

class Circle2D{
    private double x;
    private double y;
    
    private double radius;
    
    public Circle2D(){
        x = 0;
        y = 0;
        radius =1;
    }
    
    public Circle2D(double x, double y, double radius){
        this.x = x;
        this.y = y;
        this.radius =radius;
    }
    
    public double getArea(){
        return Math.PI * radius * radius;
    }
    
    public double getPerimeter(){
        return Math.PI * 2 * radius;
    }
    
    public double calLength(double x1, double y1){
        return Math.sqrt(Math.pow(x - x1, 2) + Math.pow(y - y1, 2));
    }
    
    public boolean contains(double x, double y){
        return (calLength(x,y) <= radius);
    }
    
    public boolean contains(Circle2D circle){
        return (this.radius >= circle.calLength(this.x, this.y) + circle.radius);
    }
    
    public boolean overlaps(Circle2D circle){
        return (this.radius + circle.radius >= this.calLength(circle.x, circle.y));
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

class divisibleBy23{
    
    public static void start(){
        String value = "1";
        
        for (int i = 0; i < 49; i++){
            value = value + "0";
        }
        
        BigDecimal x = new BigDecimal("1");
        BigDecimal v2 = new BigDecimal("2.0");
        BigDecimal v3 = new BigDecimal("3");
        BigDecimal v0 = new BigDecimal("0");
        
        
        int count = 0;
        while (count < 50){
            if ((x.remainder(v2)).compareTo(v0) == 0 || (x.remainder(v3)).compareTo(v0) == 0) {
                BigDecimal output = x.divide(new BigDecimal(value));
                System.out.println(output);
                count++;
            }
            x = x.add(new BigDecimal("1"));
        }
    }
}

class findSquare{
    public static void start(){
        final long limit = Long.MAX_VALUE;
        Long initialValue = (long) (Math.sqrt(limit)) + 1;
        
        BigInteger[] values = new BigInteger[5];
        BigInteger value = new BigInteger(initialValue.toString());
        
        for (int i =0; i < values.length; i++){
            values[i] = value.multiply(value);
            value = value.add(new BigInteger("1"));
            System.out.println(values[i]);
        }
        
    }
}

class findPrime{
    public static void start(){
        final Long limit = Long.MAX_VALUE;
        
        BigInteger current = new BigInteger(limit.toString());
        System.out.println(current);
        current = current.add(new BigInteger("1"));
        
        int count = 0;
        while (count < 5){
            BigInteger output = findNextPrime(current);
            current = output.add(new BigInteger("1"));
            System.out.println(output);
            count++;
        }
    }
    
    public static BigInteger findNextPrime(BigInteger current){
        while(true){
            if (isPrime(current)) return current;
            current = current.add(new BigInteger("1"));
        }
    }
    
    public static boolean isPrime(BigInteger current){
        BigInteger value = new BigInteger("2");
        while(value.compareTo(current) == -1 ){
            if ((current.remainder(value)).compareTo(new BigInteger("0")) == 0) return false;
            
            BigInteger what = value.multiply(value);
            if (what.compareTo(current) == 1) {
                System.out.println("break!");
                break;
            }
            System.out.println(value);
            
            value = value.add(new BigInteger("1"));
        }
        return true;
    }
}

class mersennePrime{
   //find the algorithm!!!!
}

class approximateE{
    public static void start(){
        for (int i = 100; i<=1000; i = i + 100){
            System.out.println("For " + i + ": " + calculate(i));
        }
    }
    
    public static BigDecimal calculate(int value){
        BigDecimal e = new BigDecimal("1.0");
        
        for (int i = 1; i <= value; i++){
            e = e.add(calculateX(i));
        }
        
        return e;
    }
    
    public static BigDecimal calculateX(int value){
        BigDecimal one = new BigDecimal("1");
        BigDecimal X = new BigDecimal("1");
        for (int i = 2; i <= value; i++){
            Integer I = new Integer(i);
            BigDecimal current = new BigDecimal(I.toString());
            X = X.multiply(current);
        }
        
        return one.divide(X, 25, BigDecimal.ROUND_UP);
    }
}

class MyString1{
    private char[] sequence;
    
    public MyString1(char[] chars){
        char[] temp = new char[chars.length];
        System.arraycopy(temp, 0, chars, 0, chars.length);
        sequence = temp;
    }
    
    public char charAt(int index){
        try {
            return sequence[index];
        } catch (Exception e){
            System.out.println("Array overflow");
            return '#';
        }
    }
    
    public int length(){
        return sequence.length;
    }
    
    public MyString1 substring(int begin, int end){
        if (sequence.length == 0) return null;
        if (begin < 0 || begin > (sequence.length - 1)) return null;
        if (end < 0 || end > (sequence.length - 1)) return null;
        
        char[] temp = new char[end - begin];
        System.arraycopy(sequence, begin, temp, 0, temp.length);
        return new MyString1(temp);
    }
    
    public MyString1 toLowerCase(){
        char[] temp = new char[sequence.length];
        
        for (int i = 0; i < sequence.length; i++){
            temp[i] = Character.toLowerCase(sequence[i]);
        }
        
        return new MyString1(temp);
    }
    
    public boolean equals(MyString1 s){
        if (s.length() != sequence.length) return false;
        
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) != sequence[i]) return false;
        }
        
        return true;
    }
    
    public static MyString1 valueOf(int i){
        int temp = i;
        int size = 0;
        
        while(temp != 0){
            temp = temp / 10;
            size++;
        }
        
        //when we have the size of the array
        char[] array = new char[size];
        temp = i;
        for (int k = 0; k < size; k++){
            char value = (char) ('0' + (temp % 10));
            temp = temp / 10;
            array[i] = value;
        }
        
        return new MyString1(array);
    }
}

class MyString2{
    private char[] sequence;
    
    public MyString2(String s){
        char[] temp = new char[s.length()];
        
        for (int i = 0; i < s.length(); i++){
            temp[i] = s.charAt(i);
        }
        
        sequence = temp;
    }
    
    public int compare(String s){
        int lengthX = 0;
        if (s.length() >= sequence.length) lengthX = sequence.length;
        else lengthX = s.length();
        
        for (int i = 0; i < lengthX; i++){
            char c1 = s.charAt(i);
            char c2 = sequence[i];
            
            if (c1 != c2) return c2 - c1;
        }
        
        if (s.length() == sequence.length) return 0;
        else return sequence.length - s.length();
    }
    
    public MyString2 substring(int begin){
        if(begin < 0 || begin > (sequence.length - 1)) return null;
        
        char[] temp = new char[sequence.length - begin];
        for (int i = begin; i < temp.length; i++){
            temp[i] = sequence[i];
        }
        
        return new MyString2(new String(temp));
    }
    
    public MyString2 toUpperCase(){
        char[] temp = new char[sequence.length];
        
        for (int i = 0; i < temp.length; i++){
            temp[i] = Character.toUpperCase(sequence[i]);
        }
        
        return new MyString2(new String(temp));
    }
    
    public char[] toChars(){
        char[] temp = new char[sequence.length];
        System.arraycopy(sequence, 0, temp, 0, sequence.length);
        return temp;
    }
    
    public static MyString2 valueOf(boolean b){
        if (b) return new MyString2("true");
        return new MyString2("false");
    }
}
