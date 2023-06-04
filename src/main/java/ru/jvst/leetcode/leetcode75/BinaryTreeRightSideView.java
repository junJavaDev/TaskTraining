package ru.jvst.leetcode.leetcode75;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/binary-tree-right-side-view/">199. Binary Tree Right Side View</a>
 * <div class="xFUwe" data-track-load="description_content"><p>Given the <code>root</code> of a binary tree, imagine yourself standing on the <strong>right side</strong> of it, return <em>the values of the nodes you can see ordered from top to bottom</em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/02/14/tree.jpg" style="width: 401px; height: 301px;">
 * <pre><strong>Input:</strong> root = [1,2,3,null,5,null,4]
 * <strong>Output:</strong> [1,3,4]
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre><strong>Input:</strong> root = [1,null,3]
 * <strong>Output:</strong> [1,3]
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <pre><strong>Input:</strong> root = []
 * <strong>Output:</strong> []
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li>The number of nodes in the tree is in the range <code>[0, 100]</code>.</li>
 * <li><code>-100 &lt;= Node.val &lt;= 100</code></li>
 * </ul>
 * </div>
 **/

class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        return new ArrayList<Integer>() {{dive(root, 0, this);}};
    }

    private void dive(TreeNode node, int depth, List<Integer> view) {
        if (node == null) return;
        if (depth == view.size()) view.add(node.val);

        dive(node.right, depth+1, view);
        dive(node.left, depth+1, view);
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