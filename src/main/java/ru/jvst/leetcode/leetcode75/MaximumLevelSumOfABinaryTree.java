package ru.jvst.leetcode.leetcode75;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/">1161. Maximum Level Sum of a Binary Tree</a>
 * <div class="xFUwe" data-track-load="description_content"><p>Given the <code>root</code> of a binary tree, the level of its root is <code>1</code>, the level of its children is <code>2</code>, and so on.</p>
 *
 * <p>Return the <strong>smallest</strong> level <code>x</code> such that the sum of all the values of nodes at level <code>x</code> is <strong>maximal</strong>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2019/05/03/capture.JPG" style="width: 200px; height: 175px;">
 * <pre><strong>Input:</strong> root = [1,7,0,7,-8,null,null]
 * <strong>Output:</strong> 2
 * <strong>Explanation: </strong>
 * Level 1 sum = 1.
 * Level 2 sum = 7 + 0 = 7.
 * Level 3 sum = 7 + -8 = -1.
 * So we return the level with the maximum sum which is level 2.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre><strong>Input:</strong> root = [989,null,10250,98693,-89388,null,null,null,-32127]
 * <strong>Output:</strong> 2
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li>The number of nodes in the tree is in the range <code>[1, 10<sup>4</sup>]</code>.</li>
 * <li><code>-10<sup>5</sup> &lt;= Node.val &lt;= 10<sup>5</sup></code></li>
 * </ul>
 * </div>
 **/

// Два варианта решения.
// Первый - создание HashMap где ключ - уровень, значение - сумма. И рекурсивный обход дерева, с закидыванием
// в HashMap всех значений, суммируя их и передавая на уровень глубже переменную с уровнем.
// Второй вариант без рекурсии, закидывать все ветки в лист/очередь, сразу суммировать все элементы.

class MaximumLevelSumOfABinaryTree {
    public int maxLevelSum(TreeNode root) {
        Map<Integer, Integer> levels = new HashMap<>();
        dive(root, 1, levels);
        int maxSum = Integer.MIN_VALUE;
        int maxLevel = 1;
        for (Map.Entry<Integer, Integer> level : levels.entrySet()) {
            if (level.getValue() > maxSum) {
                maxSum = level.getValue();
                maxLevel = level.getKey();
            };
        }
        return maxLevel;
    }

    private void dive(TreeNode node, int level, Map<Integer, Integer> levels) {
        if (node == null) return;
        levels.put(level, levels.getOrDefault(level, 0) + node.val);

        dive(node.left, level + 1, levels);
        dive(node.right, level + 1, levels);
    }


//    public int maxLevelSum(TreeNode root) {
//        int maxSum = Integer.MIN_VALUE;
//        int maxLevel = 1;
//        int level = 1;
//        Queue<TreeNode> nodes = new LinkedList<>();
//        nodes.add(root);
//
//        while (!nodes.isEmpty()) {
//            int levelSum = 0;
//            int size = nodes.size();
//            for (int i = 0; i < size; i++) {
//                TreeNode node = nodes.remove();
//                levelSum += node.val;
//                if (node.left != null) nodes.add(node.left);
//                if (node.right != null) nodes.add(node.right);
//            }
//            if (levelSum > maxSum) {
//                maxSum = levelSum;
//                maxLevel = level;
//            }
//            level++;
//        }
//        return maxLevel;
//    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}