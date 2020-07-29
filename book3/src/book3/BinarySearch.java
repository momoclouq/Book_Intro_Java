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
public class BinarySearch {
    public static int binarySearch(int[] list, int key){
        int low = 0;
        int high = list.length - 1;
        
        while (high >= low){
            int mid = (low + high) / 2;
            if (list[mid] == key) return mid;
            if (list[mid] < key) low = mid + 1;
            if (list[mid] > key) high = mid - 1;
        }
        
        return -1;
    }
}
