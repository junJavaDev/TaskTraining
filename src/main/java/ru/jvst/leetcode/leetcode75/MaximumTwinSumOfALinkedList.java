package ru.jvst.leetcode.leetcode75;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/">2130. Maximum Twin Sum of a Linked List</a>
 * <div class="xFUwe" data-track-load="description_content"><p>In a linked list of size <code>n</code>, where <code>n</code> is <strong>even</strong>, the <code>i<sup>th</sup></code> node (<strong>0-indexed</strong>) of the linked list is known as the <strong>twin</strong> of the <code>(n-1-i)<sup>th</sup></code> node, if <code>0 &lt;= i &lt;= (n / 2) - 1</code>.</p>
 *
 * <ul>
 * <li>For example, if <code>n = 4</code>, then node <code>0</code> is the twin of node <code>3</code>, and node <code>1</code> is the twin of node <code>2</code>. These are the only nodes with twins for <code>n = 4</code>.</li>
 * </ul>
 *
 * <p>The <strong>twin sum </strong>is defined as the sum of a node and its twin.</p>
 *
 * <p>Given the <code>head</code> of a linked list with even length, return <em>the <strong>maximum twin sum</strong> of the linked list</em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/12/03/eg1drawio.png" style="width: 250px; height: 70px;">
 * <pre><strong>Input:</strong> head = [5,4,2,1]
 * <strong>Output:</strong> 6
 * <strong>Explanation:</strong>
 * Nodes 0 and 1 are the twins of nodes 3 and 2, respectively. All have twin sum = 6.
 * There are no other nodes with twins in the linked list.
 * Thus, the maximum twin sum of the linked list is 6.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/12/03/eg2drawio.png" style="width: 250px; height: 70px;">
 * <pre><strong>Input:</strong> head = [4,2,2,3]
 * <strong>Output:</strong> 7
 * <strong>Explanation:</strong>
 * The nodes with twins present in this linked list are:
 * - Node 0 is the twin of node 3 having a twin sum of 4 + 3 = 7.
 * - Node 1 is the twin of node 2 having a twin sum of 2 + 2 = 4.
 * Thus, the maximum twin sum of the linked list is max(7, 4) = 7.
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/12/03/eg3drawio.png" style="width: 200px; height: 88px;">
 * <pre><strong>Input:</strong> head = [1,100000]
 * <strong>Output:</strong> 100001
 * <strong>Explanation:</strong>
 * There is only one node with a twin in the linked list having twin sum of 1 + 100000 = 100001.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li>The number of nodes in the list is an <strong>even</strong> integer in the range <code>[2, 10<sup>5</sup>]</code>.</li>
 * <li><code>1 &lt;= Node.val &lt;= 10<sup>5</sup></code></li>
 * </ul>
 * </div>
 **/

class MaximumTwinSumOfALinkedList {

    // EASY way
//    public int pairSum(ListNode head) {
//        List<Integer> list = new ArrayList<>();
//        while (head != null) {
//            list.add(head.val);
//            head = head.next;
//        }
//
//        int max = Integer.MIN_VALUE;
//        for (int i = 0, j = list.size()-1; i < j ; i++, j--) {
//            max = Math.max(max, list.get(i) + list.get(j));
//        }
//
//        return max;
//    }

    // FAST way

    public int pairSum(ListNode head) {
        ListNode middle = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            middle = middle.next;
            fast = fast.next.next;
        }

        ListNode twin = reverse(middle);
        int max = Integer.MIN_VALUE;
        while (twin != null) {
            max = Math.max(max, head.val + twin.val);
            head = head.next;
            twin = twin.next;
        }
        return max;
    }

    private ListNode reverse(ListNode head) {
        if (head.next == null) return head;

        ListNode previous = null;
        ListNode next = head.next;

        while (next != null) {
            next = head.next;
            head.next = previous;
            previous = head;
            head = next;
        }
        return previous;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}