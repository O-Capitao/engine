package com.fcorreia.engine.scene;

import com.fcorreia.engine.things.MovingShape;

import com.fcorreia.engine.things.generic.FloatColorTriplet;
import com.fcorreia.engine.things.generic.Vector2D;
import com.fcorreia.engine.things.generic.Shape;
import com.fcorreia.engine.utils.ScalarOperations;

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
    
    
    private float width, height ; 
    
    private List<Shape> shapes = new ArrayList<>();
    
    private float[] backgroundColor;
    
    
    
    public Scene(float[] backgroundColor, float width, float height){
        
        
        this.width = width;
        
        this.height = height;
        
        this.backgroundColor = backgroundColor;
        
        
    }
    
    public void addElement( Shape newShape ){
        
        this.shapes.add(newShape);
        
    }
    
    public void render( GLAutoDrawable glad ){
        
        GL2 gl2 = glad.getGL().getGL2();
        gl2.glClear( GL.GL_COLOR_BUFFER_BIT );
        gl2.glEnable(GL.GL_MULTISAMPLE);
        gl2.glPushMatrix();
        
        for (Shape shape : shapes ){
            
            shape.render( glad );
                        
        }
        
        gl2.glPopMatrix();
        gl2.glFlush();
        
    }
    
    //
    public void update(){
        for (Shape shape : shapes ){
            
            if (shape instanceof MovingShape){
                ((MovingShape) shape).update();
            }
        }
    }

    public float[] getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(float[] backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }
    
    
    
 /***
     * 
     * @param n - number of balls in scene
     * @param width
     * @param height
     * @return 
     */
    public static void makeFlyingBallsScene(int n, Scene scene){
        
        //scene = new Scene (new float[] {0f,0f,0f}, width, height);
        
        float tet, vel, r;
        Vector2D x0;
        FloatColorTriplet color;
        
        for (int i = 0 ; i < n ; i++ )
        {
            
            tet = ScalarOperations.makeRandomFloat(0, 2f * (float) Math.PI );
            vel = ScalarOperations.makeRandomFloat(0.05f, 1f);
            r = ScalarOperations.makeRandomFloat(10, 15);
            color = FloatColorTriplet.makeRandom();
            
            x0 = new Vector2D(ScalarOperations.makeRandomFloat(0, scene.getWidth()), ScalarOperations.makeRandomFloat(0, scene.getHeight()));
            
            scene.shapes.add(new MovingShape(scene, tet, vel, r, x0, color,1.0f, true, 0.001f));
        }
        
               
        
    }
    
    public static void makeRotatingTriangle(Scene scene){
        
        scene.shapes.add( new MovingShape(scene, 0f,0f, 30f, new Vector2D(scene.width/2, scene.height/2),
                                          FloatColorTriplet.makeWhite(), 1.0f, false, 0.0003f ));   
        
        
    }
    
    public String toString(){
        
        
        String out = "Scene \n";
        
        for (Shape shape : this.shapes ){
            out += "\n " + shape.toString() ;
        }
        
        return out;
    }
    

   
    
}
