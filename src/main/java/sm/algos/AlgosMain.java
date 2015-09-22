/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sm.algos;

import java.util.Arrays;
import java.util.logging.Logger;

/**
 *
 * @author smdeveloper
 */
public class AlgosMain {
    
    
    private static final Logger logger = Logger.getLogger((sm.algos.AlgosMain.class).getClass().getName());

    //private static final Logger log = 
    /**
     * Runs the array releated algorithms
     */
    private static void runArrayProblems(){
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -60, 54, 3};
        int[] arr2 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] arr3 = {31, -41, 59, 26 - 53, 58, 97, -93, -23, 84};
        int[] arr4 = {2, -3, 7, 0, 60, 5, -1};
        int[] arr5= {4,-3, 6, 9, 12, -22, 13, 27 -4 };
        
        logger.info("The current max sum is = " + com.sm.algos.ArrayProblems.kandane(arr5));

        logger.info("The current max sum is = " + com.sm.algos.ArrayProblems.kandane(arr5));
        logger.info("The current max sum is = " + com.sm.algos.ArrayProblems.bentleyMaxSum(arr, 0, 12));
        logger.info("Running the new method.");
        logger.info("Has a pair: " + com.sm.algos.ArrayProblems.subArraySumEqualsK2(arr4, 67));

        logger.info("Has a zero subarray: " + com.sm.algos.ArrayProblems.zeroSumSubArray(arr));
        
        int[] arr6 = {1, 4, 45, 6, 0, 19};
        logger.info("Min Subarray with sum greater than: + " + com.sm.algos.ArrayProblems.smallestSubArraySum(arr5, 51));
    }

    private static void runSelectionSort() {
        int[] val = {7,8,3,2,1,3,6};
        SelectionSort.sort(val);
        logger.info(Arrays.toString(val));
    }
    
    public static void main(String[] args) {
        //Run array problems
        AlgosMain.runArrayProblems();
        //Running selection sort
        logger.info("******************** Running selection sort *************");
        AlgosMain.runSelectionSort();
    }
    
}
