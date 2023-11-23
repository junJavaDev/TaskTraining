package ru.jvst.leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/move-zeroes/">283. Move Zeroes</a>
 * <p> Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p> Note that you must do this in-place without making a copy of the array.
 * <blockquote><pre>
 * Example 1:
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [0]</pre>
 * <pre>
 * Constraints:
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1</pre></blockquote>
 * <p> Follow up: Could you minimize the total number of operations done?
 **/

class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int zeroPos = moveNonZeroesToStart(nums);
        Arrays.fill(nums, zeroPos, nums.length, 0);
    }

    private int moveNonZeroesToStart(int[] nums) {
        int zeroPos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) nums[zeroPos++] = nums[i];
        }
        return zeroPos;
    }
}