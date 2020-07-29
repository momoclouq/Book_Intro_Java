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
public class Rectangle extends GeometricObject{
    public static void main(String[] args){
        Rectangle a = new Rectangle();
        
        System.out.println("1: " + a.one1());

    }
    
    private double width;
    private double height;
    
    public Rectangle(){
        
    }
    
    public Rectangle(double width, double height){
        this.width = width;
        this.height = height;
    }
    
    public Rectangle(double width, double height, String color, boolean filled){
        this.width = width;
        this.height = height;
        setColor(color);
        setFilled(filled);
    }
    
    @Override
    public int one1(){
        return 2;
    }
    
    public double getWidth(){
        return width;
    }
    
    public void setWidth(double width){
        this.width = width;
    }
    
    public double getHeight(){
        return height;
    }
    
    public void setHeight(double height){
        this.height = height;
    }
    
    public double getArea(){
        return width * height;
    }
    
    public double getPerimeter(){
        return 2 * (width + height);
    }
  
    @Override
    public String toString(){
        return "Rec(w:" + width + ",h:" + height + ")";
    }
}
