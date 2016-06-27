package com.fcorreia.engine.things.generic;

import com.fcorreia.engine.behavior.Drawable;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

/**
 *
 * @author fcorreia
 */
public class BoundingBox implements Drawable{ //its also movable, but it will follow its parent object
    
    private float north, south, west, east;
   
    public BoundingBox( Shape shape ){
        
        //init bounds
        north =  shape.points[0].getY();
        south = north;
        
        west = shape.points[0].getX();
        east = west;
        
        
        for (Vector2D point : shape.getPoints()){
            
            if (point.getY() > this.north){
                this.north = point.getY();
            }else if (point.getY() < this.south){
                this.south = point.getY();
            }
            
            if (point.getX() > this.east ){
                this.east = point.getX();
            }else if ( point.getX() < this.west ){
                this.west = point.getX();
            }
            
        }
        
        
    }
    
    public void translate(Vector2D vec){
        
        this.east += vec.getX();
        this.west += vec.getX();
        
        this.south += vec.getY();
        this.north += vec.getY();
        
    }
    

    
    @Override
    public void render(GLAutoDrawable glad) {
    
        GL2 gl2 = glad.getGL().getGL2();
        
        gl2.glBegin(GL.GL_LINE_LOOP);
        
        gl2.glColor3f(1f,1f,1f);
        
        gl2.glVertex2f(west, south);
        gl2.glVertex2f(west, north);
        gl2.glVertex2f(east, north);
        gl2.glVertex2f(east, south);
        
        gl2.glEnd();
        
    }

    public float getNorth() {
        return north;
    }

    public void setNorth(float north) {
        this.north = north;
    }

    public float getSouth() {
        return south;
    }

    public void setSouth(float south) {
        this.south = south;
    }

    public float getWest() {
        return west;
    }

    public void setWest(float west) {
        this.west = west;
    }

    public float getEast() {
        return east;
    }

    public void setEast(float east) {
        this.east = east;
    }




    
    
    
}
