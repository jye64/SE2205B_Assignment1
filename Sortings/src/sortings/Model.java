/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortings;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author alanye
 */
public class Model {
    
    private int[] intArray;
    private int   arraySize;
    
    
    public void reset(int size){
        
    }
    
    public void getUnsortedList(){
        
        intArray = new int[arraySize];
        for (int i=0; i<arraySize;i++){
            int randomNum = ThreadLocalRandom.current().nextInt(1, arraySize+1);
            intArray[i]=randomNum;
        }
      
        
    }
    
    public int getArraySize(){
       
        return arraySize;
        
    }
    
    public void setArraySize(int x){
        arraySize = x;
    }
    
}
