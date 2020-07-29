/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter13;

import java.util.Scanner;

/**
 *
 * @author cis2mye
 */
public class Complex implements Cloneable, Comparable<Complex>{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the first complex number: "); 
        Complex c1 = new Complex(Double.parseDouble(input.next()), Double.parseDouble(input.next()));
        input.nextLine();
        
        System.out.print("Enter the second complex number: ");
        Complex c2 = new Complex(Double.parseDouble(input.next()), Double.parseDouble(input.next()));
        input.nextLine();
        
        //test
        System.out.println(c1 +  " + " + c2 + " = " + c1.add(c2));
        System.out.println(c1 +  " - " + c2 + " = " + c1.subtract(c2));
        System.out.println(c1 +  " * " + c2 + " = " + c1.multiply(c2));
        
        try{
                    System.out.println(c1 +  " / " + c2 + " = " + c1.divide(c2));
        }
        catch (Exception ex){
            System.out.println("Error: " + ex.getMessage());
        }
       
        System.out.println(c1 + " has absolute value = " + c1.getAbsolute());

        
    }
    
    private double a;
    private double b;
    
    public Complex(double a, double b){
        this.a = a;
        this.b = b;
    }
    
    public Complex(double a){
        this.a = a;
        this.b = 0;
    }
    
    public Complex(){
        this.a = 0;
        this.b = 0;
    }
    
    //getter
    public double getRealPart(){
        return a;
    }
    
    public double getImaginaryPart(){
        return b;
    }
    
    //protocols
    public Complex add(Complex c){
        return new Complex(a + c.getRealPart(), b + c.getImaginaryPart());
    }
    
    public Complex subtract(Complex c){
        return new Complex(a - c.getRealPart(), b - c.getImaginaryPart());
    }
    
    public Complex multiply(Complex c){
        double c1 = c.getRealPart();
        double c2 = c.getImaginaryPart();
        
        return new Complex(a * c1 - b * c2, b * c1 + a * c2);
    }
    
    public Complex divide(Complex c) throws Exception{
        if (c.getRealPart() == 0 && c.getImaginaryPart() == 0) throw new Exception("Divide by 0");
        double c1 = c.getRealPart();
        double c2 = c.getImaginaryPart();
        
        double up1 = a * c1 + b * c2;
        double up2 = b * c1 - a * c2;
        double down = c1 * c1 + c2 * c2;
        
        return new Complex(up1/down, up2/down);
    }
    
    public double getAbsolute(){
        return Math.sqrt(a * a + b * b);
    }
    
    //Comparable
    @Override
    public int compareTo(Complex c){
        if (this.getAbsolute() > c.getAbsolute())
            return 1;
        else if (this.getAbsolute() < c.getAbsolute())
            return -1;
        else return 0;
    }
    
    //cloneable
    //nothing
    
    @Override
    public String toString(){
        if (b > 0)
            return "(" + a + " + " + b + "i)";
        else if (b < 0) 
            return "(" + a + " - " + (b*(-1)) + "i)";
        else return "(" + a + ")";
    }
}
