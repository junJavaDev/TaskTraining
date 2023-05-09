package ru.jvst.leetcode;

/**
 * <a href="https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/">1493. Longest Subarray of 1's After Deleting One Element</a>
 * <p> Given a binary array nums, you should delete one element from it.
 * <p> Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.</p>
 * <blockquote><pre>
 *     Example 1:
 *     Input: nums = [1,1,0,1]
 *     Output: 3
 *     Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.</pre>
 * <pre>
 *     Example 2:
 *     Input: nums = [0,1,1,1,0,1,1,0,1]
 *     Output: 5
 *     Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].</pre>
 * <pre>
 *     Example 3:
 *     Input: nums = [1,1,1]
 *     Output: 2
 *     Explanation: You must delete one element.</pre>
 * <pre>
 *     Constraints:
 *     1 <= nums.length <= 10^5
 *     nums[i] is either 0 or 1.</pre></blockquote>
 **/

class LongestSubarrayOfOnesAfterDeletingOneElement {
    public int longestSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        int lastZeroIdx = -1;
        int result = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                left = lastZeroIdx + 1;
                lastZeroIdx = right;
            }
            result = Math.max(result, right - left);
            right++;
        }
        return result;
    }
}
