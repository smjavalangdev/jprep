/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sm.algos;

import java.text.ParseException;
import java.util.BitSet;
import java.util.HashSet;

/**
 *
 * @author smazumder
 */
public class StringProblems {

    /**
     * Given a string, return its integer value.
     *
     */
    public static int atOi(String str) {
        return Integer.parseInt(str);
    }

    public int multiplyStrings(String s1, String s2) {

        int i1 = 0, i2 = 0;

        try {
            i1 = Integer.parseInt(s1);
            i2 = Integer.parseInt(s2);

        } catch (NumberFormatException nfe) {
            System.out.println("Strings needs to contain numbers only.");
        }

        return (i1 * i2);
    }

    /**
     * Given a string S and a string T, find the minimum window in S which will
     * contain all the characters in T in complexity O(n). For example, S =
     * “ADOBECODEBANC” T = “ABC” Minimum window is “BANC”.
     *
     * Note: If there is no such window in S that covers all characters in T,
     * return the empty string “”.
     *
     * If there are multiple such windows, you are guaranteed that there will
     * always be only one unique minimum window in
     *
     * @param s
     * @param t
     * @return
     */
    public static String minimumWindow(String s, String t) {

        String result = null;
        int[] hasFound = new int[256];
        int[] needToFind = new int[256];

        //Create a histogram of all the charecters in t
        for (int i = 0; i < t.length(); i++) {
            needToFind[t.charAt(i)]++;
        }
        int count = 0;
        int minWindowSize = Integer.MAX_VALUE;
        int start = 0, end = 0;
        String window = "";

        for (; end < s.length(); end++) {
            //No matching charecters found 
            if (needToFind[s.charAt(end)] == 0) {
                continue;
            }
            char c = s.charAt(end);

            if (hasFound[c] <= needToFind[c]) {
                count++;
            }
            if (count == t.length()) {
                while (needToFind[s.charAt(start)] == 0
                        || hasFound[s.charAt(start)] > needToFind[s.charAt(start)]) {
                    if (hasFound[s.charAt(start)] > needToFind[s.charAt(start)]) {
                        hasFound[s.charAt(start)]--;
                    }
                    start++;
                }
                if (end - start + 1 < minWindowSize) {
                    minWindowSize = end - start + 1;
                    window = s.substring(start, end + 1);
                }
            }

        }//end of loop
        return window;
    }

    /**
     * Determine if a string has all unique characters.
     *
     * @param str
     * @return true if the string contains unique characters false otherwise.
     */
    public static boolean hasUniqueChars(final String str) {

        BitSet bs = new BitSet();
        boolean hasUnique = true;

        for (int i = 0; i < str.length(); i++) {
            char val = str.charAt(i);
            if (bs.get(val)) {
                hasUnique = false;
                break;
            }
            bs.set(val);
        }
        return hasUnique;
    }

    /**
     * Design an algorithm and write code to remove the duplicate characters in
     * a string without using any additional buffer. 
     * NOTE: One or two additional variables are fine. An extra copy of the 
     * array is not.
     *
     * @param str
     * @return
     */
    public static String removeDups(String str) {
       HashSet hs = new HashSet();
       
       for( Character c : str.toCharArray()) {
          if (!hs.contains(c)) {
              hs.add(c);
          }
       }
       
       return hs.toString();
    }

    public static void main(String[] args) {

        String str = "hcbsdbcsdcdcwjc hhhhwygeqwgeqwye0-12398123";
        System.out.println("The string has unique: " + StringProblems.hasUniqueChars(str));
        System.out.println("Removing dups " + StringProblems.removeDups(str));

    }
}
