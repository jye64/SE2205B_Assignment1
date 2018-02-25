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
public class MergeSort implements SortingStrategy {
    
    @Override
    public void mergeSort (int[] array, int first, int last){
        if (first < last){
            int middle = (first+last)/2;
            mergeSort(array, first, middle);
            mergeSort(array, middle+1,last);
            merge(array, first, middle, last);
        }  
    }
     
    public void merge(int[] array, int low, int middle, int high){
        
	int[] helper = new int[array.length];
	for (int i = low; i <= high; i++) {
		helper[i] = array[i];
	}
	
	int helperLeft = low;
	int helperRight = middle+1;
	int current = low;
	
	while (helperLeft <= middle && helperRight <=high) {
		if(helper[helperLeft] <= helper[helperRight]){
			array[current] = helper[helperLeft];
			helperLeft++;
			
		}else{
			array[current] = helper[helperRight];
			helperRight++;
		}
		current ++;		
	}
	
	int remaining = middle - helperLeft;
	for (int i = 0; i <= remaining; i++) {
		array[current+i] = helper[helperLeft+ i];
	}
    }

  

    @Override
    public void selectionSort(int[] array) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
