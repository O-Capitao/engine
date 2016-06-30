package com.fcorreia.engine.things;

import com.fcorreia.engine.scene.Scene;
import com.fcorreia.engine.things.generic.Vector2D;
import com.fcorreia.engine.utils.TrigLookUpTable;

/**
 *
 * @author fcorreia
 */
public class RotatingMovingShape extends MovingShape {
   
    private float deltaTeta, cosTeta, sinTeta;
    
    private float[][] rotationMatrix;
    
    /***
     * Creates a rotating moving - pseudo circle
     * @param scene - Scene to draw
     * @param tet - Angle of v0
     * @param vel - Magnitude of v0
     * @param r - radius of the supersphere
     * @param x0 - initial position
     * @param color - float triplet
     * @param dampCoef - damping
     * @param boundByFrame - reflect at boundaies?
     * @param deltaTeta - constant ang. velocity
     */
    public RotatingMovingShape(Scene scene, float tet, float vel, float r,
                                Vector2D x0, float[] color, float dampCoef, 
                                boolean boundByFrame, float deltaTeta) {
        
        
        
        super(scene, tet, vel, r, x0, color, dampCoef, boundByFrame);
        
        
        this.deltaTeta = deltaTeta;
        
        this.sinTeta = TrigLookUpTable.getSinOf( deltaTeta );
        this.cosTeta = TrigLookUpTable.getCosOf( deltaTeta );
    }
    
    @Override
    public void update(){
        
        //angles 
        //angle += angularVelocity;
        this.rotatePointsAroundCenter(1f);
        
        super.update();
        
        System.out.println(this.toString());
                
    }
    
    
   

    
    
    private void rotatePointsAroundCenter(float teta){
        
        for (Vector2D v2d : this.points){
            
            v2d.rotateAround(this.getX0(), teta);
            
            
        }
        
    }
    
    
}
