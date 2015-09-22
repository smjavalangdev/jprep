/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sm.probs.stacks;

import java.util.Stack;

/**
 * Implementation of a Queue using Stacks
 *
 * @author smazumder
 */
public class StackedQueue<E> {
    /**
     * Contains all the new added elements in the queue. Represents the back of
     * the queue where new elements get added or put.
     */
    private final Stack<E> newest = new Stack();
    /**
     * Contains all the elements that are at the front of the queue. Elements
     * will be dequeued from this stack
     */
    private final Stack<E> oldest = new Stack();

    /**
     * Enqueue an element in the queue.
     */
    public void enqueue(E e) {
        newest.push(e);
    }

    public E dequeue() {
        reverseContentsFromNewest();
        return oldest.pop();
    }

    public E peek() {
        reverseContentsFromNewest();
        return oldest.pop();
    }

    public int size() {
        return (oldest.size() + newest.size());
    }
    
    private void reverseContentsFromNewest() {
        if (oldest.isEmpty()) {
            while (!newest.isEmpty()) {
                oldest.push(newest.pop());
            }
        }
    }
    
    public static void main(String[] args) {
        StackedQueue<Integer> s = new StackedQueue();
        s.enqueue(1);
        s.enqueue(2);
        s.enqueue(3);
        s.enqueue(4);
        System.out.println(s.dequeue());
    }
}
