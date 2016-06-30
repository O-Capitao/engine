package com.fcorreia.engine.scene;

import com.fcorreia.engine.things.MovingShape;
import com.fcorreia.engine.things.RotatingMovingShape;
import com.fcorreia.engine.things.generic.Vector2D;
import com.fcorreia.engine.things.generic.Shape;

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
        
        /*float tet, vel, r;
        Vector2D x0;
        float[] color;
        
        for (int i = 0 ; i < n ; i++ )
        {
            
            tet = Shape.makeRandomFloat(0, 2f * (float) Math.PI );
            vel = Shape.makeRandomFloat(0.05f, 1f);
            r = Shape.makeRandomFloat(10, 15);
            color = Shape.makeRandomColor();
            
            x0 = new Vector2D(Shape.makeRandomFloat(0, scene.getWidth()), Shape.makeRandomFloat(0, scene.getHeight()));
            
            scene.shapes.add(new MovingShape(scene, tet, vel, r, x0, color,1.0f, true));
        }
        */
        //add the rotator
        scene.shapes.add( new RotatingMovingShape(scene, (float)Math.PI, 0f, 50f,
                            new Vector2D(scene.width/2f, scene.height/2f) ,new float[]{1f,0f,0f}, 1f, false,
                            0.001f)
                        );
        
        
        
        //return scene;
        
        
    }
    
    public String toString(){
        
        
        String out = "Scene \n";
        
        for (Shape shape : this.shapes ){
            out += "\n " + shape.toString() ;
        }
        
        return out;
    }
    

   
    
}
