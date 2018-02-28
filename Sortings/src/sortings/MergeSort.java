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
public class MergeSort implements SortingsStrategy {
    
    private int[] array;
    private int[] helper;
    
    private int array_size;
    
    private int i;
    private int j;
    private int k;
   
    public void sort (int[] inputArr){
        
        this.array = inputArr;
        this.array_size = inputArr.length;
        this.helper = new int [array_size];
        mergeSort(0, array_size-1);
        
    }
    
    private void mergeSort(int first, int last){
        if (first < last){
            int middle = first+(last-first)/2;
            mergeSort(first, middle);
            mergeSort(middle+1,last);
            merge(first, middle, last);
        }  
    }
     
    private void merge(int low, int middle, int high){
        
	for (int i = low; i<=high; i++){
            helper[i] = array[i];
        }
        
        int i = low;
        int j = middle+1;
        int k= low;
        
        while (i<= middle && j<= high){
            if (helper[i] <= helper [j]){
                array[k] = helper[i];
                i++;
            }else{
                array[k] = helper[j];
                j++;
            }
            k++;
        }
        while (i<=middle){
            array[k] = helper[i];
            k++;
            i++;
        }
    }
}
