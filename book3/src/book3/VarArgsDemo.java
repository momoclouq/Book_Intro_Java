/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book3;

/**
 *
 * @author cis2mye
 */
public class VarArgsDemo {
    public void printk(){
        printMax(34, 3, 3,2,1,65.1);
        printMax(new double[]{1,2,3});
    }
    
    public void printMax(double... numbers){
        if (numbers.length == 0){
            System.out.println("No argument passed");
            return;
        }
        
        double result = numbers[0];
        for(int i = 1; i < numbers.length; i++){
            if (numbers[i]  > result)
                result = numbers[i];
        }
        
        System.out.println("The max: " + result);
    }
}
