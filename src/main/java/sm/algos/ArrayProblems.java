/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sm.algos;

import java.util.HashMap;
import java.util.HashSet;
import java.util.logging.Logger;

/**
 * Implementation of Kandane's algorithm in order to find the largest subarray
 *
 * Kadane's Algorithm(array[1..n]) begin (maxSum, maxStartIndex, maxEndIndex) :=
 * (-INFINITY, 0, 0) currentMaxSum := 0 currentStartIndex := 1 for
 * currentEndIndex := 1 to n do currentMaxSum := currentMaxSum +
 * array[currentEndIndex] if currentMaxSum > maxSum then (maxSum, maxStartIndex,
 * maxEndIndex) := (currentMaxSum, currentStartIndex, currentEndIndex) endif
 *
 * if currentMaxSum < 0 then currentMaxSum := 0 currentStartIndex :=
 * currentEndIndex + 1 endif endfor
 *
 * return (maxSum, maxStartIndex, maxEndIndex) end Implemetation in scala scala:
 * numbers.scanLeft(0)((acc, n) => math.max(acc, acc + n)).max
 *
 * @author smazumder
 */
public class ArrayProblems {


    /**
     * Given an array, kandane returns the max subarray.
     *
     * Solves this problem in O(N) time
     *
     * @param arr
     * @return
     */
    public static int kandane(int[] arr) {

        int currentMaxSum = 0, overallMaxSum = 0;

        for (int element : arr) {

            currentMaxSum = currentMaxSum + element;

            if (currentMaxSum > 0) {
                overallMaxSum = Math.max(overallMaxSum, currentMaxSum);
            } else {
                //we will ignore the current max sum and reset it to 0
                currentMaxSum = 0;
            }

        }
        return overallMaxSum;

    }

    /**
     * Divide and conquer algorithm for solving the max sub-array problem.
     * Solves it N Log N time
     *
     *
     * @return
     */
    public static int bentleyMaxSum(int[] arr, int leftIndex, int rightIndex) {
        //Base cases 
        if (leftIndex > rightIndex) {//No more elements in the array
            return 0;
        }

        if (leftIndex == rightIndex) { //One element left
            return Math.max(0, arr[leftIndex]);
        }
        //Next split the array in half
        int indexSum = leftIndex + rightIndex;
        int m = indexSum / 2;

        //Find the max crossing to the left
        int lMaxSum = 0;
        int currSum = 0;
        for (int i = m; i >= leftIndex; i--) {
            currSum = currSum + arr[i];
            if (currSum > lMaxSum) {
                lMaxSum = currSum;
            }
        }
        //Find the max crossing to the right
        int rMaxSum = 0;
        int currRightSum = 0;
        for (int j = m + 1; j <= rightIndex; j++) {
            currRightSum = currRightSum + arr[j];
            if (currRightSum > rMaxSum) {
                rMaxSum = currRightSum;
            }
        }

        return Math.max(Math.max(bentleyMaxSum(arr, leftIndex, m),
                bentleyMaxSum(arr, m + 1, rightIndex)), lMaxSum + rMaxSum);
    }

    /**
     * Given an array of positive and negative integers, return true if the sum
     * of any two numbers in the array equals k
     *
     * hasArrayTwoCandidates (A[], arr_size, sum)
     *
     * 1) Sort the array in non-decreasing order.
     *
     * 2) Initialize two index variables to find the candidate elements in the
     * sorted array. (a) Initialize first to the leftmost index: l = 0 (b)
     * Initialize second the rightmost index: r = ar_size-1
     *
     * 3) Loop while l < r. (a) If (A[l] + A[r] == sum) then return 1 (b) Else
     * if( A[l] + A[r] < sum ) then l++ (c) Else r-- 4) No candidates in whole
     * array - return 0
     *
     * @param arr
     * @param k
     * @return
     */
    public static boolean subArraySumEqualsK(int[] arr, int k) {

        //sort the given array - new in Java 8
        java.util.Arrays.parallelSort(arr);
        int left = 0;
        int right = arr.length - 1;

        int currPairSum = 0;
        while (left < right) {

            currPairSum = arr[left] + arr[right];
            if (currPairSum == k) {
                System.out.println(arr[left]);
                System.out.println(arr[right]);
                return true;
            } else if (currPairSum < k) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    /**
     * More efficient algorithm using a hashSet
     *
     * @param arr
     * @param k
     * @return
     */
    public static boolean subArraySumEqualsK2(int[] arr, int k) {
        HashSet<Integer> binSet = new HashSet<Integer>();

        for (int ele : arr) {
            if (binSet.contains(k - ele)) {
                System.out.println(ele + "," + (k - ele));
                return true;
            }
            binSet.add(ele);
        }
        return false;
    }

    /**
     * Find if there is a subarray with zero sum.
     *
     * Two ways of solving this, one by brute force, the other by storing the
     * incremental sums in a hashmap.
     *
     * Complexity = O(N)
     *
     * @param args
     */
    public static boolean zeroSumSubArray(int[] arr) {
        HashMap<Integer, Integer> sumMap = new HashMap();

        int currSum = 0;
        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            if (arr[i] == 0 || currSum == 0 || sumMap.get(i) != null) {
                return true;
            }
            System.out.println("Zero subarray index: " + i);
            sumMap.put(currSum, i);
        }

        return false;
    }

    /**
     * given an array of integers and a number x, find the smallest subarray with
     * sum greater than x.
     * Examples:
     * arr[] = {1, 4, 45, 6, 0, 19}
     * x  =  51
     * Output: 3
     * 
     * Minimum length subarray is {4, 45, 6}
     * 
     * Time = O( N ^2)
     * 
     * @param args 
     */
    public static int smallestSubArraySum(int[] arr, int x) {
        //If there is no subarray with a sum greater than x then return -1
        int n = arr.length;
        int minlength = n + 1;
        int currSum =0;
        
        for( int start=0; start < n; start++) {
            //current sum starts from the first element
            currSum = arr[start];            
            //current sum is greater than x already
            if (currSum > x) return 1;
            
            for(int end=start + 1; end < n; end++) {
                currSum += arr[end];
                
                if ( currSum > x && (end - start + 1) < minlength) {
                  minlength = (end - start + 1);
                }
            }            
        }        
        return minlength;
    }
    
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -60, 54, 3};
        int[] arr2 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] arr3 = {31, -41, 59, 26 - 53, 58, 97, -93, -23, 84};
        int[] arr4 = {2, -3, 7, 0, 60, 5, -1};
        int[] arr5= {4,-3, 6, 9, 12, -22, 13, 27 -4 };

        System.out.println("The current max sum is = " + ArrayProblems.kandane(arr5));
        System.out.println("The current max sum is = " + ArrayProblems.bentleyMaxSum(arr, 0, 12));
        System.out.println("Running the new method.");
        System.out.println("Has a pair: " + ArrayProblems.subArraySumEqualsK2(arr4, 67));

        System.out.println("Has a zero subarray: " + ArrayProblems.zeroSumSubArray(arr));
        
        int[] arr6 = {1, 4, 45, 6, 0, 19};
        System.out.println("Min Subarray with sum greater than: + " + ArrayProblems.smallestSubArraySum(arr5, 51));
    }

}
