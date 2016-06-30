package com.fcorreia.engine.utils;

/**
 *
 * @author fcorreia
 */
public class TrigLookUpTable {

    private static TrigLookUpTable instance = null;
   
    // one degree resolution
    private float[] cos = new float[360];
    private float[] sin = new float[360];
   
   
    private TrigLookUpTable(){
       
        for (int i = 0 ; i < 360 ; i++ ){
           
            this.sin[i] =(float)Math.sin((double)i * Math.PI / 180d);
            this.cos[i] =(float)Math.cos((double)i * Math.PI / 180d);
           
           
        }
       
    }
   
    public static TrigLookUpTable makeInstance(){
       
        if (TrigLookUpTable.instance == null ){
           
            System.out.println("Building Sin/Cos table");
            TrigLookUpTable.instance = new TrigLookUpTable();
       
            return TrigLookUpTable.instance;
            
        }else{
            
            return TrigLookUpTable.instance;
       
        }
    }
   
    
    
    public float getSin(float angle){
        
        return this.sin[(int)angle];
        
    }
    
    public float getCos(float angle){
        return this.cos[(int)angle];
    }
    
    
    
    public static float getSinOf(float angle){
            return (float) Math.sin( (double)angle );
    }
    
    
    public static float getCosOf(float angle){
            return (float) Math.cos( (double)angle );
    }    
    
    
    
    public void printThisShit(){
       
   
        System.out.println("SIN COS TABLE");
    
        for (int i = 0 ; i < this.cos.length ; i++ ){
           
            System.out.println(i + "deg: sin -> :" + this.sin[i] + " cos-> :" + this.cos[i]);
           
           
        }
       
       
       
    }
   
   
   
   
}