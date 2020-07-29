
import java.util.Arrays;
import java.util.Date;
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
public class StopWatch {
    
    public static void main(String[] args){
        int[] array = new int[100000];
        Random rand = new Random();
        for (int i = 0; i < array.length; i++){
            array[i] = rand.nextInt(100000) + 1;
        }
        
        //start counting
        StopWatch watch = new StopWatch();
        
        Arrays.sort(array);
        
        watch.stop();
        
        System.out.println("Time elapse: " + watch.getElapsedTime());
    }
    
    private long startTime;
    private long endTime;
    
    //constructors
    StopWatch(){
        this.startTime = (new Date()).getTime();
    }
    
    //getters
    public void getStart(long time){
        this.startTime = time;
    }
    
    public void getEnd(long time){
        this.endTime = time;
    }
    
    //methods
    public void start(){
        this.startTime = (new Date()).getTime();
    }
    
    public void stop(){
        this.endTime = (new Date()).getTime();
    }
    
    public long getElapsedTime(){
        return this.endTime - this.startTime;
    }
}
