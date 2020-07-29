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
public abstract class GeometricObject{

        
    private String color = "white";
    private boolean filled;
    private java.util.Date dateCreated;
    
    public GeometricObject(){
        dateCreated = new java.util.Date();
    }
    
    public GeometricObject(String color, boolean filled){
        dateCreated = new java.util.Date();
        this.color = color;
        this.filled = filled;
    }
    
    public int one1(){
        return 1;
    } 
    
    public String getColor(){
        return color;
    }
    
    public void setColor(String color){
        this.color = color;
    }
    
    public boolean isFilled(){
        return filled;
    }
    
    public void setFilled(boolean filled){
        this.filled = filled;
    }
    
    public java.util.Date getDateCreated(){
        return dateCreated;
    }
    
    public static GeometricObject max(GeometricObject o1, GeometricObject o2){
        if (o1.compareTo(o2) > 0)
            return o1;
        else if (o1.compareTo(o2) <= 0)
            return o2;
        
        return o2;
    }
    
    @Override
    public String toString(){
        return "created on " + dateCreated + "\ncolor: "+color + " and filled: " + filled;
    }
    
    //abstract method getArea
    public abstract double getArea();
    
    //abstract method getPerimeter
    public abstract double getPerimeter();
    
    public int compareTo(GeometricObject o){
        if (this.getArea() < o.getArea())
            return -1;
        else if (this.getArea() > o.getArea())
            return 1;
        else return 0;
    }
}
