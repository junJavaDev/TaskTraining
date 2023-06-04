package ru.jvst.leetcode.leetcode75;

/**
 * <a href="https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/">1372. Longest ZigZag Path in a Binary Tree</a>
 * <div class="xFUwe" data-track-load="description_content"><p>You are given the <code>root</code> of a binary tree.</p>
 *
 * <p>A ZigZag path for a binary tree is defined as follow:</p>
 *
 * <ul>
 * <li>Choose <strong>any </strong>node in the binary tree and a direction (right or left).</li>
 * <li>If the current direction is right, move to the right child of the current node; otherwise, move to the left child.</li>
 * <li>Change the direction from right to left or from left to right.</li>
 * <li>Repeat the second and third steps until you can't move in the tree.</li>
 * </ul>
 *
 * <p>Zigzag length is defined as the number of nodes visited - 1. (A single node has a length of 0).</p>
 *
 * <p>Return <em>the longest <strong>ZigZag</strong> path contained in that tree</em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/01/22/sample_1_1702.png" style="width: 221px; height: 383px;">
 * <pre><strong>Input:</strong> root = [1,null,1,1,1,null,null,1,1,null,1,null,null,null,1]
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong> Longest ZigZag path in blue nodes (right -&gt; left -&gt; right).
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/01/22/sample_2_1702.png" style="width: 157px; height: 329px;">
 * <pre><strong>Input:</strong> root = [1,1,1,null,1,null,null,1,1,null,1]
 * <strong>Output:</strong> 4
 * <strong>Explanation:</strong> Longest ZigZag path in blue nodes (left -&gt; right -&gt; left -&gt; right).
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <pre><strong>Input:</strong> root = [1]
 * <strong>Output:</strong> 0
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li>The number of nodes in the tree is in the range <code>[1, 5 * 10<sup>4</sup>]</code>.</li>
 * <li><code>1 &lt;= Node.val &lt;= 100</code></li>
 * </ul>
 * </div>
 **/

class LongestZigzagPathInABinaryTree {
    public int longestZigZag(TreeNode root) {
        return Math.max(
                checkZigZag('L', root.left, 0),
                checkZigZag('R', root.right, 0)
        );
    }

    private int checkZigZag(char direction, TreeNode node, int length) {
        if (node == null) return length;
        if (direction == 'R') {
            return Math.max(
                    checkZigZag('L', node.left, length + 1),
                    checkZigZag('R', node.right, 0)
            );
        } else {
            return Math.max(
                    checkZigZag('R', node.right, length + 1),
                    checkZigZag('L', node.left, 0)
            );
        }
    }


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