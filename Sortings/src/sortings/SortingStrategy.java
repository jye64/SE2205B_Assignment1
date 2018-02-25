/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortings;

/**
 *
 * @author alanye
 */
public interface SortingStrategy {
    
    public void mergeSort(int[] array,int first, int last);
    
    public void selectionSort (int[] array);
    
}
