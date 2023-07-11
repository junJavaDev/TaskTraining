package ru.jvst.leetcode.leetcode75;

import java.util.*;

/**
<a href="https://leetcode.com/problems/rotting-oranges/">994. Rotting Oranges</a>
<div class="elfjS" data-track-load="description_content"><p>You are given an <code>m x n</code> <code>grid</code> where each cell can have one of three values:</p>

<ul>
	<li><code>0</code> representing an empty cell,</li>
	<li><code>1</code> representing a fresh orange, or</li>
	<li><code>2</code> representing a rotten orange.</li>
</ul>

<p>Every minute, any fresh orange that is <strong>4-directionally adjacent</strong> to a rotten orange becomes rotten.</p>

<p>Return <em>the minimum number of minutes that must elapse until no cell has a fresh orange</em>. If <em>this is impossible, return</em> <code>-1</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2019/02/16/oranges.png" style="width: 650px; height: 137px;">
<pre><strong>Input:</strong> grid = [[2,1,1],[1,1,0],[0,1,1]]
<strong>Output:</strong> 4
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> grid = [[2,1,1],[0,1,1],[1,0,1]]
<strong>Output:</strong> -1
<strong>Explanation:</strong> The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> grid = [[0,2]]
<strong>Output:</strong> 0
<strong>Explanation:</strong> Since there are already no fresh oranges at minute 0, the answer is just 0.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m == grid.length</code></li>
	<li><code>n == grid[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 10</code></li>
	<li><code>grid[i][j]</code> is <code>0</code>, <code>1</code>, or <code>2</code>.</li>
</ul>
</div>
**/

/*
 * 1. Просканировать сетку для поиска гнилых апельсинов, сложить их в очередь
 * 2. Найти также свежие апельсины, сложить их в сет(?)
 * 3. Переменная счетчик ходов
 * 4. Запуск бесконечного цикла, пока после хода ни один апельсин не сгниет
 * 		или пока не останется свежих апельсинов
 * 5. Ход:
 * - От каждого гнилого апельсина идем в 4 стороны в пределах сетки
 * - Если попадается свежий апельсин, превращаем его в гнилой, добавляем в новую очередь и удаляем из сета
 * - Ход возвращяет новую очередь гнилых апельсинов
 * Если очередь пуста, проверяем есть ли в сете апельсины и выводим результат
 * если есть, вывод -1, если нет - вывод число
 */

class RottingOranges {
	public int orangesRotting(int[][] grid) {
		Set<Cell> freshOranges = new HashSet<>();
		Queue<Cell> rottenOranges = new ArrayDeque<>();

		int moves = 0;
		inspectGrid(grid, freshOranges, rottenOranges);

		while (!freshOranges.isEmpty() && !rottenOranges.isEmpty()) {
			move(rottenOranges, freshOranges);
			if (!rottenOranges.isEmpty()) moves++;
		}

		if (!freshOranges.isEmpty()) return -1;
		else return moves;
	}

	private void inspectGrid(int[][] grid, Set<Cell> freshOranges, Queue<Cell> rottenOranges) {
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[row].length; col++) {
				if (grid[row][col] == 1) freshOranges.add(new Cell(row, col));
				else if (grid[row][col] == 2) rottenOranges.add(new Cell(row, col));
			}
		}
	}

		private void move(Queue<Cell> rottenOranges, Set<Cell> freshOranges) {
		int size = rottenOranges.size();
		for (int i = 0; i < size; i++) {
			Cell rotten = rottenOranges.poll();
            assert rotten != null;
            int row = rotten.row;
			int col = rotten.col;
			moveTo(rotten, row, col - 1, freshOranges, rottenOranges);
			moveTo(rotten, row, col + 1, freshOranges, rottenOranges);
			moveTo(rotten, row - 1, col, freshOranges, rottenOranges);
			moveTo(rotten, row + 1, col, freshOranges, rottenOranges);
		};
	}

	private static void moveTo(Cell rotten, int row, int col, Set<Cell> freshOranges, Queue<Cell> rottenOranges) {
		rotten.update(row, col);
		if (freshOranges.remove(rotten)) rottenOranges.add(new Cell(row, col));
	}

	static class Cell{
		int row;
		int col;

		public Cell(int row, int col) {
			this.row = row;
			this.col = col;
		}

		public void update(int row, int col) {
			this.row = row;
			this.col = col;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Cell cell = (Cell) o;
			return row == cell.row && col == cell.col;
		}
		@Override
		public int hashCode() {
			return Objects.hash(row, col);
		}
	}
}