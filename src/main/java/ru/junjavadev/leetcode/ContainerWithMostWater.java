package ru.junjavadev.leetcode;

/**
 * <a href="https://leetcode.com/problems/container-with-most-water/">11. Container With Most Water</a>
 * <p> You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * <p> Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * <p> Return the maximum amount of water a container can store.
 * <p> Notice that you may not slant the container.
 * <blockquote><pre>
 * Example 1:
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 * Example 2:
 * Input: height = [1,1]
 * Output: 1
 * <pre>
 * Constraints:
 * n == height.length
 * 2 <= n <= 105
 * 0 <= height[i] <= 104</pre>
 **/

class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxArea = 0, width = height.length - 1, left = 0, right = width;
        while (left < right) {
            if (height[left] < height[right]) {
                maxArea = Math.max(height[left] * width, maxArea);
                left++;
            } else {
                maxArea = Math.max(height[right] * width, maxArea);
                right--;
            }
            width--;
        }
        return maxArea;
    }
}