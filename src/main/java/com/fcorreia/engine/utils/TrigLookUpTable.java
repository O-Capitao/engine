package com.fcorreia.engine.utils;

/**
 *
 * @author fcorreia
 */
public class TrigLookUpTable {

    private static TrigLookUpTable table;
    
    // one degree resolution
    public float[] cos;
    public float[] sin;
    
    
    private TrigLookUpTable(){
        
        for (int i = 0 ; i < 360 ; i++ ){
            
            this.sin[i] =(float)Math.sin((double)i * Math.PI / 180d);
            this.cos[i] =(float)Math.cos((double)i * Math.PI / 180d);
            
            
        }
        
    }
    
    public static TrigLookUpTable makeInstance(){
        
        if (TrigLookUpTable.table.cos.length == 0 ){
            
            System.out.println("Building Sin/Cos table");
            return new TrigLookUpTable();
        
        }else{
        
            return TrigLookUpTable.table;
        
        }
        
        
    }
    
    
}
