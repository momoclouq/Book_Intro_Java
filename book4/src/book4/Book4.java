/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book4;

import chapter9_test.C1;

/**
 *
 * @author cis2mye
 */
public class Book4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //chapter 9: objects and classes
        //programming using objects
        //the illustration of class templates and objects can be stadardized using Unified Modeling Language(UML)
        
        //testCircle
        Circle circle1 = new Circle();
        System.out.println("The area of the circle of radius " + circle1.radius + " is " + circle1.getArea());
        
        Circle circle2 = new Circle(25);
        System.out.println("The area of the circle of radius " + circle2.radius + " is " + circle2.getArea());
        
        Circle circle3 = new Circle(125);
        System.out.println("The area of the circle of radius " + circle3.radius + " is " + circle3.getArea());
        
        circle3.setRadius(210);
        System.out.println("The area of the circle of radius " + circle3.radius + " is " + circle3.getArea());
        
        //you can put two classes or more into one file, but only one class in the file can be a public class.
        //furthermore, the public class must have the same name as the file name!
        //you can have multiple main methods in multiple classes. and can run of each class (to test the class)
        
        //null: a default value for reference type
        //nulPointerException
        
        //primitive type vs reference type
        //copy value vs copy reference
        //an anonymous object is a value has no name, they cannot be referred to after creation -> created and destroyed all within 
        //a single expression
        
        //using classes from java library
        //Date class
        //books
        
        //Random class
        //books
        //Point2D class - books
        
        //static variables, constants and methods
        //a static variable is shared by all objects of the class
        //a static method cannot access instance menbers
        
        C1 c1 = new C1(); //this works
        //C2 c3 = new C2(); this does not work
        //public (default) protected private
        
        //data field encapsulation: makes data fields private
        //passing objects to methods is to pass the reference of the object
        
        //more in the book!
    }
    
}
