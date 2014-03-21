/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package index;
import java.util.*;
import java.lang.*;
/**
 *
 *  
 */
public class Ext {
    public String ext(String x){
        int mid=x.lastIndexOf(".");
        return x.substring(mid+1,x.length());
    }
}
