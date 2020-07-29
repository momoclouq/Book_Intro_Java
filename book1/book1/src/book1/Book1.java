/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book1;

import java.util.Scanner;

/**
 *
 * @author cis2mye
 */
public class Book1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //chapter1
        /*
        System.out.println("Programming is fun");
        System.out.println("Fundamentals first");
        System.out.println("Problem?");
        System.out.print("1 + 1 =" );
        System.out.println(1+1); 
*/
        
        //chapter2
        //calculate a circle's area
        /*
        double radius;
        double area;
        
        //assign varaible's value
        radius = 20;
        area = radius * radius * 3.14159;
        //display the result
        System.out.println("The are for the circle of radius " + radius + " is " + area);
        System.out.println("testtttttktoktoktoktoktoktkotkotkotkotkotkotkotkotkotkotkotkokt"
                + "oktoktoktoktoktoktoktoktoktoktoktoktokotkotkt1"); 
        //a string cannot be seperated into 2 or more different lines
        
*/
        //scanner - chapter 2
        /*
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number for radius: ");
       double radius = scanner.nextDouble();
       //compute area
       double area = radius * radius * 3.14;
       //display
       System.out.println("Result for area: " + area);
       
       //constant
       final double PI = 3.14;
       System.out.println("Pi: " + PI);
       
       //exponential operations
       System.out.println("2^3 = " + Math.pow(2,3));
       System.out.println("2.5 ^ (-2) = " + Math.pow(2.5, (-2)));
       
       long huhu = 999999999999999999L;
       
       //scientific notions
       //1.23456E+2 = 1.23456*10^2
       
       //Displaying the current time
       long totalMilliseconds = System.currentTimeMillis();
       long totalSeconds = totalMilliseconds / 1000;
       long currentSecond = totalSeconds % 60;
       long totalMinutes = totalSeconds / 60;
       long currentMinute = totalMinutes % 60;
       long totalHours = totalMinutes / 60;
       long currentHour = totalHours % 24;
       System.out.println("Current time is "+ currentHour + ": " + currentMinute + ": " + currentSecond + " GMT");
       
       //casting
       System.out.println((int)1.7 );
       System.out.println((double)1 / 2);
        
               scanner.close();
       */
        
        /*
        //chapter 3: Selection
        //relational operators: >, <, >= ,<=, ==, !=
        System.out.println(false);
        
        //if statement
        boolean whatisthis = true;
        if(whatisthis) {
            System.out.println("yeah");
            whatisthis = !whatisthis;
        } else System.out.println("Nah");
        
        //generating random numbe
        int number1 = (int) (Math.random() * 10);
        int number2 = (int) (Math.random() * 10);
        
        System.out.println("the bigger number: ");
        if(number1 > number2) {
            System.out.println(number1 + " > " + number2);
        } else System.out.println(number2 + " >= " + number1);
        
        //boolean operators: 
        //&& || and ^ (exclusive or)
        
        //switch statement
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the integer: ");
        int input = scan.nextInt();
        
        //input must be int, char, byte, short, String
        //break is optional, but use it
        switch(input){
            case 1: System.out.println("One");
            break;
            case 2: System.out.println("Two");
            break;
            case 3: System.out.println("Three");
            break;
            case 4: System.out.println("Four");
            break;
            case 5: System.out.println("Five");
            break;
            default: System.out.println("Nothing");
        }
        
        //learn to use a debugger: books/supplement 
*/
        /*
        //chapter 4: mathematical functions, characters and strings
        //mathematical functions, using Math class
        //.sin(rad), .cos(rad), .tan(), toRadians(degree)
        //toDegrees(rad), asin(a) (inverse of sin), acos(), atan()
        //exponent methods:
        //exp(x) return e^x
        //log(x) = ln(x), log10(x),pow(a, b) = a^b, sqrt(x)
        
        //rounding methods:
        //ceil(), floor()
        //rint() = rounded to its nearest integer, if x is equally close to two integers, then the even one is returned
        //round(x) = Math.floor(x + 0.5)
        
        //max, min, abs methods
        //max (a,b) , min(a,b) ,abs(a)
        
        //Math.random() = 0.0 <= x < 1
        
        //character:
        //Computers use binary numbers internally -> mapping a character t o its binary representation is called encoding.
        //how characters are encoded is defined by an encoding scheme
        //java supports Unicode
        //A 16-bit unicdoe is expressed in four hexadecimal digits: \u0000 to \uFFFF with "\\u" followed by 2 bytes
        
        //casting between char and numeric types: book 149 important when needed
        
        //comparing characters can be done by comparing the unicode 
        System.out.print("Please enter a character: ");
        Scanner scan = new Scanner(System.in);
        char test1 = scan.nextLine().charAt(0);
        
        if(test1 >= 'A' && test1 <= 'Z') System.out.println("char is uppercase");
        else System.out.println("Char is different");
        //methods in the character class: isDigit(), isLetter(), isLeterOrDigit(), isLowerCase(), isUpperCase(), toLowerCase(), toUpperCase()(these methods just return the value, you have to assign them yourself)
        
        //String: String message = "Welcome";
        //methods: length(), charAt(0, concat(s1), toUpperCase(), toUpperCase(), trim() (remove whitespace from bothsides)
        String test2 = "     Hello aaaa     ";
        System.out.println(test2.trim());
        //s2.concat(s1) = s2 + s1;
        
        //reading string from the console
        //.next() vs nextLine()
        System.out.print("Enter3: ");
        String s1 = scan.next();
        String s2 = scan.next();
        String s3 = scan.next();
        System.out.println("s1 is: " + s1);
        System.out.println("s2 is: " + s2);
        System.out.println("s3 is: " + s3);
        //reading character: .nextLine().charAt(0)
       
        //a few methods: equals, compareTo(s1), compareToIgnoreCase, startsWith(a), endswith(a), contains(s1)
        //compare 2 string: do not use == (this will compare 2 string objects and not their value
        //how then: .equals(), compareTo()
        //equals() return boolean when compareTo() return int
        //compareTo(): 0 when equals, negative when s1 < s2 and positive otherwise (example: -4 when s1 = abc, s2 = abg
        
        //obtaining substring
        //s1.substring(a,b): return a string starts at a and end at b (position)
        //s1.substring(a): the same as before but now b is the end of s1
        
        //finding a character or a substring in a String
        //indexOf(ch) or indexOf(ch, fromIndex). return -1 if does not find anything
        //example: "Welcome to Java".indexOf("come", 0) = 3 while  "Welcome to Java".indexOf("Java", 12) = -1
        
        //conversion between strings and numbers
        String number1 = "123";
        String number2 = "123.456";
        
        int intValue1 = Integer.parseInt(number1);
        double doubleValue2 = Double.parseDouble(number2);
        System.out.println("num1 + num2 = "+ (intValue1 + doubleValue2));
        
        //formatting console output
        System.out.printf("floating: %4.5f", (intValue1 + doubleValue2));
        //%f =floating number, %d = decimal, %b = boolean, %s = string, %5d = 5 space for decimal (will add empty spaces when decimal not enough)
        //more in book/169, 170 !!!!!
        */
        
        //chapter5: loops
        /*
        //while loop
        boolean conti = true;
        int count = 0;
        while (conti){
            System.out.println("Hey there!");
            count++;
            if (count >10) conti = false;
        }
        
        int i=1;
        while(i< 10)
            if ((i ++) % 2 == 0)    //check i first then i++
                System.out.println(i);
        
        //dont use floatting-pint values for equality checking in a loop control. because floating-point values are approximateoins for some values.
        
        //java SentinelValue < input.txt
        //this is called input redirection (this is a command in command line), which takes the input from the input.txt file
        //java SentinelValue > output.txt : the same but now output.txt is the output of the program
        
        //do while loop
        int number;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("Enter number: ");
            number =  scan.nextInt();
        } while (number < 100);
        
        //for loop
        for (int k = 0; k < 10; k++){
            System.out.println("Hello mother fucker");
        }
        //the action-after-each-iteration in a for loop can be a list of zero or more comma-separated statements
        //example:
        for (int k = 0; k<10; k++, System.out.println(k))
            System.out.println("?");
        */
        //minimizing numeric errors
        float sum = 0;
        for (float i = 0.01f; i <= 1.0f; i = i + 0.01f) //error in result
            sum += i;
        
        System.out.println(sum);
        
        //if you change float to double then the result can be improved (slightly in some cases)
        double newsum = 0;
        for (double i = 0.01; i <= 1.0; i = i + 0.01)
            newsum += i;
        
        System.out.println(newsum);
        //but now the last i is slightly larger than 1 -> wrong result, conclusion: to fix: use int
        
        //keyword:break; and continue;
        while(true){
            System.out.println("Whut!");
            break;
        }
        
        int count1 = 0;
        while(true){
            count1++;
            if(count1 >= 10) break;
            if(count1 % 2 == 0) System.out.print(count1 + " ");
            else continue;
            System.out.print("?");
        }
        //example: checking palindrome
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = input.nextLine();
        int low = 0;
        int high = s.length() - 1;
        boolean isPalindrome = true;
        
        while (low < high){
            if(s.charAt(low) != s.charAt(high)){
                isPalindrome = false;
                break;
            }
            low++;
            high--;
        }
        
        if(isPalindrome)
            System.out.println("This is a palindrome!");
        else System.out.println("Nope bitch!");
        
        //chapter 6 will be started on book2
    }   
    
    
    
}
