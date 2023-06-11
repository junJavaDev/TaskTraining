package ru.jvst.leetcode.leetcode75;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/description/">1926. Nearest Exit from Entrance in Maze</a>
 * <div class="xFUwe" data-track-load="description_content"><p>You are given an <code>m x n</code> matrix <code>maze</code> (<strong>0-indexed</strong>) with empty cells (represented as <code>'.'</code>) and walls (represented as <code>'+'</code>). You are also given the <code>entrance</code> of the maze, where <code>entrance = [entrance<sub>row</sub>, entrance<sub>col</sub>]</code> denotes the row and column of the cell you are initially standing at.</p>
 *
 * <p>In one step, you can move one cell <strong>up</strong>, <strong>down</strong>, <strong>left</strong>, or <strong>right</strong>. You cannot step into a cell with a wall, and you cannot step outside the maze. Your goal is to find the <strong>nearest exit</strong> from the <code>entrance</code>. An <strong>exit</strong> is defined as an <strong>empty cell</strong> that is at the <strong>border</strong> of the <code>maze</code>. The <code>entrance</code> <strong>does not count</strong> as an exit.</p>
 *
 * <p>Return <em>the <strong>number of steps</strong> in the shortest path from the </em><code>entrance</code><em> to the nearest exit, or </em><code>-1</code><em> if no such path exists</em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/06/04/nearest1-grid.jpg" style="width: 333px; height: 253px;">
 * <pre><strong>Input:</strong> maze = [["+","+",".","+"],[".",".",".","+"],["+","+","+","."]], entrance = [1,2]
 * <strong>Output:</strong> 1
 * <strong>Explanation:</strong> There are 3 exits in this maze at [1,0], [0,2], and [2,3].
 * Initially, you are at the entrance cell [1,2].
 * - You can reach [1,0] by moving 2 steps left.
 * - You can reach [0,2] by moving 1 step up.
 * It is impossible to reach [2,3] from the entrance.
 * Thus, the nearest exit is [0,2], which is 1 step away.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/06/04/nearesr2-grid.jpg" style="width: 253px; height: 253px;">
 * <pre><strong>Input:</strong> maze = [["+","+","+"],[".",".","."],["+","+","+"]], entrance = [1,0]
 * <strong>Output:</strong> 2
 * <strong>Explanation:</strong> There is 1 exit in this maze at [1,2].
 * [1,0] does not count as an exit since it is the entrance cell.
 * Initially, you are at the entrance cell [1,0].
 * - You can reach [1,2] by moving 2 steps right.
 * Thus, the nearest exit is [1,2], which is 2 steps away.
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/06/04/nearest3-grid.jpg" style="width: 173px; height: 93px;">
 * <pre><strong>Input:</strong> maze = [[".","+"]], entrance = [0,0]
 * <strong>Output:</strong> -1
 * <strong>Explanation:</strong> There are no exits in this maze.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>maze.length == m</code></li>
 * <li><code>maze[i].length == n</code></li>
 * <li><code>1 &lt;= m, n &lt;= 100</code></li>
 * <li><code>maze[i][j]</code> is either <code>'.'</code> or <code>'+'</code>.</li>
 * <li><code>entrance.length == 2</code></li>
 * <li><code>0 &lt;= entrance<sub>row</sub> &lt; m</code></li>
 * <li><code>0 &lt;= entrance<sub>col</sub> &lt; n</code></li>
 * <li><code>entrance</code> will always be an empty cell.</li>
 * </ul>
 * </div>
 **/

class NearestExitFromEntranceInMaze {
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> moves = new LinkedList<>();
        moves.add(new int[]{entrance[1], entrance[0], 0});
        while (!moves.isEmpty()) {
            int[] move = moves.remove();
            int x = move[0];
            int y = move[1];
            int step = move[2];
            if (isExit(x, y, maze, entrance)) return step;
            move(x, y, maze, moves, step);
        }
        return -1;
    }

    private void move(int x, int y, char[][] maze, Queue<int[]> moves, int step) {
        addMove(x + 1, y, maze, moves, step);
        addMove(x - 1, y, maze, moves, step);
        addMove(x, y + 1, maze, moves, step);
        addMove(x, y - 1, maze, moves, step);
    }

    private void addMove(int x, int y, char[][] maze, Queue<int[]> moves, int step) {
        if (onField(x, y, maze) && maze[y][x] == '.') {
            maze[y][x] = '+';
            moves.add(new int[]{x, y, step + 1});
        }
    }

    private boolean onField(int x, int y, char[][] field) {
        return x >= 0 && x < field[0].length &&
                y >= 0 && y < field.length;
    }

    private boolean isExit(int x, int y, char[][] field, int[] start) {
        return (x == 0 || x == field[0].length - 1 ||
                y == 0 || y == field.length - 1) &&
                (x != start[1] || y != start[0]);
    }
}