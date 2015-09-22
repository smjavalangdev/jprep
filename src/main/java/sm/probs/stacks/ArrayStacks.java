/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sm.probs.stacks;

import java.lang.reflect.Array;

/**
 * Implement three stacks within the same underlying array
 *
 * @author smazumder
 */

public class ArrayStacks<E> {

    //Denoting the three stacks that can be accessed
    public enum StackNum {
        first(1), second(2), third(3);
        private int value;
        
        private StackNum(int value) {
                this.value = value;
        }
   //Read more: http://javarevisited.blogspot.com/2011/08/enum-in-java-example-tutorial.html#ixzz34HDJhiwC
        
    }

    private int maxArraySize = 90;

    //Maximum size of the inner stack array.
    private final E[] stackArray;
      

    public ArrayStacks(Class<E> clazz) {
        stackArray = (E[]) Array.newInstance(clazz, maxArraySize);
        initializeStacks();
    }

    public ArrayStacks(Class<E> clazz, int maxarraysize) {
        this.maxArraySize = maxarraysize;
        stackArray = (E[]) Array.newInstance(clazz, maxArraySize);
        initializeStacks();
    }

    private void initializeStacks() {
        first = new StackPointer(0, 29, 30);
        second = new StackPointer(30, 59, 30);
        third = new StackPointer(60, 90, 30);

    }

    //Private class for each stack
    private class StackPointer {

        int start;
        int end;
        int index;
        int maxSize;

        StackPointer(int s, int e, int m) {
            this.start = s;
            this.end = e;
            this.maxSize = m;
            index = start;
        }
    }
    private StackPointer first; //points to the first stack
    private StackPointer second;
    private StackPointer third;

    /**
     * Push an item to stack
     *
     * @param stacknum
     * @param value
     */
    public void push(StackNum stacknum, E value) throws Exception {        
        switch (stacknum) {
            case first:
                if (first.index >= first.end) {
                    throw new Exception("First array is full.");
                }
                stackArray[first.index] = value;
                first.index++;
                break;
            case second:
                 if (second.index >= second.end) {
                    throw new Exception("Second array is full.");
                }
                stackArray[second.index] = value;
                second.index++;                
                break;
            case third:
                if (third.index >= third.end) {
                    throw new Exception("Third array is full.");
                }
                stackArray[third.index] = value;
                third.index++;
                break;
            default:
                throw new Exception("Stack not found.");
        }
    }
    
    /**
     * 
     * @param stack
     * @return
     * @throws Exception 
     */
    public E pop(StackNum stack) throws Exception {
        
        E item= null;
        
        switch (stack) {
            case first:
                if (first.index <= first.start) {
                    throw new Exception("First array is empty.");
                }
                item = stackArray[first.index];
                first.index--;
                break;
            case second:
                 if (second.index <= second.start) {
                    throw new Exception("Second array is empty.");
                }
                item = stackArray[second.index];
                second.index--;                
                break;
            case third:
                if (third.index <= third.end) {
                    throw new Exception("Third array is empty.");
                }
                item = stackArray[third.index];
                third.index--;
                break;
            default:
                throw new Exception("Stack not found.");
        }
        return item;
    }

    
}
