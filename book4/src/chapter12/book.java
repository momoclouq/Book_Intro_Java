/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter12;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author cis2mye
 */
public class book {
    //exceptions are runtime errors. Exception handling enables a program to deal with runtime errors and continue its normal execution
    //Exceptions are thrown from a method. the caller of the method can catch and handle the exception
    
    //root class for exceptions is java.lang.Throwable
    //more in book
    
    //3 major types: system errors, exceptions and runtime exceptions
    //system errors are thrown by the JVM and there is little you can do about it except terminate the program gracefully
    //Exceptions are errors caused by your program and by external circumstances (try-throw-catch)
    //runtime exceptions are represented in RuntimeException: programming errors sub as bad casting, accessing an out-of-bounds array, ...
    //checked vs unchecked exceptions
    //RuntimeException, Error and their subclasses: unchecked exceptions, all other exceptions are known as checked exceptions
    //checked exceptions forces the programmer to check and eal with them in a try-catch block or declare it in the  method header
   
    //a handler for an exception is found by propagating the exception backward through a chain of method calls
    //starting from the current method
    //more in book
    
    //finally block is always executed
    
    //The File class contains the methods for obtaining the properties of a file/directory, renaming and deleting a file/directory
    
    //file input and output: Scanner for input and printwriter for output
    //case study replacing text: sublime text file
    public static void main(String[] args){
        System.out.println(new File(".").getAbsolutePath());
        Scanner input = new Scanner(System.in);
        int value = input.nextInt();
        String line = input.nextLine();
        System.out.println(value + "-" + line);
    }
}
