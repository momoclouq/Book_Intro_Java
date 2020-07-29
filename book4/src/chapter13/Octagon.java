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
public class Octagon extends GeometricObject implements Comparable<Octagon>, Cloneable{
    public static void main(String[] args){
        Octagon oc = new Octagon(1);
        System.out.println(oc);
    }
    
    private double side;
    
    public Octagon(){
        this.side = 0;
    }
    
    public Octagon(double side){
        this.side = side;
    }
    
    //setter getter
    public double getSide(){
        return side;
    }
    
    public void setSide(double side){
        this.side = side;
    }
    
    //for geometricobject
    @Override
    public double getArea(){
        return (2 + 4/(Math.sqrt(2))) * side * side;
    }
    
    @Override
    public double getPerimeter(){
        return 8 * side;
    }
    
    //for comparable
    @Override
    public int compareTo(Octagon o){
        if (this.side > o.getSide())
            return 1;
        else if (this.side < o.getSide())
            return -1;
        else return 0;
    }
    
    //for cloneable
    //nothing
    
    @Override
    public String toString(){
        return "Octogon area: " + this.getArea();
    }
}
