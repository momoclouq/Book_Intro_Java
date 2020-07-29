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
public class Square extends GeometricObject implements Colorable{
    private double side;
    
    public Square(){
        this.side = 0;
    }
    
    public Square(double side){
        this.side = side;
    }
    
    public double getSide(){
        return this.side;
    }
    
    public void setSide(double side){
        this.side = side;
    }
    
    @Override
    public void howToColor(){
        System.out.println("Color all four sides");
    }
    
    @Override
    public double getArea(){
        return side * side;
    }
    
    @Override
    public double getPerimeter(){
        return 4 * side;
    }
}
