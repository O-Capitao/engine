package com.fcorreia.engine.scene;

import com.fcorreia.engine.things.MovingBall;
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
        
        shapes.stream().forEach((shape) -> {
            shape.render( glad );
        });
        
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
    
    public static Scene makeFlyingBallsScene(int n, float width, float height){
        
        Scene scene = new Scene (Shape.makeRandomColor());
        
        float tet, vel, r;
        Point x0;
        float[] color;
        
        for (int i = 0 ; i < n ; i++ )
        {
            
            tet = Shape.makeRandomFloat(0, 2f * (float) Math.PI );
            vel = Shape.makeRandomFloat(0f, 10f);
            r = Shape.makeRandomFloat(1, 50);
            color = Shape.makeRandomColor();
            
            x0 = new Point(Shape.makeRandomFloat(0, width), Shape.makeRandomFloat(0, height));
            
            scene.shapes.add(new MovingBall(tet, vel, n, i, x0, color));
        }
        
        return scene;
        
        
    }
   
    
}
