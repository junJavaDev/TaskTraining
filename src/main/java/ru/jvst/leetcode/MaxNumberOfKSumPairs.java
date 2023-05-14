package ru.jvst.leetcode;

import java.util.Arrays;

/**
 <a href="https://leetcode.com/problems/max-number-of-k-sum-pairs/">1679. Max Number of K-Sum Pairs</a>
 <div class="xFUwe" data-track-load="description_content"><p>You are given an integer array <code>nums</code> and an integer <code>k</code>.</p>

 <p>In one operation, you can pick two numbers from the array whose sum equals <code>k</code> and remove them from the array.</p>

 <p>Return <em>the maximum number of operations you can perform on the array</em>.</p>

 <p>&nbsp;</p>
 <p><strong class="example">Example 1:</strong></p>

 <pre><strong>Input:</strong> nums = [1,2,3,4], k = 5
 <strong>Output:</strong> 2
 <strong>Explanation:</strong> Starting with nums = [1,2,3,4]:
 - Remove numbers 1 and 4, then nums = [2,3]
 - Remove numbers 2 and 3, then nums = []
 There are no more pairs that sum up to 5, hence a total of 2 operations.</pre>

 <p><strong class="example">Example 2:</strong></p>

 <pre><strong>Input:</strong> nums = [3,1,3,4,3], k = 6
 <strong>Output:</strong> 1
 <strong>Explanation:</strong> Starting with nums = [3,1,3,4,3]:
 - Remove the first two 3's, then nums = [1,4,3]
 There are no more pairs that sum up to 6, hence a total of 1 operation.</pre>

 <p>&nbsp;</p>
 <p><strong>Constraints:</strong></p>

 <ul>
 <li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
 <li><code>1 &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
 <li><code>1 &lt;= k &lt;= 10<sup>9</sup></code></li>
 </ul>
 </div>
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