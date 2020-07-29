/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meanvariance2;

import java.util.Random;

/**
 *
 * @author cis2mye
 */
public class MeanVariance2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Random rand1 = new Random();
        int [] data = new int[10000000];
        int i;
    
        for (i = 0; i < data.length; i++) {
            data[i] = 20 + rand1.nextInt(80);   // [20..99]
        }
        
        int n = data.length;
        int d;
        double diff;
        double sum;
        double sum2;
        double mean;
        double variance;
        long startTime;
        long endTime;
        long elapsedTime;
        
        startTime = System.currentTimeMillis();
        // First Method (fetch the data twice)
        /*
        sum = 0;
        for (i = 0; i < n; i++) {
            sum += data[i];
        }        
        mean = sum / n;
        sum2 = 0;   // sum(x[i] - mean)^2
        for (i = 0; i < n; i++) {
            diff = data[i] - mean;
            sum2 += diff*diff;
        }
*/
        for (i = 0; i < 100000; i++){
            System.out.print("a");
        }
        for (i = 0; i < 100000; i++){
            System.out.print("a");
        }
        System.out.println();
        endTime = System.currentTimeMillis();
        //System.out.printf("The mean of %d data is %1.4f.\n",n,mean);
        //variance = sum2 / n;
        //System.out.printf("The variance of %d data is %1.4f.\n",n,variance);
        elapsedTime = endTime - startTime;
        System.out.printf("The elapsed time is %d ms.\n",elapsedTime);
        
        // Second method
        System.out.printf("Now using the second method....\n");
        startTime = System.currentTimeMillis();
        /*
        sum = 0;
        sum2 = 0;
        
        for (i = 0; i < n; i++) {
            d = data[i];
            sum += d;
            sum2 += d * d;
        }
        
        
        mean = sum / n;
        variance = (sum2 - (sum*sum)/n) / n;
        endTime = System.currentTimeMillis();
        System.out.printf("The mean of %d data is %1.4f.\n",n,mean);
            */
        for (i = 0; i < 100000; i++){
            System.out.print("a");
            System.out.print("a");
        }
        System.out.println();
        //System.out.printf("The variance of %d data is %1.4f.\n",n,variance);
        endTime = System.currentTimeMillis();
        elapsedTime = endTime - startTime;
        System.out.printf("The elapsed time is %d ms.\n",elapsedTime);

    }
    
}
