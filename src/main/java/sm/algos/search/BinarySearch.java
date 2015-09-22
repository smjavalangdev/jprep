/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sm.algos.search;

/**
 *
 * Reference:
 * http://googleresearch.blogspot.com/2006/06/extra-extra-read-all-about-it-nearly.html
 *
 * @author smazumder
 * @param <T>
 */
public class BinarySearch<T extends Comparable<T>> {

    /**
     *
     * @param collection
     * @param item
     * @return
     */
    public boolean search(T[] collection, T item) {

        if (item == null) {
            return false;
        }

        int low = 0, high = collection.length - 1;

        while (low <= high) {
            int idx = low + (low + high / 2);
            int rc = item.compareTo(collection[idx]);

            System.out.println("Printing idx = " + idx);
            System.out.println("Printing rc = " + rc);
            if (rc < 0) { //item is less than idx
                high = idx - 1;
            } else if (rc > 0) {
                low = idx + 1;
            } else { //found the item
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Integer arr[] = {4, 7, 2, 99, 34, 45, 66};

        BinarySearch<Integer> ss = new BinarySearch();
        System.out.println(ss.search(arr, 85));
    }
}
