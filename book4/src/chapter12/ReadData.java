/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter12;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author cis2mye
 */
public class ReadData {
    public static void main(String[] args) throws Exception {
        File file = new File("image/scores.txt");
        
        Scanner input = new Scanner(file);
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        
        while(input.hasNext()){
            String firstName = input.next();
            String mid = input.next();
            String lastName = input.next();
            
            int score = input.nextInt();
            System.out.println(firstName + " " + mid + " " + lastName + " " + score);
        }
        
        input.close();
    }
}
