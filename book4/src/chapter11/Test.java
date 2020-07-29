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
public class Test {
    public static void main(String[] args){
        Circle1 circle1 = new Circle1();
        Circle1 circle2 = new Circle1();
        System.out.println(circle1.equals(circle2));
    }
    
   
}

class Circle1{
    double radius = 1;
    public boolean equals(Circle1 circle){
        System.out.println("1: " + this.radius);
        System.out.println("2: " + circle.radius);
        return this.radius == circle.radius;
    }
}
