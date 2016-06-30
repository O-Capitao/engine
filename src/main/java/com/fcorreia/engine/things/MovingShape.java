package com.fcorreia.engine.things;

import com.fcorreia.engine.things.generic.Vector2D;
import com.fcorreia.engine.things.generic.Shape;
import com.fcorreia.engine.utils.VectorOperations;
import com.fcorreia.engine.behavior.Drawable;
import com.fcorreia.engine.behavior.Movable;
import com.fcorreia.engine.scene.Scene;
import com.fcorreia.engine.things.generic.BoundingBox;
import com.fcorreia.engine.things.generic.FloatColorTriplet;

import com.jogamp.opengl.GLAutoDrawable;

/**
 * Ball that moves in a straight line - constant angle
 * @author fcorreia
 */
public class MovingShape extends Shape implements Drawable, Movable {

    private float radius;
    
    private Vector2D movementVector;
    private Vector2D x0;
    private float dTeta;
    
    
    private float dampCoeficient;
    
    private boolean boundByScene;
    
    private BoundingBox bb;
    
    private Scene sc ; 
    
    
    
    
    public MovingShape(Scene scene ,float tet, float vel, float r, Vector2D x0, FloatColorTriplet color, float dampCoef,
            boolean boundByFrame, float dTeta
            ){
        
        super(MovingShape.calcResolution(r), color );
        
        
        
        
        this.sc = scene;
        this.dTeta = dTeta;
        this.radius = r; 
        
        this.points = Shape.makeCirclePoints(x0, MovingShape.calcResolution(), r); //method overriden
        this.movementVector = new Vector2D( VectorOperations.decomposeIntoVector(vel, tet) );
        this.x0 = x0;
        
        this.dampCoeficient = dampCoef;
        
        bb = new BoundingBox(this);
        this.boundByScene = boundByFrame ;
    }
    
    
    
    @Override
    public void render(GLAutoDrawable glad) {
        
        bb.render(glad);
        super.render(glad);
    }

    @Override
    public void update() {
        
        bb.translate(this.movementVector);
        x0.translate(this.movementVector.getArrayForm());
        
        
        
        this.translate( this.movementVector.getArrayForm() );
        this.rotateShapeAroundItself();
        
        this.dampMovement();
        
        //rebound on screen limits
        if (boundByScene){
            
            if ((this.bb.getWest() <= 0 )||(this.bb.getEast() >= this.sc.getWidth())){
                
                this.movementVector.setX( -this.movementVector.getX() );
                
            }
            
        }
    }
    
    public void dampMovement(){
        this.movementVector.scalarMultiply(this.dampCoeficient);
    }
    
    
    public void rotateShapeAroundItself(){
        for (Vector2D v : this.points ){
            v.rotateAround(this.x0, dTeta);
        }
    }
    
    
    @Override
    public String toString(){
        String out = super.toString();
        
        return out + "\n MovingShape spex: \n"
                        + "radius: " + this.radius + "\n"
                        + "center posi.: " + this.x0.toString() + "\n"
                        + "movement V: " + this.movementVector.toString();
        
        
        
    }
    
    /***
     * Calculate polygon side resolution as function of radius
     */
    public static int calcResolution( float radius ){
        
        if ( radius > 50 ){
            return 20;
        }else if (radius > 40 ){
            return 18;
        }else if ( radius > 30 ){
            return 16;
        }else if ( radius > 20 ){
            return 14;
        }else if ( radius > 15 ){
            return 12;
        }else if ( radius > 10 ){
            return 10;
        }else if ( radius > 8 ){
            return 7;
        }else if ( radius > 5 ){
            return 5;
        }else{
            return 3;
        }
        
    }
    
    /**
     * simple shunt
     * @return 
     */
    public static int calcResolution(){
        return 3;
    }
    
    public Vector2D getX0(){
        return this.x0;
    }
    
    
}
