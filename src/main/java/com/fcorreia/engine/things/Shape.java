package com.fcorreia.engine.things;

import com.jogamp.opengl.GL2;


/**
 *
 * @author fcorreia
 */
public class Shape {
    
    public Point[] original_points;
    public Point[] working_points;
    
    public float[] color;
    
    public Shape(){}
    
    public void translate( float[] displacement ){
        for (Point point : working_points ){
            point.translate(displacement);
        }
    }

    public Point[] getPoints() {
        return working_points;
    }

    public void setPoints(Point[] points) {
        this.original_points = points;
        this.working_points = points;
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
    
    /***
     * GL FUNCTIONS
    ****/
    /**
     * 
     * @param gl2
     * @param width
     * @param height 
     */

    
    
    public void render( GL2 gl2, int width, int height ) {
        
        

        // draw a triangle filling the window
        gl2.glLoadIdentity();
        gl2.glBegin( GL2.GL_POLYGON );
        gl2.glColor3f( color[0], color[1], color[2] );
        
        for ( Point point : this.working_points ){
            
            gl2.glVertex2f(point.getX(), point.getY() );
            
        }
        
        gl2.glEnd();
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
    

    

    
}
