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
public class House implements Cloneable, Comparable<House>{
    public static void main (String[] args){
        House house1 = new House(1, 1750.50);
        House house2 = (House)house1.clone();
    }
    
    private int id;
    private double area;
    private java.util.Date whenBuilt;
    
    public House(int id, double area){
        this.id = id;
        this.area = area;
        whenBuilt = new java.util.Date();
    }
    
    public int getId(){
        return id;
    }
    
    public double getArea(){
        return area;
    }
    
    public java.util.Date getWhenBuilt(){
        return whenBuilt;
    }
    
    @Override
    public Object clone(){
        try{
            House houseClone = (House)super.clone();
            houseClone.whenBuilt = (java.util.Date)(whenBuilt.clone());
            return houseClone;
        }
        catch(CloneNotSupportedException ex){
            return null;
        }
    }
    
    @Override
    public int compareTo(House o){
        if (area > o.getArea())
            return 1;
        else if (area < o.getArea())
            return -1;
        else return 0;
    }
}
