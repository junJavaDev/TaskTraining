package ru.jvst.leetcode.leetcode75;

/**
 * <a href="https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/">236. Lowest Common Ancestor of a Binary Tree</a>
 * <div class="xFUwe" data-track-load="description_content"><p>Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.</p>
 *
 * <p>According to the <a href="https://en.wikipedia.org/wiki/Lowest_common_ancestor" target="_blank">definition of LCA on Wikipedia</a>: “The lowest common ancestor is defined between two nodes <code>p</code> and <code>q</code> as the lowest node in <code>T</code> that has both <code>p</code> and <code>q</code> as descendants (where we allow <b>a node to be a descendant of itself</b>).”</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2018/12/14/binarytree.png" style="width: 200px; height: 190px;">
 * <pre><strong>Input:</strong> root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong> The LCA of nodes 5 and 1 is 3.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2018/12/14/binarytree.png" style="width: 200px; height: 190px;">
 * <pre><strong>Input:</strong> root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * <strong>Output:</strong> 5
 * <strong>Explanation:</strong> The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <pre><strong>Input:</strong> root = [1,2], p = 1, q = 2
 * <strong>Output:</strong> 1
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li>The number of nodes in the tree is in the range <code>[2, 10<sup>5</sup>]</code>.</li>
 * <li><code>-10<sup>9</sup> &lt;= Node.val &lt;= 10<sup>9</sup></code></li>
 * <li>All <code>Node.val</code> are <strong>unique</strong>.</li>
 * <li><code>p != q</code></li>
 * <li><code>p</code> and <code>q</code> will exist in the tree.</li>
 * </ul>
 * </div>
 **/

class LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Если узел root является пустым (null), то возвращается null.
        // Это базовый случай для рекурсивного алгоритма.
        if (root == null) return null;
        // Если узел root совпадает с узлом p или узлом q, то возвращается root.
        // Это проверка на случай, если один из искомых узлов p или q является предком другого.
        if (root.equals(p) || root.equals(q)) return root;
        // Рекурсивный вызов функции lowestCommonAncestor для левого поддерева.
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // Рекурсивный вызов функции lowestCommonAncestor для правого поддерева.
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // Если как результаты для левого и правого поддеревьев возвращаются непустые узлы (не null),
        // то это означает, что узлы p и q находятся в разных поддеревьях,
        // и узел root служит для них общим предком (lowest common ancestor).
        if (left != null && right != null) return root;
        // Если предыдущий условный оператор (if) не выполнился,
        // это означает, что узлы p и q находятся в одном поддереве.
        // В этом случае возвращается результат, который не равен null.
        // Если left равен null, то возвращается right, и наоборот.
        return left == null ? right : left;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}