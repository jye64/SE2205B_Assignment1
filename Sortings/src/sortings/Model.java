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
    
    public int getArraySize(){
        return arraySize; 
    }
    
    public void setArraySize(int x){
        arraySize = x;
    }
    
    public boolean isSorted(){
        int smaller = intArray[0];
        for (int i=1; i<arraySize-1; i++){
            if (smaller>intArray[i])
                return false;
        }
        return true;
    }
    
}
