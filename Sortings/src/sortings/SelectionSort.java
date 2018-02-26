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
public class SelectionSort implements SortingsStrategy{

    @Override
    public void sort(int[] array) {
        for (int i=0; i<array.length-1; i++){
            int min_Index = i;
            for (int j=i+1; j<array.length; j++){
                if (array[j] < array[i]){
                    min_Index = j;
                }
                int smallerElement = array[min_Index];
                array[min_Index] = array[i];
                array[i] = smallerElement;
            }
           
        }
    }
}
    

