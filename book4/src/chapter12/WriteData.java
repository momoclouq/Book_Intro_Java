/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter12;

import java.io.File;
import java.io.PrintWriter;

/**
 *
 * @author cis2mye
 */
public class WriteData {
    public static void main(String[] args) throws java.io.IOException{
        try {
            WriteDataWithAutoClose.start();
        } catch (Exception ex){
            System.out.println(ex);
        }
        
    }
}

class WriteDataWithAutoClose{
    public static void start() throws Exception{
       File file = new File("image/scores.txt");
       if (file.exists()){
           System.out.println("File already exists");
           System.exit(1);
       }
       
       try (
               PrintWriter output = new PrintWriter(file);
               ){
                   output.print("John T ask ");
                   output.println(90);
               }
    }
}
