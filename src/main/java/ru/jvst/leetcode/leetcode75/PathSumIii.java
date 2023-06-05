package ru.jvst.leetcode.leetcode75;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/path-sum-iii/">437. Path Sum III</a>
 * <div class="xFUwe" data-track-load="description_content"><p>Given the <code>root</code> of a binary tree and an integer <code>targetSum</code>, return <em>the number of paths where the sum of the values&nbsp;along the path equals</em>&nbsp;<code>targetSum</code>.</p>
 *
 * <p>The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/04/09/pathsum3-1-tree.jpg" style="width: 450px; height: 386px;">
 * <pre><strong>Input:</strong> root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong> The paths that sum to 8 are shown.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre><strong>Input:</strong> root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * <strong>Output:</strong> 3
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li>The number of nodes in the tree is in the range <code>[0, 1000]</code>.</li>
 * <li><code>-10<sup>9</sup> &lt;= Node.val &lt;= 10<sup>9</sup></code></li>
 * <li><code>-1000 &lt;= targetSum &lt;= 1000</code></li>
 * </ul>
 * </div>
 **/

/** Создаем HashMap для хранения всех сумм до текущего узла, в которой
        ключ - сумма
        значение - количество таких сумм
    При обходе дерева sum - эта сумма всех предыдущих веток.
    Обновляем sum с учетом текущего значения.
        После этого проверяем нет ли в Map ключа (sum - targetSum).
        Это КЛЮЧЕВОЙ момент. Мы ищем не те самые ноды, которые составляют искомую сумму.
        Наоборот, мы от общей суммы вычитаем искомую. И ЕСЛИ такое число СУЩЕСТВУЕТ, значит существует и искомая комбинация.
    Дальше значение этого ключа прибавляем к искомым суммам.
    Прибавляем также вариант когда общая сумма с учетом этого числа и искомая сумма это одно и то же число.
    ТОЛЬКО ПОСЛЕ ЭТОГО заносим новую сумму в Map. Это нужно чтобы не словить ошибку, когда у нас искомая сумма - 0
    В таком случае при поиске ключа в Map (sum - targetSum) будет находиться фиктивная последовательность.
    Рекурсивно обходим ветки текущей ноды.
    После этого, возвращаясь, УМЕНЬШАЕМ значение по ключу текущей суммы в Map на 1, это нужно чтобы эти суммы
    не учитывались в других ветках.
**/

class PathSumIii {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> sums = new HashMap<>();
        return pathSum(root, sums, 0, targetSum);
    }

    private int pathSum(TreeNode node, Map<Long, Integer> sums, long sum, int targetSum) {
        if (node == null) return 0;
        sum += node.val;

        int targetSums = 0;

        if (sums.containsKey(sum - targetSum))
            targetSums += sums.get(sum - targetSum);
        if (sum == targetSum)
            targetSums++;

        sums.put(sum, sums.getOrDefault(sum, 0) + 1);

        targetSums += pathSum(node.left, sums, sum, targetSum);
        targetSums += pathSum(node.right, sums, sum, targetSum);

        sums.put(sum, sums.get(sum) - 1);
        return targetSums;
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