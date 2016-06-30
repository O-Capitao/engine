package com.fcorreia.engine.things.generic;

import com.fcorreia.engine.behavior.Drawable;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;



/**
 *
 * @author fcorreia
 */
public class Shape implements Drawable{
    
    public Vector2D[] points;
    public FloatColorTriplet color;
    
    
    
    public Shape(int n_points, FloatColorTriplet color ){
    
        this.points = new Vector2D[n_points];
        this.color = color;
        
    }
    
    public void translate( float[] displacement ){
        
        for (Vector2D point : points ){
            point.translate(displacement);
        }
    }

    public Vector2D[] getPoints() {
        return points;
    }

    public void setPoints(Vector2D[] points) {
        this.points = points;
        
    }
    

    
    public void setColor( FloatColorTriplet color ){
        this.color = color;
    }
    
    public FloatColorTriplet getColor(){
        return this.color;
    }
    
   
    @Override
    public void render( GLAutoDrawable glad ) {
        
        GL2 gl2 = glad.getGL().getGL2();

        
        gl2.glLoadIdentity();
        gl2.glBegin( GL2.GL_POLYGON );
        gl2.glColor3f( color.getRed(), color.getGreen(), color.getBlue() );
        
        for ( Vector2D point : this.points ){
            
            gl2.glVertex2f(point.getX(), point.getY() );
            
        }
        
        gl2.glEnd();
    }
    
    
    public static Vector2D[] makeCirclePoints(Vector2D x0, int n, float r){
        
        
        Vector2D[] points =  new Vector2D[n];
        double dTeta = 2d * Math.PI / (double) n ;
        
        
        for (int i = 0 ; i < n ; i++ ){
            
            
            Vector2D point = new Vector2D(x0.getX() + r * (float) Math.cos( (double) i * dTeta ),
                                x0.getY() + r * (float) Math.sin( (double) i * dTeta ));
            
            points[i] = point;
            
        }
        
        return points;
    }
    
    public String toString(){
        
        String output = "";
        
        for (Vector2D point : points){
            output += "\n " + point.toString();
        }
        
        return output;
    }
    
}
