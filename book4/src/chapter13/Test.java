/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter13;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author cis2mye
 */
public class Test {
    public static void main(String[] args){
        GeometricObject geoObject1 = new Circle(5);
        GeometricObject geoObject2 = new Rectangle(5,3);
        
        //System.out.println("The two objects have the same area? " + equalArea(geoObject1, geoObject2));
        
        //display circle
        //displayGeometricObject(geoObject1);
        
        //display rectangle
        //displayGeometricObject(geoObject2);
        Calendar calendar = new GregorianCalendar(2013, 2, 1);
        Calendar calendar1 = calendar;
        Calendar calendar2 = (Calendar)calendar.clone();
        
        System.out.println("calendar == calendar1 is " + (calendar == calendar1));
        System.out.println("calendar == calendar2 is " + (calendar == calendar2));
        System.out.println("calendar.equals(calendar2) is "+ calendar.equals(calendar2));
        
        ArrayList<Double> list1 = new ArrayList<>();
        list1.add(1.5);
        list1.add(2.5);
        list1.add(3.5);
        ArrayList<Double> list2 = (ArrayList<Double>) list1.clone();
        ArrayList<Double> list3 = list1;
        list2.add(4.5);
        list3.remove(1.5);
        System.out.println("list1: " + list1);
        System.out.println("list2: " + list2);
        System.out.println("list3: " + list3);
        
        House house1 = new House(1,24);
        House house2 = (House) (house1.clone());
        System.out.println(house1.equals(house2));
        
    }
    
    public static boolean equalArea(GeometricObject object1, GeometricObject object2){
        return object1.getArea() == object2.getArea();
    }
    
    public static void displayGeometricObject(GeometricObject object){
        System.out.println();
        System.out.println("The area is " + object.getArea());
        System.out.println("The perimeter is " + object.getPerimeter());
    }
}

