/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter13;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author cis2mye
 */
public class Exercises {
    public static void main(String[] args){
        /*
        Triangle tri = new Triangle();
        System.out.println("Area: " + tri.getArea());
        System.out.println("Perimeter: " + tri.getPerimeter());
        System.out.println("Color: " + tri.getColor());
        System.out.println("Filled: " + tri.isFilled());
        
        Triangle tri2 = new Triangle(2,2,3,"blue",false);
        System.out.println("Area: " + tri2.getArea());
        System.out.println("Perimeter: " + tri2.getPerimeter());
        System.out.println("Color: " + tri2.getColor());
        System.out.println("Filled: " + tri2.isFilled());
*/
        /*
        ArrayList<Number> list = new ArrayList<>();
        list.add(new Integer(1));
        list.add(new Double(2.5));
        list.add(new Long(2999));
        
        E13_2.average(list);
        */
        /*
        ArrayList<Number> list = new ArrayList<>();
        list.add(new Integer(1));
        list.add(new Double(-100));
        list.add(new Long(112012));
        list.add(new BigDecimal("12914801.198"));
        list.add(new BigInteger("13313131313131313"));
        E13_3.sort(list);
*/
        Rectangle r1 = new Rectangle(4, 10);
        Rectangle r2 = new Rectangle(1 , 3);
        //System.out.println("The bigger rec: " + GeometricObject.max(r1, r2).toString());
        Circle c1 = new Circle(3);
        Circle c2 = new Circle(4);
        /*
        ComparableCircle c2 = new ComparableCircle(2);
        ComparableCircle c3 = new ComparableCircle(3);
        System.out.println("rec vs cir: " + c1.compareTo(r1));
        System.out.println("ccir vs cir: " + c2.compareTo(c1));
        System.out.println("ccir vs ccir: " + c2.compareTo(c3));
*/
        GeometricObject[] list = new GeometricObject[4];
        list[0] = r1;
        list[1] = r2;
        list[2] = c1;
        list[3] = c2;
        System.out.println("Sum of all areas: " + SumArea.sumArea(list));
    }
}

class Triangle extends GeometricObject{
    private double side1;
    private double side2;
    private double side3;
    
    Triangle(){
        super("black", true);
        side1 = 1;
        side2 = 1;
        side3 = 1;
    }
    
    Triangle(double side1, double side2, double side3, String color, boolean filled){
        super(color, filled);
        if (isTriangle(side1, side2, side3)){
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
        }   
        else {
            System.out.println("the values are not triangle");
            System.exit(1);
        }
    }
    
    //just to check the triangle
    public static boolean isTriangle(double side1, double side2, double side3){
        if (side1 <= 0 || side2 <= 0 || side3 <= 0) return false;
        if (side1 >= side2 + side3) return false;
        if (side2 >= side1 + side3) return false;
        if (side3 >= side1 + side2) return false;
        return true;
    }

    //getters
    public double getSide(int side){
        if (side <= 0 || side > 3) {
            System.out.println("input is wrong");
            return -1;
        }
        else 
            switch(side){
                case 1: return side1;
                case 2: return side2;
                case 3: return side3;
                default: break;
            }
        return -1;
    }
    
    @Override
    public double getArea(){
        double p = this.getPerimeter() / 2;
        return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
    }
    
    @Override
    public double getPerimeter(){
        return (side1 + side2 + side3);
    }
}

class E13_2{
    public static void average(ArrayList<Number> list){
        BigDecimal total = new BigDecimal("0.0");
        for (Number value: list){
            total = total.add(new BigDecimal(value.toString()));
        }
        total = total.divide(new BigDecimal(list.size()), BigDecimal.ROUND_UP);
        System.out.println("Average = " + total);
    }
}

class E13_3{
    public static void sort(ArrayList<Number> list){
        if(list == null || list.size() == 0){
              System.out.println("The list is empty");
        }
        
        try{
            for (int i = 0; i<list.size(); i++){
            for (int k = i; k < list.size() - 1; k++){
                if (list.get(k).doubleValue() > list.get(k+1).doubleValue()){
                    Number temp = list.get(k);
                    list.set(k, list.get(k+1));
                    list.set(k+1, temp);
                }  
            }
        }
   
        System.out.println("List: " + list);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}

class ComparableCircle extends Circle implements Comparable<ComparableCircle>{
    public ComparableCircle(){
        
    }
    
    public ComparableCircle(double radius){
        super(radius);
    }
    
    @Override
    public int compareTo(ComparableCircle c){
        System.out.println("1");
        if (this.getArea() > c.getArea())
            return 1;
        else if (this.getArea() < c.getArea())
            return -1;
        else return 0;
    }
}

class SumArea{
    public static double sumArea(GeometricObject[] a){
        double sum = 0;
        for (GeometricObject o: a){
            sum += o.getArea();
        }
        
        return sum;
    }
}