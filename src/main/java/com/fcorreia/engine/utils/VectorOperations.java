package com.fcorreia.engine.utils;

import com.fcorreia.engine.things.generic.Vector2D;

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
    public static Vector2D decomposeIntoVector2D(float mag, float ang){
        return new Vector2D(
                mag * (float)Math.cos((double) ang),
                mag * (float)Math.sin((double) ang)
        );
    }
    
    
}
