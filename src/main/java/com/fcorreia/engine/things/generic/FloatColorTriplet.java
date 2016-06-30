package com.fcorreia.engine.things.generic;

import com.fcorreia.engine.utils.ScalarOperations;

/**
 *
 * @author fcorreia
 */
public class FloatColorTriplet {
    
    private float[] array = new float[3];

    public FloatColorTriplet(float[] inArray){
        this.array = inArray;
    }

    public FloatColorTriplet(float r, float g, float b){
        this.array = new float[] {r,g,b};
    }

    public float[] getArray(){
        return this.array;
    }
   
    public float getRed(){
       return this.array[0];
    }

    public float getGreen(){
       return this.array[1];
    }

    public float getBlue(){
       return this.array[2];
    }
   /***
    * static color factories
    */
   
   public static FloatColorTriplet makeBlack(){
       return new FloatColorTriplet(0,0,0);
   }
   
   public static FloatColorTriplet makeWhite(){
       return new FloatColorTriplet(1,1,1);
   }
   
   public static FloatColorTriplet makeRandom(){
       return new FloatColorTriplet( new float[] {
           ScalarOperations.makeRandomFloat(0, 1),
           ScalarOperations.makeRandomFloat(0, 1),
           ScalarOperations.makeRandomFloat(0, 1)
       });
   }
   
}
