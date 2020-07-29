/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter12;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 *
 * @author cis2mye
 */
public class ReadFileFromURL {
    public static void main(String[] args){
        System.out.print("Enter a URL: ");
        String URLString = new Scanner(System.in).next();
        String finals = "";
        
        try{
            URL url = new URL(URLString);
            int count = 0;
            Scanner input = new Scanner(url.openStream());
            while(input.hasNext()){
                String line = input.nextLine();
                finals += line;
                count += line.length();
            }
            
            System.out.println("The file size is " + count + " characters");
            System.out.println(finals);
        }
        catch(java.net.MalformedURLException ex){
            System.out.println("Invalid URL");
        }
        catch (java.io.IOException ex){
            System.out.println("I/O Errors: no such file");
        }
    }
}
