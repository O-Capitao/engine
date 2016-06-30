package com.fcorreia.engine.utils;

import java.util.Random;

/**
 *
 * @author fcorreia
 */
public class ScalarOperations {
    
    /***
     * MAKE RANDOMS
     */
    public static int makeRandomInt(int lowBound, int hiBound){
        
        Random r = new Random();
        
        return (lowBound + r.nextInt(hiBound-lowBound));
        
    }
    
    public static float makeRandomFloat(float lowBound, float hiBound){
        
        Random r  = new Random();
        
        return lowBound + ((hiBound - lowBound) * r.nextFloat());
    
    }
    
    
    
    
}
