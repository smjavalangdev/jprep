/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sm.ds.lists;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author smazumder
 */
public class ListProblems<E> {

    /**
     * write a method to remove duplicates from a given list
     */
    public  List removeDups(LinkedList<E> ls) {
        if (ls == null || ls.size() == 0) {
            return null;
        }

        Set aSet = new HashSet();
        ls.stream().forEach((element) -> {
            aSet.add(element);
        });

        return new LinkedList(aSet);
    }
    
    /**
     * This method removes duplicates without using an other buffers on data
     * structures
     * 
     * Use the Runner technique.
     * 
     * @param ls
     * @return 
     */
    public void removeDupsWithoutBuffer(final LinkedList<E> ls) {
        E curr = ls.get(0);
        E runner = curr;
        
        for (int i =0; i< ls.size(); i++) {
            curr = ls.get(i);
            System.out.println("Curr = " + curr);
            for(int j=i++; j<ls.size(); j++){
                runner = ls.get(j);
                System.out.println("Runner = " + runner);
                if (curr.equals(runner)) {
                    ls.remove(j);
                }
            }            
        }      
    }

    /**
     * Implement an algorithm to find the kth to the last element of a singly
     * linked list
     * When the size or the last element index is not known
     *
     */
    public E findKthToLast(final List<E> ls, int k) {
        
       return null;
    }

    /**
     * Implement an algorithm to delete the middle node of a singly linked list.
     */
    public E deleteMiddleNode(List ls) {
        return null;
    }

    /**
     * Partitions a list such that all values smaller than X comes before and
     * all greater comes after.
     */
    public void partition(E pivot) {

    }

    /**
     * Adds two large numbers from two lists where each node contains a digit
     * and returns the result as a list.
     *
     * The numbers are stored in reverse order.
     *
     */
    public List addListNumbers(List ls1, List ls2) {
        return null;
    }

    public boolean isPalindrome(List ls) {
        return false;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(1);
       System.out.println(list);
       ListProblems<Integer> lp = new ListProblems<Integer>();
       //lp.removeDupsWithoutBuffer(list);       
       System.out.println(lp.findKthToLast(list, 3));
       //System.out.println(lp.removeDups(list));
       
    }
}
