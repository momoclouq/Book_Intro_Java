/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cis2mye
 */
public class RegularPolygon {
    
    public static void main(String[] args){
        RegularPolygon p1 = new RegularPolygon(4,6);
        RegularPolygon p2 = new RegularPolygon(10,4,5.6,7.8);
        
        System.out.println(p1.getPerimeter());
        System.out.println(p1.getArea());
        
        System.out.println(p2.getPerimeter());
        System.out.println(p2.getArea());
    }
    
    private int n = 3;
    private double side= 3;
    private double x = 0;
    private double y = 0;
    
    RegularPolygon(){
        
    }
    
    RegularPolygon(int n, double side){
        this.n = n;
        this.side = side;
        this.x = 0;
        this.y = 0;
    }
    
    RegularPolygon(int n, double side, double x, double y){
        this.n = n;
        this.side = side;
        this.x = x;
        this.y = y;
    }
    
    //accessors
    public int getN(){
        return this.n;
    }
    
    public double getSide(){
        return this.side;
    }
    
    public double getX(){
        return this.x;
    }
    
    public double getY(){
        return this.y;
    }
    
    //mutators
    public void setN(int n){
        this.n = n;
    }
    
    public void setSide(double side){
        this.side = side;
    }
    
    public void setX(double x){
        this.x = x;
    }
    
    public void setY(double y){
        this.y = y;
    }
    
    //methods
    public double getPerimeter(){
        return this.side * this.n;
    }
    
    public double getArea(){
        return (this.n * Math.pow(this.side,2)) / (4 * Math.tan(Math.PI / this.n));
    }
}
