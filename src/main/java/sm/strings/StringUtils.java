/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sm.strings;

/**
 *
 * @author smazumder
 */
public class StringUtils {
    
    public static void printMulTable(int n) {
        
        String s = null;
        for ( int i=1; i <= n; i++ ) {
            for ( int j=1; j <= n; j++) {
                 System.out.println(String.format("%4d", i * j));
            }
            System.out.println();
        }        
    }
    
    public static String reverse(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        char[] arr = new char[s.length()];
        int idx = 0;
        for (int i=s.length()-1; i>=0; i--) {
            arr[idx] = s.charAt(i);
            idx ++;
        }
        return new String(arr);
    }
    
   public static String reverse2(String s) {
       int length = s.length();
       int last = length -1;
       
       char[] chars = s.toCharArray();
       
       for ( int i=0; i< length/2; i++) {
           char c = chars[i];
           chars[i] = chars[last -i];
           chars[last -i] = c;
       }
       return new String(chars);
       
   }
    
    public static void main(String[] args) {
        //StringUtils.printMulTable(12);
        System.out.println(StringUtils.reverse2("suvankar"));
    }
}
