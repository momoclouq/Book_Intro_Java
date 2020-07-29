/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter13;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

/**
 *
 * @author cis2mye
 */
public class LargestNumber {
    public static void main(String[] args){
        ArrayList<Number> list = new ArrayList<>();
        list.add(45);
        list.add(3445.53);
        //add a biginteger
        list.add(new BigInteger("34323232323141241241241"));
        list.add(new BigDecimal("2.090909090191019101910919"));
        
        System.out.println("The largest number is " + getLargestNumber(list));
        
    }
    
    public static Number getLargestNumber(ArrayList<Number> list){
        if (list == null || list.size() ==0){
            return null;
        }
        
        Number number = list.get(0);
        for (int i = 1; i < list.size(); i++){
            if(number.doubleValue() < list.get(i).doubleValue())
                number = list.get(i);
        }
        
        return number;
    }
}
