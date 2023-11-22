package ru.junjavadev.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/find-the-difference-of-two-arrays/">2215. Find the Difference of Two Arrays</a>
 <div class="xFUwe" data-track-load="description_content"><p>Given two <strong>0-indexed</strong> integer arrays <code>nums1</code> and <code>nums2</code>, return <em>a list</em> <code>answer</code> <em>of size</em> <code>2</code> <em>where:</em></p>

 <ul>
 <li><code>answer[0]</code> <em>is a list of all <strong>distinct</strong> integers in</em> <code>nums1</code> <em>which are <strong>not</strong> present in</em> <code>nums2</code><em>.</em></li>
 <li><code>answer[1]</code> <em>is a list of all <strong>distinct</strong> integers in</em> <code>nums2</code> <em>which are <strong>not</strong> present in</em> <code>nums1</code>.</li>
 </ul>

 <p><strong>Note</strong> that the integers in the lists may be returned in <strong>any</strong> order.</p>

 <p>&nbsp;</p>
 <p><strong class="example">Example 1:</strong></p>

 <pre><strong>Input:</strong> nums1 = [1,2,3], nums2 = [2,4,6]
 <strong>Output:</strong> [[1,3],[4,6]]
 <strong>Explanation:
 </strong>For nums1, nums1[1] = 2 is present at index 0 of nums2, whereas nums1[0] = 1 and nums1[2] = 3 are not present in nums2. Therefore, answer[0] = [1,3].
 For nums2, nums2[0] = 2 is present at index 1 of nums1, whereas nums2[1] = 4 and nums2[2] = 6 are not present in nums2. Therefore, answer[1] = [4,6].</pre>

 <p><strong class="example">Example 2:</strong></p>

 <pre><strong>Input:</strong> nums1 = [1,2,3,3], nums2 = [1,1,2,2]
 <strong>Output:</strong> [[3],[]]
 <strong>Explanation:
 </strong>For nums1, nums1[2] and nums1[3] are not present in nums2. Since nums1[2] == nums1[3], their value is only included once and answer[0] = [3].
 Every integer in nums2 is present in nums1. Therefore, answer[1] = [].
 </pre>

 <p>&nbsp;</p>
 <p><strong>Constraints:</strong></p>

 <ul>
 <li><code>1 &lt;= nums1.length, nums2.length &lt;= 1000</code></li>
 <li><code>-1000 &lt;= nums1[i], nums2[i] &lt;= 1000</code></li>
 </ul>
 </div>
 **/

class FindTheDifferenceOfTwoArrays {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> distNums1 = new HashSet<>();
        HashSet<Integer> distNums2 = new HashSet<>();
        for (int num : nums1) {
            distNums1.add(num);
        }
        for (int num : nums2) {
            distNums2.add(num);
        }
        List<Integer> answer1 = new ArrayList<>();
        List<Integer> answer2 = new ArrayList<>();

        for (int num : distNums1) {
            if (!distNums2.contains(num)) {
                answer1.add(num);
            }
        }

        for (int num : distNums2) {
            if (!distNums1.contains(num)) {
                answer2.add(num);
            }
        }

        return List.of(answer1, answer2);
    }
}
