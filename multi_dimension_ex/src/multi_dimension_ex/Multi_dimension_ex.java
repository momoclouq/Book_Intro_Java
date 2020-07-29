/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multi_dimension_ex;

import java.util.Arrays;

/**
 *
 * @author cis2mye
 */
public class Multi_dimension_ex {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //ex1
        //double[][] m = {{1,2,3,4}, {1.2, 3.5, 12, 31,52}, {0}};
        //System.out.println("Result: " + allEx.sumRow(m, 1));
        
        //ex2
        //double[][] m = {{1,2,3,4,5}, {1, 2, 3, 4,5}, {1,2,3,4,5},{1,2,3,4,5}, {1,2,3,4,5}};
        //System.out.println("Result: " + allEx.averageMajorDiagonal(m));
        
        //ex5
        double[][] m1 = new double[2][2];
        double[][] m2 = new double[2][2];
        //allEx.get2matrixes(m1, m2);
        //double[][] output = allEx.addMatrix(m1, m2);
        
        //ex6
        //double[][] output = allEx.multiplyMatrix(m1, m2);
        //System.out.println("Final matrix: ");
        //for (int i = 0; i < output.length; i++){
        //    for (int k = 0; k < output[i].length; k++) System.out.print(output[i][k] + " ");
        //    System.out.println("");
        //}
        
        //ex7
        //double[][] points = {{-1, 0, 3} , {-1, -1, -1}, {4,1,1},
        //    {3, 0.5, 9}, {3.5,2,-1}, {3,1.5,3}, {-1.5,4,2}, {5.5, 4, -0.5}};
        //allEx.ex7(points);
        
        
        //ex9
        //tictactoe.play();
        
        //ex10
        //allEx.ex10();
        
        //ex11
        //allEx.ex11();
        
        //ex13
        //allEx.ex13();
        
        //ex14
        //allEx.ex14();
        
        //ex15
        //double[][] points = new double[5][2];
        //allEx.sameLine(points);
        
        
        //ex16
        int[][] m = {{4,2}, {1,7},{4,5}, {1,2}, {1,1}, {4,1}};
        //allEx.sort(m);
        
        //ex17
        //allEx.ex17();
        
        //ex18
        allEx.shuffle(m);
        //for (int i = 0; i < m.length; i++) System.out.println(Arrays.toString(m[i]));
        
        //ex19
        int[][] values = new int[6][7];
        if(allEx.isConsecutiveFour(values)) System.out.println("true!");
        else System.out.println("false");
    }
    
    
    
}
