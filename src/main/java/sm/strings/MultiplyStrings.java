/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sm.strings;

/**
 * Given two numbers represented as strings, return multiplication of the
 * numbers as a string. Note: The numbers can be arbitrarily large and are
 * non-negative.
 *
 * @author smazumder
 */
public class MultiplyStrings {

    public static String multiplyStrings(String s1, String s2) {
        char[] result = new char[s1.length() + s2.length()];

        Integer i1 = Integer.parseInt(s1);
        Integer i2 = Integer.parseInt(s2);

        Integer product = i1 * i2;
        return product.toString();
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
                while (needToFind[s.charAt(start)] == 0 || 
                        hasFound[s.charAt(start)] > needToFind[s.charAt(start)]) {
                    if(hasFound[s.charAt(start)] > needToFind[s.charAt(start)])
                        hasFound[s.charAt(start)]--;
                    start++;
                }
                if(end - start + 1 < minWindowSize) {
                    minWindowSize = end - start + 1;
                    window = s.substring(start, end + 1);
                }
            }

        }//end of loop
        return window;
    }



public static void main(String[] args) {

        System.out.println("The answer is: " + MultiplyStrings.multiplyStrings("12", "12"));
        
        System.out.println("The answer is: " + MultiplyStrings.minimumWindow("ADOBECODEBANC", "ABC"));
    }

}
