package com.fcorreia.engine.things;

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
    private Point movementVector;
    
    public MovingBall(float tet, float vel, int n, float r, Point x0, float[] color ){
        
        super(n, color);
        
        this.teta = tet;
        this.velocity = vel;
        
        this.radius = r; 
        
        this.points = Shape.makeCirclePoints(x0, n, r);
        this.movementVector = decomposeIntoVector(velocity, teta);
    }
    
    
    
    @Override
    public void render(GLAutoDrawable glad) {
        super.render(glad);
    }

    @Override
    public void update() {
        
        this.translate( this.movementVector.getArrayForm() );
        
    }
    
    public static Point decomposeIntoVector(float magnitude, float teta ){
        
        return new Point( (float) Math.cos( 2d * Math.PI * (double) teta ), (float) Math.sin( 2d * Math.PI * (double) teta ) );
        
    }
    
}
