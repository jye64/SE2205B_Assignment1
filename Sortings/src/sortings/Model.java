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
public final class Model {
    private int[] intArray;
    private int arraySize;
    private static final int DEFAULT_SIZE = 60;
    
    public Model(int size){
        this.arraySize = size;
        this.reset(size);
    }
    
    public Model(){
        this(DEFAULT_SIZE);
    }
    
    public void reset(int size){
        arraySize = size;
        intArray = null;
        intArray = new int[arraySize];
        Random rand = new Random();
        int flag = 0;  
        boolean repeated;
        while (flag<arraySize){
            int randomNum = rand.nextInt(arraySize)+1;
            repeated = false;
            for (int i=0; i<flag;i++){
                if(intArray[i]==randomNum){
                    repeated = true;
                    break;
                }
            }
            if (repeated == false){
                intArray[flag]=randomNum;
                flag++;
            }
        } 
    }
    
    public int[] getUnsortedList(){
        return intArray;
    }
    
    public int getSize(){
        return arraySize;
    }
    
    public void setSize(int size){
        arraySize = size;
        reset(this.arraySize);
    }
    
    public boolean isSorted(){
        for (int i=0; i<arraySize; i++){
            if (intArray[i]>intArray[i+1])
                return false;
        }
        return true;
    }
}
