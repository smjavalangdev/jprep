/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sm.probs.stacks;

import java.util.ArrayList;
import java.util.Stack;

/**
 * A SetofStacks comprises of several stacks and creates a new one when one of 
 * these stacks have reached its capacity.
 * 
 * @author smazumder
 */
public class SetofStacks {
    
    private final int maxCapacity; //max capacity for each stack
    private final ArrayList<Stack<Integer>> stacks = new ArrayList();
    //Points to the current stack that is being used.
    private int current = 0;
    
    
    public SetofStacks(int capacity) {
        this.maxCapacity = capacity;
        stacks.add(current, new Stack());
    }
    
    public void push(Integer e) {
        checkCapacity();
        stacks.get(current).add(e);
    }
    
    public Integer pop() {
        if (stacks.get(current).isEmpty() && current > 0 ) {
            int index = current -1;
            return stacks.get(index).pop();
        } else {
            return stacks.get(current).pop();
        }
        
    }
    
    public int size() {
        int size = 0;
        size = stacks.stream().map((e) -> e.size()).reduce(size, Integer::sum);
        return size;
    }
    private void checkCapacity() {
        if (stacks.get(current).size() == maxCapacity) {
            //need to create a new stack;
            stacks.add(current++, new Stack());
        }
    }
    
    public static void main(String[] args) {
        SetofStacks s = new SetofStacks(3);
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
         System.out.println("Size before: " + s.size());
        System.out.println("Element: " + s.pop());
        System.out.println("Element: " + s.pop());
        System.out.println("Element: " + s.pop());
        System.out.println("Element: " + s.pop());
        s.push(7);s.push(8);
       
        System.out.println("Element: " + s.pop());
        System.out.println("Size after: " + s.size());
        
        
    }
    
}
