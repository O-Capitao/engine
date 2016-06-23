package com.fcorreia.engine.things;

import com.fcorreia.engine.utils.VectorOperations;
import com.fcorreia.engine.behavior.Drawable;
import com.fcorreia.engine.behavior.Movable;
import com.jogamp.opengl.GLAutoDrawable;

/**
 * Ball that moves in a straight line - constant angle
 * @author fcorreia
 */
public class MovingBall extends Shape implements Drawable, Movable {

    private float teta; //attack azimuth
    private float velocity; //points per frame
    private float radius;
    private Vector2D movementVector;
    private Vector2D x0;
    
    public MovingBall(float tet, float vel, int n, float r, Vector2D x0, float[] color ){
        
        super(n, color);
        
        this.teta = tet;
        this.velocity = vel;
        
        this.radius = r; 
        
        this.points = Shape.makeCirclePoints(x0, n, r);
        this.movementVector = VectorOperations.decomposeIntoVector2D(velocity, teta);
        this.x0 = x0;
    }
    
    
    
    @Override
    public void render(GLAutoDrawable glad) {
        super.render(glad);
    }

    @Override
    public void update() {
        
        this.translate( this.movementVector.getArrayForm() );
        
    }
    
    @Override
    public String toString(){
        String out = super.toString();
        
        return out + "\n MovingBall spex: \n"
                        + "radius: " + this.radius + "\n"
                        + "velocity: " + this.velocity + "\n"
                        + "teta: " + this.teta + "\n"
                        + "center posi.: " + this.x0.toString() + "\n"
                        + "movement V: " + this.movementVector.toString();
        
        
        
    }
    
}
