package ru.jvst.leetcode.leetcode75;

/**
 * <a href="https://leetcode.com/problems/delete-node-in-a-bst/">450. Delete Node in a BST</a>
 * <div class="xFUwe" data-track-load="description_content"><p>Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return <em>the <strong>root node reference</strong> (possibly updated) of the BST</em>.</p>
 *
 * <p>Basically, the deletion can be divided into two stages:</p>
 *
 * <ol>
 * <li>Search for a node to remove.</li>
 * <li>If the node is found, delete the node.</li>
 * </ol>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/09/04/del_node_1.jpg" style="width: 800px; height: 214px;">
 * <pre><strong>Input:</strong> root = [5,3,6,2,4,null,7], key = 3
 * <strong>Output:</strong> [5,4,6,2,null,null,7]
 * <strong>Explanation:</strong> Given key to delete is 3. So we find the node with value 3 and delete it.
 * One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
 * Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/09/04/del_node_supp.jpg" style="width: 350px; height: 255px;">
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre><strong>Input:</strong> root = [5,3,6,2,4,null,7], key = 0
 * <strong>Output:</strong> [5,3,6,2,4,null,7]
 * <strong>Explanation:</strong> The tree does not contain a node with value = 0.
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <pre><strong>Input:</strong> root = [], key = 0
 * <strong>Output:</strong> []
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li>The number of nodes in the tree is in the range <code>[0, 10<sup>4</sup>]</code>.</li>
 * <li><code>-10<sup>5</sup> &lt;= Node.val &lt;= 10<sup>5</sup></code></li>
 * <li>Each node has a <strong>unique</strong> value.</li>
 * <li><code>root</code> is a valid binary search tree.</li>
 * <li><code>-10<sup>5</sup> &lt;= key &lt;= 10<sup>5</sup></code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong>Follow up:</strong> Could you solve it with time complexity <code>O(height of tree)</code>?</p>
 * </div>
 **/
/*
Если root == null вернуть null;
Дальше, если ключ больше значения текущей ноды - идём рекурсивно направо,
если меньше - налево, если совпадает - разбираемся с текущей.
Если справа нет нод,- возвращаем левую, если слева нет - правую,
если есть и справа и слева, то в правой ноде ищем минимальное значение
и перезаписываем текущее значение на минимальное,
затем рекурсивно по правой ноде запускаем удаление ноды с найденным минимальным значением.
 */
class DeleteNodeInABst {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (key > root.val) root.right = deleteNode(root.right, key);
        else if (key < root.val) root.left = deleteNode(root.left, key);
        else {
            if (root.right == null) return root.left;
            else if (root.left == null) return root.right;
            else {
                root.val = foundMinVal(root.right);
                root.right = deleteNode(root.right, root.val);
            }
        }
        return root;
    }

    private int foundMinVal(TreeNode root) {
        while (root.left != null) root = root.left;
        return root.val;
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