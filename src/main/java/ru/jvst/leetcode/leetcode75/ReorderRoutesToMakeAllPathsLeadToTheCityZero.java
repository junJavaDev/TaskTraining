package ru.jvst.leetcode.leetcode75;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/">1466. Reorder Routes to Make All Paths Lead to the City Zero</a>
 * <div class="xFUwe" data-track-load="description_content"><p>There are <code>n</code> cities numbered from <code>0</code> to <code>n - 1</code> and <code>n - 1</code> roads such that there is only one way to travel between two different cities (this network form a tree). Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.</p>
 *
 * <p>Roads are represented by <code>connections</code> where <code>connections[i] = [a<sub>i</sub>, b<sub>i</sub>]</code> represents a road from city <code>a<sub>i</sub></code> to city <code>b<sub>i</sub></code>.</p>
 *
 * <p>This year, there will be a big event in the capital (city <code>0</code>), and many people want to travel to this city.</p>
 *
 * <p>Your task consists of reorienting some roads such that each city can visit the city <code>0</code>. Return the <strong>minimum</strong> number of edges changed.</p>
 *
 * <p>It's <strong>guaranteed</strong> that each city can reach city <code>0</code> after reorder.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/05/13/sample_1_1819.png" style="width: 311px; height: 189px;">
 * <pre><strong>Input:</strong> n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
 * <strong>Output:</strong> 3
 * <strong>Explanation: </strong>Change the direction of edges show in red such that each node can reach the node 0 (capital).
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/05/13/sample_2_1819.png" style="width: 509px; height: 79px;">
 * <pre><strong>Input:</strong> n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
 * <strong>Output:</strong> 2
 * <strong>Explanation: </strong>Change the direction of edges show in red such that each node can reach the node 0 (capital).
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <pre><strong>Input:</strong> n = 3, connections = [[1,0],[2,0]]
 * <strong>Output:</strong> 0
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>2 &lt;= n &lt;= 5 * 10<sup>4</sup></code></li>
 * <li><code>connections.length == n - 1</code></li>
 * <li><code>connections[i].length == 2</code></li>
 * <li><code>0 &lt;= a<sub>i</sub>, b<sub>i</sub> &lt;= n - 1</code></li>
 * <li><code>a<sub>i</sub> != b<sub>i</sub></code></li>
 * </ul>
 * </div>
 **/

class ReorderRoutesToMakeAllPathsLeadToTheCityZero {
    public int minReorder(int n, int[][] connections) {
        List<int[]>[] graph = new ArrayList[n];
        for (int node = 0; node < n; node++) graph[node] = new ArrayList<>();
        for (int[] conn : connections) {
            graph[conn[0]].add(new int[]{conn[1], 1});
            graph[conn[1]].add(new int[]{conn[0], 0});
        }
        return bfs(graph);
    }

    private int bfs(List<int[]>[] graph) {
        boolean[] visited = new boolean[graph.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int reordered = 0;

        while (!queue.isEmpty()) {
            int city = queue.remove();
            if (!visited[city]) {
                visited[city] = true;
                List<int[]> neighbours = graph[city];
                for (int[] nbr : neighbours) {
                    if (!visited[nbr[0]]) {
                        queue.add(nbr[0]);
                        if (nbr[1] == 1) reordered++;
                    }
                }
            }
        }
        return reordered;
    }
}