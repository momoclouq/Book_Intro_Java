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
public class IllegalTriangleException extends Exception{
    
    public IllegalTriangleException(double side1, double side2, double side3){

        super("Invalid side: " + wrongSide(side1, side2, side3));
    }
    
    private static double wrongSide(double side1, double side2, double side3){
        if (side1 + side2 <= side3) return side3;
        if (side2 + side3 <= side1) return side1;
        if (side1 + side3 <= side2) return side2;
        return 0;
    }
}
