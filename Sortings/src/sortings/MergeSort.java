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
    
    @Override
    public void sort(int[] array) {
        new Thread(()->{
            mergeSort(array,0,array.length-1); 
        }).start();
    }
    
    void mergeSort(int[] array, int first, int last){
        if(first<last){
            int mid = (first+last)/2;
            mergeSort(array,first,mid);
            mergeSort(array,mid+1,last);
            merge(array,first,mid,last);
        }
    }
    
    void merge(int[] a, int first, int mid, int last){
        int [] temp=new int[a.length];
        System.arraycopy(a, 0, temp, 0, a.length);
        
        int beginHalf1=first;
        int endHalf1=mid;
        int beginHalf2=mid+1;
        int endHalf2=last;
        int index=first;
        
        while(beginHalf1<=endHalf1&&beginHalf2<=endHalf2)
        {
            if (temp[beginHalf1]<temp[beginHalf2])
            {
                a[index]=temp[beginHalf1];
                beginHalf1++;
            }else{
                a[index]=temp[beginHalf2];
                beginHalf2++;
            }
            index++;
            try {
                Thread.sleep(30);
            }catch (InterruptedException ex) {
                System.out.println("Error in Merge Sort.");
            }     
        }
        
        while(beginHalf1<=endHalf1){
            a[index]=temp[beginHalf1];
            beginHalf1++;
            index++;
        }
        
        while(beginHalf2<=endHalf2){
            a[index]=temp[beginHalf2];
            beginHalf2++;
            index++;
        }
    }
}
