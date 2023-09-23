/*
You are given an array of integers 'ARR' of length 'N' and an integer Target. Your task is to return all pairs of elements such that they add up to Target. Note:

We cannot use the element at a given index twice.

Follow Up:

Try to do this problem in 0(N) time complexity.
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    static ArrayList<Pair<Integer, Integer>> twoSum(ArrayList<Integer> ARR, int Target, int N) {
        // Create a hashmap to store the frequency of elements
        Map<Integer, Integer> freqMap = new HashMap<>();
        ArrayList<Pair<Integer, Integer>> result = new ArrayList<>();

        // Populate the frequency map
        for (int num : ARR) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        for (int i = 0; i < N; i++) {
            int currentNum = ARR.get(i);
            int complement = Target - currentNum;

            // Check if the complement exists in the frequency map
            if (freqMap.containsKey(complement)) {
                // Handle the case when complement is equal to currentNum
                if (complement == currentNum) {
                    int freq = freqMap.get(complement);
                    if (freq >= 2) {
                        result.add(new Pair<>(complement, complement));
                        freqMap.put(complement, freq - 2);
                    }
                } else {
                    // Complement is different from currentNum
                    int freq1 = freqMap.get(complement);
                    int freq2 = freqMap.get(currentNum);
                    if (freq1 >= 1 && freq2 >= 1) {
                        result.add(new Pair<>(complement, currentNum));
                        freqMap.put(complement, freq1 - 1);
                        freqMap.put(currentNum, freq2 - 1);
                    }
                }
            }
        }

        if (result.isEmpty()) {
            // No valid pairs found
            result.add(new Pair<>(-1, -1));
        }

        return result;
    }
}
