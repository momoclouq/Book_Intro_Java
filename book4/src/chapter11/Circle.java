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
public class Circle extends GeometricObject{
    private double radius;
    
    public Circle(){
        
    }
    
    public Circle(double radius){
        this.radius = radius;
    }
    
    public Circle(double radius,String color, boolean filled){
        this.radius = radius;
        setColor(color);
        setFilled(filled);
    }
    
    public double getRadius(){
        return radius;
    }
    
    public void setRadius(double radius){
        this.radius = radius;
    }
    
    public double getArea(){
        return radius * radius * Math.PI;
    }
    
    public double getDiameter(){
        return 2 * radius;
    }
    
    public double getPerimeter(){
        return 2 * radius * Math.PI;
    }
    
    public void printCircle(){
        System.out.println("The circle is created " + getDateCreated() + " and the radius is " + radius);
    }
    
    @Override
    public boolean equals(Object o){
        if (o instanceof Circle)
            return radius == ((Circle)o).radius;
        else return false;
    }
}
