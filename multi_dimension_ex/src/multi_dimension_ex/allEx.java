/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multi_dimension_ex;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author cis2mye
 */
public class allEx {
    
    //ex1
    public static double sumRow(double[][] m, int rowIndex){
        double total = 0;
        
            for (int i= 0; i < m[rowIndex].length; i++){
                total = total + m[rowIndex][i];
            }
        
       return total;
    }
    
    //ex2
    public static double averageMajorDiagonal(double[][] m){
        double total = 0;
        int count = 0;
        
        //algorithm
        for (int i = 0; i < m.length; i++){
            total = total + m[i][i];
            if (i != m.length - 1 - i) {
                total = total + m[m.length - 1 - i][i];
                count++;
            }
            count++;
        }
        
        
        return (total / count);
    }
    
    //ex3
    public static void swap(int k, int q, double[] m){
        double temp = m[k];
        m[k] = m[q];
        m[q] = temp;
    }
    
    public static void bubbleSort(double[] m){
        for (int i = 0; i < m.length; i++){
            for (int k = 0; k < m.length - i - 1; k++) if (m[k] > m[k+1]) swap(k, k+1,m);
        }
    }
    
    public static void showEmployee(){
        double[][] table = new double[7][7];
        double[] result = new double[7];
        
        Scanner terminal = new Scanner(System.in);
        Scanner input = new Scanner(terminal.nextLine());
        
        System.out.println("Enter the table: ");
        int row = 0;
        int column = 0;
        while (true){
            if (!input.hasNextDouble()) input = new Scanner(terminal.nextLine());
            double in = input.nextDouble();
            table[row][column] = in;
            column++;
            
            if (column >= 7) {
                row++;
                column = 0;
            }
            
            if (row >= 7) break;
        }
        
        //calculate total
        for (int i = 0; i < table.length; i++){
            for (int k = 0; k < table[i].length; k++) result[i] = result[i] + table[i][k];
        }
        
        bubbleSort(result);
        
        for(double e : result) System.out.println("-" + e);
    }
    
    //ex5
    public static void get2matrixes(double[][] m1, double[][] m2){
        Scanner terminal = new Scanner(System.in);
        Scanner input;
        
        System.out.println("Enter matrix1: ");
        input = new Scanner(terminal.nextLine());
        
        m1[0][0] = input.nextDouble();
        m1[0][1] = input.nextDouble();
        m1[1][0] = input.nextDouble();
        m1[1][1] = input.nextDouble();
        
        System.out.println("Enter matrix2: ");
        
        input = new Scanner(terminal.nextLine());
        
        m2[0][0] = input.nextDouble();
        m2[0][1] = input.nextDouble();
        m2[1][0] = input.nextDouble();
        m2[1][1] = input.nextDouble();
    }
    
    public static double[][] addMatrix(double[][] a, double[][] b){
        double[][] output = new double[a.length][a.length];
        
        //set up output
        for (int i = 0; i < output.length; i++){
            for (int k = 0; k < output[i].length; k++) output[i][k] = 0;
        }
        
        //ensure nothing bad happened
        if (a.length != b.length) System.out.println("What?");
        else for (int i = 0; i < a.length; i++){
            if (a[i].length != b[i].length) {
                System.out.println("What??");
                break;
            }
        }
        
        //algorithm
        for (int i = 0; i < output.length; i++){
            for (int k = 0; k < output[i].length; k++) output[i][k] = a[i][k] + b[i][k];
        }
        
        return output;
    }
    
    //ex6
    public static double[][] multiplyMatrix(double[][] a, double[][] b){
        double[][] output = new double[a.length][a.length];
        
        //set up output
        for (int i = 0; i < output.length; i++){
            for (int k = 0; k < output[i].length; k++) output[i][k] = 0;
        }
        
        //ensure nothing bad happened
        if (a.length != b.length) System.out.println("What?");
        else for (int i = 0; i < a.length; i++){
            if (a[i].length != b[i].length) {
                System.out.println("What??");
                break;
            }
        }
        
        //algorithm
        for (int i = 0; i < output.length; i++){
            for(int k = 0; k < output[i].length; k++) {
                for (int q = 0; q < output.length; q++){
                    output[i][k] = output[i][k] + a[i][q] * b[q][k];
                }
            }
        }
        
        return output;
    }
    
    //ex7
    public static double findDistance(double[] p1, double[] p2){
        return Math.sqrt(Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2) + Math.pow(p1[2] - p2[2], 2));
    }
    
    public static void ex7(double[][] points){
        double max = 0;
        double[] point1 = points[1];
        double[] point2 = points[2];
        
        for (int i = 0; i< points.length; i++){
            for (int k = i + 1; k < points.length; k++){
                if (i != k) 
                    if (max < findDistance(points[i], points[k])) {
                        max = findDistance(points[i], points[k]);
                        point1 =points[i];
                        point2 = points[k];
                    }
            }
        }
        
        System.out.println("The maximum distance is: " + max);
        System.out.println("Between 2 points: " + Arrays.toString(point1) + " and " + Arrays.toString(point2));
    }
    
    //ex9
    //in another class!
    
    //ex10
    public static void ex10(){
        int[][] matrix = new int[5][5];
        
        int maxrow = 0;
        int maxrv = 0;
        int maxcol = 0;
        int maxcv = 0;
        
        for (int i = 0; i < matrix.length; i++){
            for (int k = 0; k < matrix[i].length; k++) {
                            double value = Math.random() * 10;
                            if (value < 5) matrix[i][k] = 0;
                            else matrix[i][k] = 1;
                            
                            System.out.print(matrix[i][k] + " ");
                        }
            System.out.println("");
        }
        
        for (int r = 0; r < matrix.length; r++){
            int total = 0;
            
            for (int c = 0; c < matrix[r].length; c++)
                if (matrix[r][c] == 1) total++;
            
            if (total > maxrv) {
                maxrow = r;
                maxrv = total;
            }
        }
        
        for (int c = 0; c < matrix.length; c++){
            int total = 0;
            
            for (int r = 0; r < matrix.length; r++)
                if (matrix[r][c] == 1) total++;
            
            if (total > maxcv) {
                maxcol = c;
                maxcv = total;
            }
        }
        
        
        System.out.println("The largest row index: " + maxrow);
        System.out.println("The largest column index: " + maxcol);
        
        
    }
    
    //ex11
    public static int[][] turnNumberMatrix(int number){
        int current2 = 9;
        int[] binaryString = {0,0,0,0,0,0,0,0,0};
        
        while(current2 >= 0){
            if (number >= ((int) Math.pow(2,current2))) {
                number = number - (int) Math.pow(2,current2);
                binaryString[8 - current2] = 1;
            } else current2--;
        }
        
        System.out.println("Array: " + Arrays.toString(binaryString));
        
        if (number != 0) System.out.println("Something is wrong!");
        
        int[][] matrix = new int[3][3];
        for (int i = 0; i < matrix.length; i++){
            for (int k = 0; k < matrix[i].length; k++) matrix[i][k] = binaryString[i*3 + k];
        }
        
        return matrix;
    }
    
    public static void showMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++){
            for (int k = 0; k < matrix[i].length; k++) {
                if(matrix[i][k] == 0) System.out.print("H ");
                else System.out.print("T ");
            }
            System.out.println("");
        }
    }
    
    public static void ex11(){
        Scanner terminal = new Scanner(System.in);
        
        System.out.print("Enter a number between 0 and 511: ");
        int number = terminal.nextInt();
        
        int[][] matrix = new int[3][3];
        
        matrix = turnNumberMatrix(number);
        showMatrix(matrix);
    }
    
    //ex12
    //done
    
    //ex13
    public static int[] locateSmallest(double[][] a){
        int[] location = new int[2];
        int row = 0;
        int column = 0;
        
        double value = a[0][0];
        
        for (int i = 0; i < a.length; i++){
            for (int k = 0; k < a[i].length; k++){
                if (value < a[i][k]) {
                    row = i;
                    column = k;
                    value = a[i][k];
                }
            }
        }
        
        location[0] = row;
        location[1] = column;
        return location;
    }
    
    public static void ex13(){
        double[][] a = {{1,2,3,4}, {312, 120, 1.24}};
        
        System.out.println("Location of the smallest value: " + Arrays.toString(locateSmallest(a)));
    }
    
    //ex14
    public static void ex14(){
        Scanner terminal = new Scanner(System.in);
        
        System.out.print("Enter the size for the matrix: ");
        int size = terminal.nextInt();
        
        int[][] matrix = new int[size][size];
        
        //initialize matrix
        for (int i = 0; i < matrix.length; i++){
            for (int k = 0; k < matrix[i].length; k++) {
                                double value = Math.random() * 1;
                                if (value < 0.5) matrix[i][k] = 0;
                                else matrix[i][k] = 1;
                                
                                System.out.print(matrix[i][k] + " ");
                        }
            System.out.println("");
        }
        
        //check rows
        for (int r = 0; r < size; r++){
            boolean isRow0 = true;
            boolean isRow1 = true;
            
            for (int c = 0; c < size; c++) {
                if (matrix[r][c] == 0) isRow1 = false;
                if (matrix[r][c ]== 1) isRow0 = false;
            }
            
            if (isRow0 && isRow1) System.out.println("Something is wrong!");
            
            if (isRow0) System.out.println("All 0s on row " + r);
            if (isRow1) System.out.println("All 1s on row " + r);
        }
        
        //check columns
        for (int c = 0; c < size; c++){
            boolean isCol0 = true;
            boolean isCol1 = true;
            
            for (int r = 0; r < size; r++) {
                if (matrix[r][c] == 0) isCol1 = false;
                if (matrix[r][c ]== 1) isCol0 = false;
            }
            
            if (isCol0 && isCol1) System.out.println("Something is wrong!");
            
            if (isCol0) System.out.println("All 0s on column " + c);
            if (isCol1) System.out.println("All 1s on column " + c);
        }
        
        //check diagonal from 0,0
        boolean isDiagonalMain0 = false;
        boolean isDiagonalMain1 = false;
        boolean isDiagonalSub0 = false;
        boolean isDiagonalSub1 = false;
        
        for (int r = 0; r < size; r++){
            int c = 0;
            int realr = r;
            
            boolean checkmain0 = true;
            boolean checkmain1 = true;
            boolean checksub0 = true;
            boolean checksub1 = true;
            
            
            while (true){
                if (matrix[realr][c] == 0) {
                    
                    if (realr == c) checkmain1 = false;
                    else checksub1 = false;
                }
                
                if (matrix[realr][c] == 1) {
                   
                    if (realr == c) checkmain0 = false;
                    else checksub0 = false;
                }
                
                realr++;
                c++;
                
                if(c >= size) break;
                if(realr >= size) break;
             }
            
            if (checkmain0) isDiagonalMain0 = true;
            if (checkmain1) isDiagonalMain1 = true;
            if (checksub0) isDiagonalSub0 = true;
            if (checksub1) isDiagonalSub1 = true;
         }
        
        for (int c = 0; c < size; c++){
            int r = 0;
            int realc = c;
            
            boolean checkmain0 = true;
            boolean checkmain1 = true;
            boolean checksub0 = true;
            boolean checksub1 = true;
            
            while (true){
                if (matrix[r][realc] == 0) {
                    if (realc == r) checkmain1 = false;
                    else checksub1 = false;
                }
                
                if (matrix[r][realc] == 1) {
                    
                    if (realc == r) checkmain0 = false;
                    else checksub0 = false;
                }
                
                realc++;
                r++;
                
                if(r >= size) break;
                if(realc >= size) break;
             }
            
            if (checkmain0) isDiagonalMain0 = true;
            if (checkmain1) isDiagonalMain1 = true;
            if (checksub0) isDiagonalSub0 = true;
            if (checksub1) isDiagonalSub1 = true;
        }
        
        //starts from size-1, 0
        for (int r = size-1; r >= 0; r--){
            int c = 0;
            int realr = r;
            
            boolean checkmain0 = true;
            boolean checkmain1 = true;
            boolean checksub0 = true;
            boolean checksub1 = true;
            
            while (true){
                if (matrix[realr][c] == 0) {
                    
                    if (realr == c) checkmain1 = false;
                    else checksub1 = false;
                }
                
                if (matrix[realr][c] == 1) {
                   
                    if (realr == c) checkmain0 = false;
                    else checksub0 = false;
                }
                
                realr--;
                c++;
                
                if(c >= size) break;
                if(realr < 0) break;
             }
            
            if (checkmain0) isDiagonalMain0 = true;
            if (checkmain1) isDiagonalMain1 = true;
            if (checksub0) isDiagonalSub0 = true;
            if (checksub1) isDiagonalSub1 = true;
        }
        
        for (int c = 0; c < size; c++){
            int r = size-1;
            int realc = c;
            
            boolean checkmain0 = true;
            boolean checkmain1 = true;
            boolean checksub0 = true;
            boolean checksub1 = true;
            
            while (true){
                if (matrix[r][realc] == 0) {
                    
                    if (realc == r) checkmain1 = false;
                    else checksub1 =false;
                }
                
                if (matrix[r][realc] == 1) {
                   
                    if (realc == r) checkmain0 = false;
                    else checksub0 = false;
                }
                
                realc++;
                r--;
                
                if(r < 0) break;
                if(realc >= size) break;
             }
            
            if (checkmain0) isDiagonalMain0 = true;
            if (checkmain1) isDiagonalMain1 = true;
            if (checksub0) isDiagonalSub0 = true;
            if (checksub1) isDiagonalSub1 = true;
        }
        
        
        if (isDiagonalMain0) System.out.println("All 0s on the main diagonal");
        if (isDiagonalMain1) System.out.println("All 1s on the main diagonal");
         if (isDiagonalSub0) System.out.println("All 0s on the sub diagonal");
        if (isDiagonalSub1) System.out.println("All 1s on the sub diagonal");
        
        //something is wrong but dont worry ,-,
    }
    
    //ex15
    public static boolean sameLine(double[][] points){
        Scanner terminal = new Scanner(System.in);
        Scanner input;
        
        System.out.print("Enter 5 points: ");
        input = new Scanner(terminal.nextLine());
        
        int position = 0;
        int count = 0;
        while(input.hasNextDouble()){
            double in = input.nextDouble();
            points[count][position] = in;
            
            if (position == 1) count++;
            position = 1 - position;
            
            if (count >= points.length) break;
        }
        
        for (int i = 0; i < points.length; i++){
            System.out.println(Arrays.toString(points[i]));
        }
        
        boolean isOn1Line = true;
        
        //algorithm
        double slope = (points[0][0] - points[1][0]) / (points[0][1] - points[1][1]);
        
        for (int i = 1; i < points.length - 1; i++){
            double slope2 =(points[i][0] - points[i+1][0]) / (points[i][1] - points[i+1][1]);
            if (slope != slope2){
                isOn1Line = false;
                break;
            }
        }
        
        if (isOn1Line) System.out.println("The points are on 1 line");
        else System.out.println("They are not on 1 line.");
        
        return isOn1Line;
    }
    
    //ex16
    public static void swap(int i, int k, int[][] m){
        int[] temp = m[i];
        m[i] = m[k];
        m[k] = temp;
    }
    
    public static void sort(int m[][]){
        //based on selection sort
        
        for (int i = 0; i < m.length; i++){
            int smallestIndex = i;
            
            for (int k = i+1; k < m.length; k++) {
                if (m[smallestIndex][0] > m[k][0]) smallestIndex = k;
                if (m[smallestIndex][0] == m[k][0]) 
                    if (m[smallestIndex][1] > m[k][1]) smallestIndex = k;
            }
            
            System.out.print(smallestIndex + "-");
            if (smallestIndex != i) swap(i, smallestIndex ,m);
        }
        
        for (int i= 0; i < m.length; i++){
            System.out.print(Arrays.toString(m[i]) + " + ");
        }
    }
    
    //ex17
    public static boolean checkUnsafe(double[][] borrowers, double limit, boolean[] dead){
        boolean notFound = false;
        
        for (int i = 0; i < borrowers.length; i++){
            double totalAsset = 0;
            
            for (int k = 0; k <borrowers[i].length; k++) {
                if (!dead[k]) totalAsset = totalAsset + borrowers[i][k];
            }
                
            if (totalAsset < limit && !dead[i]) {
                dead[i] = true;
                notFound = true;
                System.out.println("Number " + i + " is dead with " + totalAsset);
            }
        }
        
        return notFound;
    }
    
    public static void ex17(){
        Scanner terminal = new Scanner(System.in);
        Scanner input;
        
        System.out.println("Input: ");
        int numBank = 0;
        double limit = 0;
        
        input = new Scanner(terminal.nextLine());
        numBank = input.nextInt();
        limit = input.nextDouble();
        
        double[][] borrowers = new double[numBank][numBank];
        for (int i = 0; i < borrowers.length; i++){
            for (int k = 0; k < borrowers[i].length; k++) borrowers[i][k] = 0;
        }
        System.out.println("numbank: " + numBank);
        
        int count = 0;
        while(count < numBank){
            input = new Scanner(terminal.nextLine());
            
            double in1 = input.nextDouble();
            int in2;
            borrowers[count][count] = in1;
            
            int rats = 0;
            rats = input.nextInt();
            
            if (rats > numBank - 1) {
                System.out.println("Error!");
                System.exit(1);
            }
            
            for (int i = 0; i < rats; i++){
                in2 = input.nextInt();
                in1 = input.nextDouble();
                borrowers[count][in2] = in1;
            }
            
            
            count++;
            System.out.println(count);
        }
        
        System.out.println("Here 2");
        
        boolean[] dead = new boolean[numBank];
        for (int i = 0; i < dead.length; i++) dead[i] = false;
        
        while(checkUnsafe(borrowers, limit, dead));
        
        System.out.print("The dead: ");
        for (int i = 0; i< dead.length; i++) if(dead[i]) System.out.print(i + " ");
    }
    
    //ex18
    public static void shuffle(int[][] m){
        for (int i = 0; i < m.length; i++){
            for (int k = 0; k < m[i].length; k++){
                int r =(int) Math.random() * m.length;
                int c = (int)Math.random() * m[i].length;
                
                int temp = m[i][k];
                m[i][k] = m[r][c];
                m[r][c] = temp;
            }
        }
    }
    
    //ex19
    public static boolean check4(int r, int c, int[][] values){
        //east
        int count = 0;
        for (int i = c+1; i < values[r].length; i++){
            if (values[r][i] == values[r][c]) count++;
            else break;
            if (count == 3) return true;
        }
        
        //west
        count = 0;
        for (int i = c-1; i >= 0; i--){
            if (values[r][i] == values[r][c]) count++;
            else break;
            if (count == 3) return true;
        }
        
        //north
        count = 0;
        for (int i = r-1; i >= 0; i--){
            if (values[i][c] == values[r][c]) count++;
            else break;
            if (count == 3) return true;
        }

        
        //south
        count = 0;
        for (int i = r+1; i < values.length; i++){
            if (values[i][c] == values[r][c]) count++;
            else break;
            if (count == 3) return true;
        }
        
        //north east
        count = 0;
        for(int i = r -1, k = c + 1; i >= 0 && k < values[i].length; i--, k++){
            if (values[i][k] == values[r][c]) count++;
            else break;
            if (count == 3) return true;
        }
        
        //south east
        count = 0;
        for(int i = r + 1, k = c + 1; i < values.length && k < values[i].length; i++, k++){
            if (values[i][k] == values[r][c]) count++;
            else break;
            
            if (count == 3) return true;
        }
        
         //north west
        count = 0;
        for(int i = r -1, k = c - 1; i >= 0 && k >= 0; i--, k--){
            if (values[i][k] == values[r][c]) count++;
            else break;
            
            if (count == 3) return true;
        }
        
         //north west
        count = 0;
        for(int i = r + 1, k = c - 1; i < values.length && k >= 0; i++, k--){
            if (values[i][k] == values[r][c]) count++;
            else break;
            
            if (count == 3) return true;
        }
        
        return false;
    }
    
    public static boolean isConsecutiveFour(int[][] values){
        Scanner terminal = new Scanner(System.in);
        Scanner input;
        
        System.out.print("Enter number of rows and columns: ");
        int numberR = terminal.nextInt();
        int numberC = terminal.nextInt();
        terminal.nextLine();
        
        values = new int[numberR][numberC];
        
        System.out.println("Now the values: ");
        for (int i = 0; i < numberR; i++){
            input = new Scanner(terminal.nextLine());
            
            for (int k = 0; k < numberC; k++) {
                int in = input.nextInt();
                values[i][k] = in;
            }
        }
        
        for (int i = 0; i < values.length; i++){
            for (int k = 0; k < values[i].length; k++) if(check4(i,k, values)) return true;
        }
        
        return false;
    }
}
