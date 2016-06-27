package com.fcorreia.engine.things.generic;

/**
 *
 * @author fcorreia
 */
public class Vector2D {
    
    private final float[] point;
    
    public Vector2D( float[] point ){

        this.point = new float[] {point[0], point[1] };

    }
    
    public Vector2D(float x, float y){
        this.point = new float[] { x , y };
        
    }

    public float getX() {
        return point[0];
    }

    public void setX(float x) {
        this.point[0] = x;
    }

    public float getY() {
        return point[1];
    }

    public void setY(float y) {
        this.point[1] = y;
    }
    
    
    public float[] getArrayForm(){
        return this.point;
    }
    
    
    /**
     * @param displacement*****/
    public void translate( float[] displacement ){
        this.point[0] += displacement[0];
        this.point[1] += displacement[1];
    }
    
    /***
     * Planar rotation 
     * @param pivot 
     */
    public void revolveAround(Vector2D pivot){
        
    }
    
    /**
     * subtract in the form : 
     *  this_point - other_point
     * @param other
     * @return Array (in the form of point object)
     */
    public Vector2D subtract(Vector2D other){
        
        return new Vector2D( this.getX() - other.getX() , this.getY() - other.getY() );
        
    }
    
    public float norm(){
        return (float)(Math.sqrt( Math.pow((double)this.getX(), 2) + Math.pow( (double)this.getY(), 2)  ));
    }
    
    
    public float distanceTo(Vector2D other){
        
        return this.subtract(other).norm();
        
    }
    
    public void scalarMultiply( float scalar ){
        
        float[] current = this.getArrayForm();
        
        current[0] *= scalar ;
        current[1] *= scalar ;        
        
    }
    
    @Override
    public String toString(){
        
        return "{x: " + Float.toString(point[0]) + " ,y: " + Float.toString(point[1]) + " }";
        
    }
    
    
    
}
