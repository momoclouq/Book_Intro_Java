/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter12;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author cis2mye
 */
public class Test {
    public static void main(String[] args) throws Exception{
        try (   
                PrintWriter output = new PrintWriter("image/temp.txt");
                ){
            output.printf("amount is %f %e\r\n", 32.32, 32.32);
        output.printf("amount is %5.4f %5.4e\r\n", 322222.32, 322222.32);
        output.printf("%6b\r\n", (1 > 2));
        output.printf("%6s\r\n", "Java");
        }
        
        Scanner input = new Scanner("45\n57.8\n    123");
        int intValue = input.nextInt();
        double doubleValue = input.nextDouble();
        int line = input.nextInt();
                
        System.out.println(intValue + " " + doubleValue + " " + line);
    }
}
