/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book4;

/**
 *
 * @author cis2mye
 */
public class Circle {
    
    public static void main(String[] args){
        Circle circle1 = new Circle();
        System.out.println("What " + circle1.getArea());
    }
    
    double radius = 1;
 
    //constructor
    Circle(){
        
    }
    
    Circle(double newRadius){
        radius = newRadius;
    }
    
    //setters and getters
    double getArea(){
        return radius * radius * Math.PI;
    }
    
    //return the perimeter of this circle
    double getPerimeter(){
        return 2 * radius * Math.PI;
    }
    
    //set a new radis for this circle
    void setRadius(double newRadius){
        radius = newRadius;
    }
    
    //UML diagram: book
}
