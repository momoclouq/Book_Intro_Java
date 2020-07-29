/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter13;

/**
 *
 * @author cis2mye
 */
public class book {
    //an interface can be used to define common behavior for classes(including unrelated classes)
    //an abstract class cannot be used to create objects, it can contain abstract methods that are implemented in
    //concrete subclasses
    
    //points about abstract classes:
    //an abstract method cannot be contained in a nonabstract class, all abstract methods must be implemented in the subclasses
    //an abstract class cannot instantited using the new operator, but you can still define its constructors,
    //which are invoked in the constructors of its subclasses
    //a subclass can be abstract even if its superclass is concrete
    //an abstract class can be used as a data type -> GeometricObject[] objects = new GeometricObject[10]; is valid
    
    //interfaces
    //interface is treated like a special class in Java, you can use an interface more or less the same way you use an abstract class
    
    //comparable interface: book
    
    //clonable interface: An interface contains constants and abstract methods, but the cloneable interface is a special case
    //This interface is empty, these kinds of interfaces are referred to as a marker interface
    //the new object has the same contents as the source, different objects btw
    //primitive data is copied but object data's reference is copied -> shallow copy, so we have to change the clone() method in needed classes
    
    //interfaces vs abstract classes
    //a class can implement multiple interfaces, but it can only extend one superclass
    //more in book
    
    //guidelines: book!
    public static void main(String[] args){
        System.out.println("Enter");
    }
}
