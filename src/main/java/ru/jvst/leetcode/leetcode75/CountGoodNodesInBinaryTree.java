package ru.jvst.leetcode.leetcode75;

/**
 * <a href="https://leetcode.com/problems/count-good-nodes-in-binary-tree/">1448. Count Good Nodes in Binary Tree</a>
 * <div class="xFUwe" data-track-load="description_content"><p>Given a binary tree <code>root</code>, a node <em>X</em> in the tree is named&nbsp;<strong>good</strong> if in the path from root to <em>X</em> there are no nodes with a value <em>greater than</em> X.</p>
 *
 * <p>Return the number of <strong>good</strong> nodes in the binary tree.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <p><strong><img alt="" src="https://assets.leetcode.com/uploads/2020/04/02/test_sample_1.png" style="width: 263px; height: 156px;"></strong></p>
 *
 * <pre><strong>Input:</strong> root = [3,1,4,3,null,1,5]
 * <strong>Output:</strong> 4
 * <strong>Explanation:</strong> Nodes in blue are <strong>good</strong>.
 * Root Node (3) is always a good node.
 * Node 4 -&gt; (3,4) is the maximum value in the path starting from the root.
 * Node 5 -&gt; (3,4,5) is the maximum value in the path
 * Node 3 -&gt; (3,1,3) is the maximum value in the path.</pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <p><strong><img alt="" src="https://assets.leetcode.com/uploads/2020/04/02/test_sample_2.png" style="width: 157px; height: 161px;"></strong></p>
 *
 * <pre><strong>Input:</strong> root = [3,3,null,4,2]
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong> Node 2 -&gt; (3, 3, 2) is not good, because "3" is higher than it.</pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <pre><strong>Input:</strong> root = [1]
 * <strong>Output:</strong> 1
 * <strong>Explanation:</strong> Root is considered as <strong>good</strong>.</pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li>The number of nodes in the binary tree is in the range&nbsp;<code>[1, 10^5]</code>.</li>
 * <li>Each node's value is between <code>[-10^4, 10^4]</code>.</li>
 * </ul></div>
 **/

class CountGoodNodesInBinaryTree {
    public int goodNodes(TreeNode root) {
        return countGoods(root, root.val);
    }

    private int countGoods(TreeNode node, int max) {
        int goods = 0;
        if (node.val >= max) {
            goods = 1;
            max = node.val;
        }
        if (node.left != null) goods += countGoods(node.left, max);
        if (node.right != null) goods += countGoods(node.right, max);
        return goods;
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