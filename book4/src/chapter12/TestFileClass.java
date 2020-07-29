/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter12;

/**
 *
 * @author cis2mye
 */
public class TestFileClass {
    public static void main(String[] args){
        java.io.File file = new java.io.File("image/us.gif");
        System.out.println("Does it exist? " + file.exists());
        System.out.println("The file has " + file.length() + " bytes");
        System.out.println("Can it be read? " + file.canRead());
        System.out.println("Can it be written? "+ file.canWrite());
        System.out.println("Is it a directory? " + file.isDirectory());
        System.out.println("Is it a file? " + file.isFile());
        System.out.println("Is it absolute? " + file.isAbsolute());
        System.out.println("Is it hidden? " + file.isHidden());
        System.out.println("Absolute path is "+ file.getAbsolutePath());
        System.out.println("Last modified on " + new java.util.Date(file.lastModified()));
        
        java.io.File file2 = new java.io.File("image/tin.gif");
        System.out.println("Name1: " + file.getName());
        file = new java.io.File("image/tin.gif");
        if (file.renameTo(file2))
            System.out.println("Name2: " + file.getName());
        else System.out.println("Something wrong");
        
        file = new java.io.File("image/us.gif");
        file.mkdir();
     }
}
