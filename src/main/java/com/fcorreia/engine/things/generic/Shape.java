package com.fcorreia.engine.things.generic;

import com.fcorreia.engine.behavior.Drawable;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import java.util.Random;


/**
 *
 * @author fcorreia
 */
public class Shape implements Drawable{
    
    public Vector2D[] points;
    public float[] color;
    
    
    
    public Shape(int n_points, float[] color ){
    
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
    
    public void setColor(float red, float green, float blue){
       this.color = new float[] { red, blue, green };
    }
    
    public void setColor( float[] color ){
        this.color = color;
    }
    
    public float[] getColor(){
        return this.color;
    }
    
   
    @Override
    public void render( GLAutoDrawable glad ) {
        
        GL2 gl2 = glad.getGL().getGL2();

        
        gl2.glLoadIdentity();
        gl2.glBegin( GL2.GL_POLYGON );
        gl2.glColor3f( color[0], color[1], color[2] );
        
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
    
    
    /** Shape generators */
    
    /**
     * Shape generators
     * @param x0
     * @param radius
     * @param divisions
     * @param color
     * @return 
     */
    /*
    
    
    public static Shape makeCircle(Point x0, float radius, int divisions, float[] color ){
        
        Point[] points = new Point[divisions];
        
        double dTeta = 2d * Math.PI / (double) divisions ;
        
        for (int i = 0 ; i < divisions ; i++ ){
            
            
            Point point = new Point(x0.getX() + radius * (float) Math.cos( (double) i * dTeta ),
                                x0.getY() + radius * (float) Math.sin( (double) i * dTeta ));
            
            points[i] = point;
            
        }
        
        Shape shape = new Shape();
        shape.setPoints(points);
        shape.setColor(color);
        
        return shape;
        
    }
    
    public static Shape makeTriangle(Point x0, float radius){
        
        Point[] points = new Point[3];
        
        double dTeta = Math.PI / 3 ;
        
        for (int i = 0 ; i < 3 ; i++ ){
        
            Point point = new Point(x0.getX() + radius * (float) Math.cos( (double) i * dTeta ),
                                x0.getY() + radius * (float) Math.sin( (double) i * dTeta ) );
            
            points[i] = point;
        
        }
               
            Shape shape = new Shape();
            shape.setPoints(points);
            
            return shape;
        
    }
    */
    /**
    * Static Util.
    ***/
    public static float[] makeRandomColor(){
        
        return new float[] { makeRandomFloat(0, 1),makeRandomFloat(0, 1), makeRandomFloat(0, 1) };
        
        //return new float[] {0.5f , 0.2f, 0.1f };
        
        
    }
    
    public static int makeRandomInt(int lowBound, int hiBound){
        
        Random r = new Random();
        
        return (lowBound + r.nextInt(hiBound-lowBound));
        
    }
    
    public static float makeRandomFloat(float lowBound, float hiBound){
        
        Random r  = new Random();
        
        return lowBound + ((hiBound - lowBound) * r.nextFloat());
    
    }

    

}
