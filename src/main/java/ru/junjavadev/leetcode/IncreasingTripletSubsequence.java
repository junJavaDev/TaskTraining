package ru.junjavadev.leetcode;

/**
<a href="https://leetcode.com/problems/increasing-triplet-subsequence/">334. Increasing Triplet Subsequence</a>
 <p> Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.

 <blockquote><pre>
 Example 1:
 Input: nums = [1,2,3,4,5]
 Output: true
 Explanation: Any triplet where i < j < k is valid.</pre>
 <pre>
 Example 2:
 Input: nums = [5,4,3,2,1]
 Output: false
 Explanation: No triplet exists.</pre>
 <pre>
 Input: nums = [2,1,5,0,4,6]
 Output: true
 Explanation: The triplet (3, 4, 5) is valid because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.</pre>
 <pre>
 Constraints:
 1 <= nums.length <= 5 * 105
 -231 <= nums[i] <= 231 - 1</pre></blockquote>
 <p> Follow up: Could you implement a solution that runs in O(n) time complexity and O(1) space complexity?
 **/

class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE;
        int middle = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num < min) {
                min = num;
            } else if (num < middle && num > min) {
                middle = num;
            } else if (num > middle) {
                return true;
            }
        }
        return false;
    }
}