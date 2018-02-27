/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortings;

import java.util.Random;


/**
 *
 * @author alanye
 */
public class Model {
    
    private int[] intArray;
    private int   arraySize = 50;
    
    public Model(){
        intArray = new int[arraySize];
        Random rand = new Random();
        for (int i=0; i<arraySize;i++){
            int randomNum = rand.nextInt(arraySize)+1;
            intArray[i]=randomNum;
        }
    }
    
    public void reset(int size){
        arraySize = size;
        intArray = null;
        intArray = new int[arraySize];
        Random rand = new Random ();
        for (int i=0; i<arraySize;i++){
            int randomNum = rand.nextInt(arraySize)+1;
            intArray[i]=randomNum;
        }
    }
    
    public int[] getUnsortedList(){
        return intArray;
    }
    
    public int getArraySize(){
        return arraySize; 
    }
    
    public void setArraySize(int x){
        arraySize = x;
    }
    
}
