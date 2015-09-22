/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sm.probs.stacks;

import java.util.Stack;

/**
 * Implements a Stack with a min() function in addition to push and pop. The 
 * min() function returns the minimum integer in the tack in O(1)
 * 
 * @author smazumder
 */
public class StackWithMin extends Stack<NodeWithMin> {
    
    public Integer push(Integer item) {
        Integer min = Math.min(min(), item);
        NodeWithMin n = new NodeWithMin(min,item);
        return (Integer)super.push(n).value;
    }
 
    public Integer min() {
        if ( this.isEmpty()) return Integer.MAX_VALUE;                
        return (Integer)this.peek().minValue;
    }
    
    public static void main(String[] args) {
        
        StackWithMin s = new StackWithMin();
        s.push(8);
        s.push(5);
        s.push(9);
        s.push(3);
        s.push(10);
        System.out.println("The min element is: " + s.min());
        
    }
    
}