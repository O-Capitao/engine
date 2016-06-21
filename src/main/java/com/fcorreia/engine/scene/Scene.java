package com.fcorreia.engine.scene;

import com.fcorreia.engine.things.Point;
import com.fcorreia.engine.things.Shape;
import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author fcorreia
 */
public class Scene {
    
    private List<Shape> shapes = new ArrayList<>();
    private float[] backgroundColor;
    
    
    
    public Scene(float[] backgroundColor){
        
        this.backgroundColor = backgroundColor;
        
        
    }
    
    public void addElement( Shape newShape ){
        
        this.shapes.add(newShape);
        
    }
    
    public void render( GLAutoDrawable glad ){
        
        GL2 gl2 = glad.getGL().getGL2();
        
        gl2.glClear( GL.GL_COLOR_BUFFER_BIT );
        
        gl2.glPushMatrix();
        
        for (Shape shape : shapes ){
            
            shape.render( glad.getGL().getGL2() , glad.getSurfaceWidth() , glad.getSurfaceHeight() );
            
        }
        
        gl2.glPopMatrix();
        
        gl2.glFlush();
        
    }
    
    public void update(){
        for (Shape shape : shapes ){
            shape.translate( new float[] {1,1} );
        }
    }

    public float[] getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(float[] backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
   
    
}
