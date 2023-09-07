package ru.junjavadev.leetcode;
import java.util.Arrays;

/**
<a href="https://leetcode.com/problems/product-of-array-except-self/">238. Product of Array Except Self</a>
 <p> Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 <p> You must write an algorithm that runs in O(n) time and without using the division operation.
<blockquote><pre>
 Example 1:
 Input: nums = [1,2,3,4]
 Output: [24,12,8,6]</pre>
 <pre>
 Example 2:
 Input: nums = [-1,1,0,-3,3]
 Output: [0,0,9,0,0]</pre>
 <pre>
 Constraints:
 2 <= nums.length <= 105
 -30 <= nums[i] <= 30</pre></blockquote>
 <p> The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
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