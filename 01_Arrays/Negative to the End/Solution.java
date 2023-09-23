/*
 * You are given an array 'A' of size 'N' consisting of both negative and
 * positive integers. You need to return an array in which all the negative
 * numbers are at the end of the array, but the relative order of positive and
 * negative elements is the same. Example:
 * 
 * Input: 'N' = 6 'A' = [-1, 2, -3, 1, 13, -10]
 * 
 * Output: [2, 1, 13, -1, -3, 10]
 * 
 * Explanation: In the output array, all the negative elements come after
 * positive elements, and we can also see that the order of positive elements
 * and negative elements is the same, i.e., 2 comes before 1 and 13 in the final
 * array because in the array 'A', 2 comes before 1 and 13, and for all other
 * elements, this condition follows.
 * 
 * Platform: Coding Ninjas Code Studio.
 * 
 * Problem Link: https://www.codingninjas.com/studio/problems/negative-to-the-end_7088763?leftPanelTab=0
 */

import java.util.*;

public class Solution {
    public static int[] negativeToTheEnd(int[] v) {
        // Write Your Code Here
        int result[] = new int[v.length];
        int positiveArray[] = new int[v.length];
        int negativeArray[] = new int[v.length];
        int positiveIndex = 0;
        int negativeIndex = 0;

        for (int i = 0; i < v.length; i++) {
            if (v[i] >= 0) {
                positiveArray[positiveIndex] = v[i];
                positiveIndex++;
            } else {
                negativeArray[negativeIndex] = v[i];
                negativeIndex++;
            }
        }

        System.arraycopy(positiveArray, 0, result, 0, positiveIndex);
        System.arraycopy(negativeArray, 0, result, positiveIndex, negativeIndex);
        return result;
    }
}