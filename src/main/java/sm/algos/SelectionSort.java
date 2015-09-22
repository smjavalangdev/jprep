/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.algos;

import java.util.Arrays;

/**
 * Selection sort works by starting from the first element of the array and then
 * scanning through the array in order to find the minimum key and then swapping
 * the first element with the key index.
 *
 * It is an in-place algorithm with complexity O(n^2)
 *
 *
 * @author smazumder
 */
public class SelectionSort {

    private static int findMinimumIndex(int[] arr, int start) {
        int minIndex = start;

        for (int i = start + 1; i < arr.length; i++) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    private static void swap(int[] arr, int idx1, int idx2) {
        int tmp = -1;

        if (idx1 != idx2) {
            if (idx1 >= 0 && idx1 < arr.length) {
                tmp = arr[idx1];
            }
            if (idx2 >= 0 && idx2 < arr.length) {
                arr[idx1] = arr[idx2];
                arr[idx2] = tmp;
            }
        }
    }

    private static void sortRecursive(int[] arr, int start) {
        if (start < arr.length - 1) {
            swap(arr, start, findMinimumIndex(arr, start));
            sortRecursive(arr, start + 1);
        }
    }

    public static void sort(int[] list) {
        sortRecursive(list, 0);
    }
    
    public static void main(String[] args) {
        int[] val = {7,8,3,2,1,3,6};
        SelectionSort.sort(val);
        System.out.println(Arrays.toString(val));
    }

}
