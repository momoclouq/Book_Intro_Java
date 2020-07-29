/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cis2mye
 */
public class Rectangle {
    
    public static void main(String[] args){
        Rectangle r1 = new Rectangle(4,40);
        Rectangle r2 = new Rectangle(3.5,35.9);
        
        System.out.println(r1);
        System.out.println(r2);
    }
    
    private double width = 1;
    private double height = 1;
    
    Rectangle (){
        
    }
    
    Rectangle(double width, double height){
        this.width = width;
        this.height = height;
    }
    
    public double getArea(){
        return 2 * width * height;
    }
    
    public double getPerimeter(){
        return 2 *(width + height);
    }
    
    @Override
    public String toString(){
        return "width: " + this.width + " height: " + this.height + " Area: " + this.getArea() + " Perimeter: " + this.getPerimeter();
    }
}
