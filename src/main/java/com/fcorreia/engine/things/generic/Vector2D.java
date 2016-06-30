package com.fcorreia.engine.things.generic;

import com.fcorreia.engine.utils.VectorOperations;

/**
 *
 * @author fcorreia
 */
public class Vector2D {
    
    private final float[] vector;
    
    public Vector2D( float[] point ){

        this.vector = new float[] {point[0], point[1] };

    }
    
    public Vector2D(float x, float y){
        this.vector = new float[] { x , y };
        
    }

    public float getX() {
        return vector[0];
    }

    public void setX(float x) {
        this.vector[0] = x;
    }

    public float getY() {
        return vector[1];
    }

    public void setY(float y) {
        this.vector[1] = y;
    }
    
    
    public float[] getArrayForm(){
        return this.vector;
    }
    
    public void setArrayForm(float[] input){
        this.vector[0] = input[0];
        this.vector[1] = input[1];
    }
    
    
    /**
     * @param displacement*****/
    public void translate( float[] displacement ){
        this.vector[0] += displacement[0];
        this.vector[1] += displacement[1];
    }
    
    /***
     * Planar rotation 
     * @param pivot 
     */
    public void rotateAround(Vector2D pivot, float teta){
       
        
        float[] increment =  VectorOperations.rotateVectorAroundVector(this.getArrayForm(), pivot.getArrayForm(), teta) ;
        System.out.println("Rotate debug: \n " + increment[0] + increment[1]);
        
        
        this.setArrayForm( increment );
    
        
    
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
    
    //public float norm(){
    //    return (float)(Math.sqrt( Math.pow((double)this.getX(), 2) + Math.pow( (double)this.getY(), 2)  ));
    //}
    
    public float norm(){
        return VectorOperations.getVectorNorm(this.vector);
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
        
        return "{x: " + Float.toString(vector[0]) + " ,y: " + Float.toString(vector[1]) + " }";
        
    }
    
    
    
}
