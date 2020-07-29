/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter10;

/**
 *
 * @author cis2mye
 */
public class book {
    
    public static void main(String[] args){
        //regular expressions
        if ("Java is cool".matches("Java.*")) System.out.println("condition1: true");
        if ("444-02-3123".matches("\\d{3}-\\d{2}-\\d{4}")) System.out.println("condition2: true");
        if ("444-02-312d".matches("\\d{3}-\\d{2}-\\d{4}")) System.out.println("condition3: true");
        
        //conversion between Strings and Arrays
        char[] chars = "JAVA".toCharArray();
        for (int i = 0; i < chars.length; i++){
            System.out.print("-" + i);
        }
        
        //valueOf method
        String test = String.valueOf('c');
        System.out.println("test = " + test);
        
        //formatted string
        //books
        
        String s1 = "Welcome to Java";
        String s2 = s1;
        String s3 = new String("Welcome to Java");
        String s4 = "Welcome to Java";
        
        if(s1.equals(s3)) System.out.println("c is true");
        if(s1.equals(s4)) System.out.println("d is true");
        
        String test1 = new String();
        System.out.println("Length: " + test1.length());
        
        System.out.println("Hi, ABC, good".matches("ABC "));
        System.out.println("Hi, ABC, good".matches(".*ABC.*"));
        System.out.println("A,B;C".replaceAll(",;", "#"));
        
        //StringBuilder vs StringBuffer
        //StringBuilder and StringBuffer are mutable, StringBuffer is deadlock free while StringBuilder is faster
        //book
        String sk = "Java";
        StringBuilder builder = new StringBuilder(sk);
        change(sk,builder);
        
        System.out.println(sk);
        System.out.println(builder);
     }
    
    public static void change(String s, StringBuilder builder){
        s = s + " and HTML";
        builder.append(" and HTML");
    }
    //class abstraction is separation of class implementation from the use of a class
    //in order to do so: class encapsulation: details of implementation are encapsulated and hidden from the user
    //Loan class example: book
    
    //class relationships:
    //Association: books
    //aggregation and composition: books
    
    //primitive data type values as objects
    //by using a wrapper class, you can process primitive data type values as objects
    //books
    

    //boxing vs unboxing
    //Integer intObject = new Integer(2);  <=> Integer intObject = 2; (auto boxing)
    //int i = 1; <=> int i = new Integer(1); (auto unboxing)
    
    //bigInteger and bigDecimal
    //represent integers and decimal numbers of any size and precision
    //books
    
    //The String class
    //immutable: content cannot be changed after creation
    
    //constructing a string
    String message = new String("acs");
    
    //immutable Strings and interned strings
    //interned strings: "what is this", a real string object: new String("acscas");
    //it means: String s1 = "Welcome" will equal to String s2 = "Welcome", while String s3 = new String("Welcome"); is not
    
    //replacing character in a string
    //replace(old char, new char);
    //split(delimiter: String); : turn a string to an array of strings consisting of substrings split by the delimiter
    String[] tokens = "Java#HTML#Perl".split("#");
    
    //matching, replacing, splitting by patterns
    //if ("Java is cool".matches("Java.*")) System.out.println("condition1: true");
    // -> regular expression!
    
    //more in books
}
