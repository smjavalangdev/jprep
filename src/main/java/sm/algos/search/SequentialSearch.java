/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sm.algos.search;

/**
 *
 * @author smazumder
 */
public class SequentialSearch<T> {
    
    /**
     * 
     * @param collection
     * @param item
     * @return 
     */
    public boolean search(final T[] collection, T item) {
        for (T t : collection) {
            if (t.equals(item)) {
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        Integer arr[] = { 4, 7,2,99, 34,26, 45 };
        
        SequentialSearch<Integer> ss = new SequentialSearch();
        System.out.println(ss.search(arr, 55));
    }
}
