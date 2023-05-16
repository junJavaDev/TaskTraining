package ru.jvst.leetcode;

import java.util.Arrays;

/**
 <a href="https://leetcode.com/problems/move-zeroes/">283. Move Zeroes</a>
 <div class="xFUwe" data-track-load="description_content"><p>Given an integer array <code>nums</code>, move all <code>0</code>'s to the end of it while maintaining the relative order of the non-zero elements.</p>

 <p><strong>Note</strong> that you must do this in-place without making a copy of the array.</p>

 <p>&nbsp;</p>
 <p><strong class="example">Example 1:</strong></p>
 <pre><strong>Input:</strong> nums = [0,1,0,3,12]
 <strong>Output:</strong> [1,3,12,0,0]
 </pre><p><strong class="example">Example 2:</strong></p>
 <pre><strong>Input:</strong> nums = [0]
 <strong>Output:</strong> [0]
 </pre>
 <p>&nbsp;</p>
 <p><strong>Constraints:</strong></p>

 <ul>
 <li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
 <li><code>-2<sup>31</sup> &lt;= nums[i] &lt;= 2<sup>31</sup> - 1</code></li>
 </ul>

 <p>&nbsp;</p>
 <strong>Follow up:</strong> Could you minimize the total number of operations done?</div>
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