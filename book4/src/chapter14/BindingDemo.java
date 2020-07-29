/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter14;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleFloatProperty;

/**
 *
 * @author cis2mye
 */
public class BindingDemo {
    public static void main(String[] args){
        DoubleProperty d1 = new SimpleDoubleProperty(1);
        DoubleProperty d2 = new SimpleDoubleProperty(2);
        FloatProperty d3 = new SimpleFloatProperty(3);
        Double d4 = new Double(4);
        d2.bindBidirectional(d1);
        System.out.println("d1 is " + d1.getValue() + " and d2 is " + d2.getValue());
        d2.setValue(70.2);
        System.out.println("d1 is " + d1.getValue() + " and d2 is " + d2.getValue());
    }
}
