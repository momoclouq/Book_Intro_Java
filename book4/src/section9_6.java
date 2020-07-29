
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cis2mye
 */
public class section9_6 {
    public static void main(String[] args){
        ex5();
    }
    
    public static void ex3(){
        Date[] days = new Date[8];
        
        for (int i = 0; i < days.length; i++){
            days[i] = new Date( (long) (10000 * Math.pow(10,i)));
            System.out.println(days[i]);
        }
    }
    
    public static void ex4(){
        Random ran1 = new Random(1000);
        
        for (int i = 0; i < 50; i++){
            System.out.print(ran1.nextInt(100) + " ");
        }
    }
    
    public static void ex5(){
        GregorianCalendar gc1 = new GregorianCalendar();
        
        System.out.println("year: " + gc1.get(GregorianCalendar.YEAR));
        System.out.println("month: " + gc1.get(GregorianCalendar.MONTH));
        System.out.println("day: " + gc1.get(GregorianCalendar.DAY_OF_MONTH));
        
        gc1.setTimeInMillis(1234567898765L);
        
        System.out.println("year: " + gc1.get(GregorianCalendar.YEAR));
        System.out.println("month: " + gc1.get(GregorianCalendar.MONTH));
        System.out.println("day: " + gc1.get(GregorianCalendar.DAY_OF_MONTH));
    }
}
