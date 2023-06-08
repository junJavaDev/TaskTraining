package ru.jvst.leetcode.leetcode75;

/**
<a href="https://leetcode.com/problems/number-of-provinces/">547. Number of Provinces</a>
<div class="xFUwe" data-track-load="description_content"><p>There are <code>n</code> cities. Some of them are connected, while some are not. If city <code>a</code> is connected directly with city <code>b</code>, and city <code>b</code> is connected directly with city <code>c</code>, then city <code>a</code> is connected indirectly with city <code>c</code>.</p>

<p>A <strong>province</strong> is a group of directly or indirectly connected cities and no other cities outside of the group.</p>

<p>You are given an <code>n x n</code> matrix <code>isConnected</code> where <code>isConnected[i][j] = 1</code> if the <code>i<sup>th</sup></code> city and the <code>j<sup>th</sup></code> city are directly connected, and <code>isConnected[i][j] = 0</code> otherwise.</p>

<p>Return <em>the total number of <strong>provinces</strong></em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/12/24/graph1.jpg" style="width: 222px; height: 142px;">
<pre><strong>Input:</strong> isConnected = [[1,1,0],[1,1,0],[0,0,1]]
<strong>Output:</strong> 2
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/12/24/graph2.jpg" style="width: 222px; height: 142px;">
<pre><strong>Input:</strong> isConnected = [[1,0,0],[0,1,0],[0,0,1]]
<strong>Output:</strong> 3
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 200</code></li>
	<li><code>n == isConnected.length</code></li>
	<li><code>n == isConnected[i].length</code></li>
	<li><code>isConnected[i][j]</code> is <code>1</code> or <code>0</code>.</li>
	<li><code>isConnected[i][i] == 1</code></li>
	<li><code>isConnected[i][j] == isConnected[j][i]</code></li>
</ul>
</div>
**/

class NumberOfProvinces {
	// Основной метод для нахождения количества провинций
	public int findCircleNum(int[][] isConnected) {
		boolean[] visited = new boolean[isConnected.length]; // Массив для отслеживания посещенных вершин
		int provinces = 0; // Переменная для подсчета провинций
		for(int i = 0; i < isConnected.length; i++) { // Итерация по вершинам
			if (!visited[i]) { // Если вершина не посещена
				provinces++; // Увеличиваем количество провинций
				dfs(i, visited, isConnected); // Вызываем функцию поиска в глубину для данной вершины
			}
		}
		return provinces; // Возвращаем количество провинций
	}

	// Метод для обхода в глубину
	private void dfs(int i, boolean[] visited, int[][] isConnected) {
		visited[i] = true; // Помечаем вершину как посещенную
		for(int j = 0; j < isConnected.length; j++) { // Итерация по вершинам
			if (j != i && !visited[j] && isConnected[i][j] == 1) { // Если вершина не посещена и связана с текущей вершиной
				dfs(j, visited, isConnected); // Рекурсивный вызов для данной вершины
			}
		}
	}
}