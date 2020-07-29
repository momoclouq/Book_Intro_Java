/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter11;

/**
 *
 * @author cis2mye
 */
public class book {
    public static void main(String[] args){
        //Inheritence: define new classes from existing classes
        //Inheritance enables you to define a general class (a superclass) and later extend it to more specialized classes(subclasses)
        //the subclass and its superclass are said to from a is-a relationship
        //you cannot access private data fields
        //usually more information in subclasses
        
        //super keyword refers to the superclass and can be used to invoke the superclass's methods and constructors
        //syntax to call a superclass's constructor: super() or super(arguments);
        //the statement super(...) must be the first statement of the subclass's constructor
        
        //Constructor chaining
        //a constructor may invoke an overloaded constructor or its superclass constructor,
        //if neither is invoked explicitly, the compiler automatically puts super() as the first statement
        //in the constructor
        
        //overrding methods: books
        
        //overriding vs overloading: books
        
        //polymorphism: a variable of a supertype can refer to a subtype object
        //you can always pass an instance of a subclass to a prarameter of its superclass
        
        //dynamic binding
        //example: Object o = new GeometricObject(); -> toString()?
        //declare type vs actual type
        //toString() method is invoked by actual type
        
        //equals() method: equals(Object o)
        //please work with: equals(Object o) -> override the method in Object, not overloading!
        
        //ArrayList: a generic class with a generic type E.
        //ArrayList<String> cities = new ArrayList<String>();
        //ArrayList<int> will not work because elements stored in an ArrayList must be of an object type
        
        //protected data and methods
        //can be accessed from a subclass
        
    }
}
