package ru.junjavadev.leetcode;

import java.util.Arrays;

/**
 * <a href=https://leetcode.com/problems/max-number-of-k-sum-pairs/">1679. Max Number of K-Sum Pairs</a>
 * <p> You are given an integer array nums and an integer k.
 * <p> In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.
 * <p> Return the maximum number of operations you can perform on the array.
 * <blockquote><pre>
 * Example 1:
 * Input: nums = [1,2,3,4], k = 5
 * Output: 2
 * Explanation: Starting with nums = [1,2,3,4]:
 * - Remove numbers 1 and 4, then nums = [2,3]
 * - Remove numbers 2 and 3, then nums = []
 * There are no more pairs that sum up to 5, hence a total of 2 operations.
 * Example 2:
 * Input: nums = [3,1,3,4,3], k = 6
 * Output: 1
 * Explanation: Starting with nums = [3,1,3,4,3]:
 * - Remove the first two 3's, then nums = [1,4,3]
 * There are no more pairs that sum up to 6, hence a total of 1 operation.</pre>
 * <pre>
 * Constraints:
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 * 1 <= k <= 109</pre></blockquote>
 **/

class MaxNumberOfKSumPairs {
    public static void main(String[] args) {
    }
    public int maxOperations(int[] nums, int k) {
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);

        int pairs = 0, start = 0, end = sorted.length -1;

        while (start < end) {
            int pairSum = sorted[start] + sorted[end];
            if (pairSum > k) {
                end--;
            } else if (pairSum < k) {
                start++;
            } else {
                pairs++;
                start++;
                end--;
            }
        }
        return pairs;
    }
}