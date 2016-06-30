package com.fcorreia.engine.utils;

/**
 * Static functions to conveniently handle simple algebra
 * @author fcorreia
 */
public class VectorOperations {
   
    /**
     * Form 2D vector
     * @param mag - Magnitude
     * @param ang - Angle
     * @return  - Vector2D object
     */
    public static float[] decomposeIntoVector(float mag, float ang){
        return new float[]{
                mag * (float)Math.cos((double) ang),
                mag * (float)Math.sin((double) ang)
        };
    }
    
   
    /**
     * Rotates vector around origin.
     * @param vector - original or transformed vector
     * @param teta - angle, in radians
     * @return transformed vector
     */
    public static float[] rotateVectorAroundOrigin(float[] vector, float teta){
       
        TrigLookUpTable tlut = TrigLookUpTable.makeInstance();
       
        return new float[] { vector[0] * tlut.getCos(teta) ,
                             vector[1] * tlut.getSin(teta)
           
        };
       
    }
    
    public static float[] rotateVectorAroundVector(float[] vector, float[] pivot, float teta){
        
        return vectorSum( pivot, rotateVectorAroundOrigin(vectorDifference(vector, pivot), teta));
        
    }
    
    /**
     * Calculate size of Vector
     * @param vector
     * @return 
     */
    public static float getVectorNorm(float[] vector){
        
        return (float)(Math.sqrt( Math.pow((double)vector[0], 2) + Math.pow( (double)vector[1], 2)  ));
        
    }
    
    public static float[] vectorDifference(float[] vector1, float[] vector2){
        
        return new float[]{ vector1[0] - vector2[0], vector1[1] - vector2[1] };
        
    }
    
    public static float[] vectorSum(float[] vector1, float[] vector2){
        
        return new float[]{ vector1[0] + vector2[0], vector1[1] + vector2[1] };
        
    }
            
   
   
}