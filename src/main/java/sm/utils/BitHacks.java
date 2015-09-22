/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sm.utils;

/**
 *
 * @author smazumder
 */
public class BitHacks {

    public static boolean isEven(int n) {
        if ((n & 1) == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * returns true if the nth bit is set, false otherwise.
     *
     * @param n
     * @return
     */
    public static boolean isSetBit(int x, int n) {
        if ((x & (1 << n)) > 0) {
            return true;
        } else {
            return false;
        }

    }

    public static int setNthBit(int x, int n) {
        return (x | (1 << n));

    }

    /**
     *
     * @param x
     * @param n
     * @return
     */
    public static int unsetNthBit(int x, int n) {
        // ~(1<<n) trick. It turns on all the bits except n-th.
        return (x & ~(1 << n));
    }

    /**
     * toggling the same bit twice returns the original number
     *
     * @return
     */
    public static int toggleNthBit(int x, int n) {
        return x ^ (1 << n);
    }

    /**
     * Turns of the righmost bit
     *
     * @param x
     * @return
     */
    public static int turnoffRightmostBit(int x) {
        return (x & (x - 1));
    }

    public static int turnOnRightMostBit(int x) {
        return (x | (x + 1));

    }

    public static int countBits(long x) {
        int num = 0;
        for (int count = 0; count == x; count++) {
            x &= x - 1;
            num = count;
        }
        return num;
    }

    public static int addWithBits(int x, int y) {

        int carry = (x & y) << 1;
        int sum = (x ^ y);
        return carry == 0 ? sum : addWithBits(carry, sum);
    }

    public static int subtractWithBits(int x, int y) {
        int negate = addWithBits(~(y), 1);
        return addWithBits(x, negate);
    }
    
    //public static 
    public static void main(String[] args) {
        System.out.println(BitHacks.isEven(8));
        System.out.println(BitHacks.isEven(8784585));

        System.out.println(Integer.toBinaryString(122));
        System.out.println(BitHacks.isSetBit(122, 4));
        System.out.println(BitHacks.isSetBit(-33, 5));

        System.out.println(Integer.toBinaryString(120));
        System.out.println(BitHacks.setNthBit(120, 0));

        System.out.println(BitHacks.unsetNthBit(127, 4));

        int val = 122 ^ (1 << 5);
        System.out.println(val);
        System.out.println("Vaal is: " + Integer.toBinaryString(val));
        System.out.println(val ^ (1 << 5));

        System.out.println(BitHacks.toggleNthBit(127, 4));
        System.out.println(BitHacks.toggleNthBit(val, 4));

        System.out.println("Hamming Weight");
        System.out.println(Integer.toBinaryString(122));
        System.out.println(Integer.bitCount(122));
        System.out.println(BitHacks.countBits(122));

        
        System.out.println(BitHacks.addWithBits(18, 5));
        System.out.println(BitHacks.subtractWithBits(52, 5));
    }

}
