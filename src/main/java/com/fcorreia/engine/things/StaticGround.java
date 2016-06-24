package com.fcorreia.engine.things;



/**
 *
 * @author fcorreia
 */
public class StaticGround extends Shape {
    
    public StaticGround(float[] color, float width, float height, float heightRatio ) {
        super( 4 , color);
        
        this.points[0] = new Vector2D(0f,0f);
        this.points[1] = new Vector2D(0f, heightRatio * height);
        this.points[2] = new Vector2D(width, heightRatio * height);
        this.points[3] = new Vector2D(width, 0f);
        
        
        
    }
    
    
    
    
    
}
