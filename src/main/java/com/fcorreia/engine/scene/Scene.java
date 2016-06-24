package com.fcorreia.engine.scene;

import com.fcorreia.engine.things.MovingBall;
import com.fcorreia.engine.things.Vector2D;
import com.fcorreia.engine.things.Shape;
import com.fcorreia.engine.things.StaticGround;
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
            
            if (shape instanceof MovingBall){
                ((MovingBall) shape).update();
            }
        }
    }

    public float[] getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(float[] backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    /****
     * THESE ARE THE FACTORIES
     * @return 
     */
    public static Scene ballRolling(){
        
        Scene s = new Scene( new float[] {0f,0f,0f} );
        
        s.addElement(new StaticGround(new float[] {1f,1f,1f}, 600, 600, 0.2f));
        
        
        return s;
    }
    
    public static Scene makeSomething(){
        
        Scene scene = new Scene( new float[] {1f,1f,1f} );
        
        
        Vector2D[] points = new Vector2D[] {new Vector2D(0f,0f),
                                        new Vector2D(50f,50f),
                                        new Vector2D(0f, 100f)};
        
        
        Shape shape = new Shape(3, new float[] {0f,1f,0f} );
        
        shape.setPoints(points);
        
        scene.addElement(shape);
        
        return scene;
        
    }
    
    public static Scene makeTwoFlyingBalls(float width, float height){
        
        Scene s = new Scene(new float[] {0f,0f,0f});
        
        float tet = (float) Math.PI/2;
        float tet2 = - (float) Math.PI/2;
        float tet3 = 0;
        float tet4 = (float) Math.PI ;
        
        
        float vel = 5f;
        float r = 50f;
        
        Vector2D x0 = new Vector2D( width/2, height/2 );
        
        s.shapes.add(new MovingBall(tet, 0, 20, r, x0,  Shape.makeRandomColor() ));
        s.shapes.add(new MovingBall(tet2, vel, 20, r, x0,  Shape.makeRandomColor()));
        s.shapes.add(new MovingBall(tet3, Shape.makeRandomFloat(0, 10), 20, r, x0,  Shape.makeRandomColor()));
        s.shapes.add(new MovingBall(tet4, Shape.makeRandomFloat(1, 2), 20, r, x0,  Shape.makeRandomColor()));
        
        return s;
    }
    
    public static Scene makeFlyingBallsScene(int n, float width, float height){
        
        Scene scene = new Scene (new float[] {0f,0f,0f});
        
        float tet, vel, r;
        Vector2D x0;
        float[] color;
        
        for (int i = 0 ; i < n ; i++ )
        {
            
            tet = Shape.makeRandomFloat(0, 2f * (float) Math.PI );
            vel = Shape.makeRandomFloat(0f, 10f);
            r = Shape.makeRandomFloat(10, 15);
            color = Shape.makeRandomColor();
            
            x0 = new Vector2D(Shape.makeRandomFloat(0, width), Shape.makeRandomFloat(0, height));
            
            scene.shapes.add(new MovingBall(tet, vel, n, r, x0, color));
        }
        
        return scene;
        
        
    }
    
    public String toString(){
        
        
        String out = "Scene \n";
        
        for (Shape shape : this.shapes ){
            out += "\n " + shape.toString() ;
        }
        
        return out;
    }
    

   
    
}
