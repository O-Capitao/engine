package com.fcorreia.engine.util;

import com.fcorreia.engine.scene.Scene;
import com.fcorreia.engine.things.Point;
import com.fcorreia.engine.things.Shape;
import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.FPSAnimator;
import javax.swing.JFrame;

/**
 *
 * @author fcorreia
 */
public final class MainRunner 
    extends JFrame
        implements GLEventListener{
    
    /***
     * Properties and shit
     */
    private final GLProfile glprofile = GLProfile.getDefault();
    private final GLCapabilities caps;
    private final GLCanvas canvas; 
    private final FPSAnimator animator;
    
    
    /***
     * Logic
     */
    private Scene scene;
    
    
    public MainRunner(){
        
        super("The 2D Engine");
        
        
        //init logic components
        //scene = Scene.makeFlyingBallsScene(10, 600, 600);
        scene = Scene.makeSomething();
        
        
        //System.out.println( scene.toString());
        
        caps = new GLCapabilities(glprofile);
        caps.setDoubleBuffered(true);
        
        canvas = new GLCanvas(caps);
        canvas.addGLEventListener(this);
        
        animator = new FPSAnimator(canvas , 60 );
        
        this.getContentPane().add( canvas );
        
    }
    
    public void run(){
        
        this.setSize(600,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible( true );
        
        this.animator.start();
        
    }

    @Override
    public void init(GLAutoDrawable glad) {
        
        GL2 gl2 = glad.getGL().getGL2();
        
        float[] colorArr = scene.getBackgroundColor();
        gl2.glClearColor( colorArr[0], colorArr[1], colorArr[2], 0f );
    
    }

    @Override
    public void dispose(GLAutoDrawable glad) {
    }

    @Override
    public void display(GLAutoDrawable glad) {
        
        //call scene render
        scene.render(glad);
        scene.update();        
        
        
    }

    @Override
    public void reshape(GLAutoDrawable glad, int i, int i1, int i2, int i3) {
        MainRunner.setup(glad.getGL().getGL2(), glad.getSurfaceWidth(), glad.getSurfaceHeight() );
    }
    
    
    public static void setup( GL2 gl2, int width, int height ) {
        
        gl2.glMatrixMode( GL2.GL_PROJECTION );
        gl2.glLoadIdentity();

        // coordinate system origin at lower left with width and height same as the window
        GLU glu = new GLU();
        glu.gluOrtho2D( 0.0f, width, 0.0f, height );

        gl2.glMatrixMode( GL2.GL_MODELVIEW );
        gl2.glLoadIdentity();

        gl2.glViewport( 0, 0, width, height );
    }    
 
    public static void main ( String[] args ){
        
        
        new MainRunner().run();
        
    }
    
}
