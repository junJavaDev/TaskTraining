package ru.jvst.leetcode.leetcode75;
import java.util.Arrays;

/**
 <a href="https://leetcode.com/problems/product-of-array-except-self/">238. Product of Array Except Self</a>
 <div class="xFUwe" data-track-load="description_content"><p>Given an integer array <code>nums</code>, return <em>an array</em> <code>answer</code> <em>such that</em> <code>answer[i]</code> <em>is equal to the product of all the elements of</em> <code>nums</code> <em>except</em> <code>nums[i]</code>.</p>

 <p>The product of any prefix or suffix of <code>nums</code> is <strong>guaranteed</strong> to fit in a <strong>32-bit</strong> integer.</p>

 <p>You must write an algorithm that runs in&nbsp;<code>O(n)</code>&nbsp;time and without using the division operation.</p>

 <p>&nbsp;</p>
 <p><strong class="example">Example 1:</strong></p>
 <pre><strong>Input:</strong> nums = [1,2,3,4]
 <strong>Output:</strong> [24,12,8,6]
 </pre><p><strong class="example">Example 2:</strong></p>
 <pre><strong>Input:</strong> nums = [-1,1,0,-3,3]
 <strong>Output:</strong> [0,0,9,0,0]
 </pre>
 <p>&nbsp;</p>
 <p><strong>Constraints:</strong></p>

 <ul>
 <li><code>2 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
 <li><code>-30 &lt;= nums[i] &lt;= 30</code></li>
 <li>The product of any prefix or suffix of <code>nums</code> is <strong>guaranteed</strong> to fit in a <strong>32-bit</strong> integer.</li>
 </ul>

 <p>&nbsp;</p>
 <p><strong>Follow up:</strong>&nbsp;Can you solve the problem in <code>O(1)</code>&nbsp;extra&nbsp;space complexity? (The output array <strong>does not</strong> count as extra space for space complexity analysis.)</p>
 </div>
 **/

///********** Short ***************/
class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, 1);
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        for (int i = nums.length - 2, suffix = 1; i >= 0; i--) {
            suffix *= nums[i+1];
            result[i] *= suffix;
        }
        return result;
    }
}

///********** Optimized ***************/
//class ProductOfArrayExceptSelf {
//    public static void main(String[] args) {
//        ProductOfArrayExceptSelf poars = new ProductOfArrayExceptSelf();
//        System.out.println(Arrays.toString(poars.productExceptSelf(new int[]{9, 0, -2})));
//    }
//    public int[] productExceptSelf(int[] nums) {
//        int[] result = new int[nums.length];
//        result[0] = 1;
//        for (int i = 1; i < nums.length; i++) {
//            int num = nums[i - 1];
//            if (num == 0) {
//                Arrays.fill(result, 0, i-1, 0);
//                for (int j = i; j < nums.length; j++) {
//                    result [i - 1] *= nums[j];
//                }
//                return result;
//            }
//            result[i] = result[i - 1] * num;
//        }
//        for (int i = nums.length - 2, suffix = 1; i >= 0; i--) {
//            suffix *= nums[i+1];
//            result[i] *= suffix;
//        }
//        return result;
//    }
//}