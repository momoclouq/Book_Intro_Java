/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter10;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author cis2mye
 */
public class LargeFactorial {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int n = input.nextInt();
        System.out.println(n + "! is \n" + factorial(n));
    }
    
    public static BigInteger factorial (long n){
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <=n; i++){
            result = result.multiply(new BigInteger(i + ""));
            
        }
        return result;
    }
}
