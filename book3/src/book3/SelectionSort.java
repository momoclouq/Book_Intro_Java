/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book3;

/**
 *
 * @author cis2mye
 */
public class SelectionSort {
    public static void selectionSort(int[] list){
        for (int i = 0; i < list.length; i++){
            int temp = i;
            
            for (int k = i + 1 ; k < list.length; k++){
                if (list[k] < temp) temp = k;
            }
            
            int tempk = list[i];
            list[i] = list[temp];
            list[temp] = tempk;
        }         
    }
}
