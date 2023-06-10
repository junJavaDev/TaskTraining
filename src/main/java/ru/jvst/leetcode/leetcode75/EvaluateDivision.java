package ru.jvst.leetcode.leetcode75;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/evaluate-division/">399. Evaluate Division</a>
 * <div class="xFUwe" data-track-load="description_content"><p>You are given an array of variable pairs <code>equations</code> and an array of real numbers <code>values</code>, where <code>equations[i] = [A<sub>i</sub>, B<sub>i</sub>]</code> and <code>values[i]</code> represent the equation <code>A<sub>i</sub> / B<sub>i</sub> = values[i]</code>. Each <code>A<sub>i</sub></code> or <code>B<sub>i</sub></code> is a string that represents a single variable.</p>
 *
 * <p>You are also given some <code>queries</code>, where <code>queries[j] = [C<sub>j</sub>, D<sub>j</sub>]</code> represents the <code>j<sup>th</sup></code> query where you must find the answer for <code>C<sub>j</sub> / D<sub>j</sub> = ?</code>.</p>
 *
 * <p>Return <em>the answers to all queries</em>. If a single answer cannot be determined, return <code>-1.0</code>.</p>
 *
 * <p><strong>Note:</strong> The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.</p>
 *
 * <p><strong>Note:&nbsp;</strong>The variables that do not occur in the list of equations are undefined, so the answer cannot be determined for them.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre><strong>Input:</strong> equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * <strong>Output:</strong> [6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * <strong>Explanation:</strong>
 * Given: <em>a / b = 2.0</em>, <em>b / c = 3.0</em>
 * queries are: <em>a / c = ?</em>, <em>b / a = ?</em>, <em>a / e = ?</em>, <em>a / a = ?</em>, <em>x / x = ? </em>
 * return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
 * note: x is undefined =&gt; -1.0</pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre><strong>Input:</strong> equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
 * <strong>Output:</strong> [3.75000,0.40000,5.00000,0.20000]
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <pre><strong>Input:</strong> equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
 * <strong>Output:</strong> [0.50000,2.00000,-1.00000,-1.00000]
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= equations.length &lt;= 20</code></li>
 * <li><code>equations[i].length == 2</code></li>
 * <li><code>1 &lt;= A<sub>i</sub>.length, B<sub>i</sub>.length &lt;= 5</code></li>
 * <li><code>values.length == equations.length</code></li>
 * <li><code>0.0 &lt; values[i] &lt;= 20.0</code></li>
 * <li><code>1 &lt;= queries.length &lt;= 20</code></li>
 * <li><code>queries[i].length == 2</code></li>
 * <li><code>1 &lt;= C<sub>j</sub>.length, D<sub>j</sub>.length &lt;= 5</code></li>
 * <li><code>A<sub>i</sub>, B<sub>i</sub>, C<sub>j</sub>, D<sub>j</sub></code> consist of lower case English letters and digits.</li>
 * </ul>
 * </div>
 **/

class EvaluateDivision {
	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		Map<String, Map<String, Double>> graph = new HashMap<>();
		// Заполнение графа выражений, в обе стороны.
		for (int i = 0; i < equations.size(); i++) {
			List<String> equation = equations.get(i);
			String dividend = equation.get(0);
			String divisor = equation.get(1);
			double quotient = values[i];
			graph.putIfAbsent(dividend, new HashMap<>());
			graph.putIfAbsent(divisor, new HashMap<>());
			// Добавляем коэффициент в направлении dividend-divisor
			graph.get(dividend).put(divisor, quotient);
			// Добавляем коэффициент в направлении divisor-dividend
			graph.get(divisor).put(dividend, 1 / quotient);
		}

		double[] answers = new double[queries.size()];
		Set<String> visited = new HashSet<>();
		// Проход по всем запросам
		for (int i = 0; i < queries.size(); i++) {
			List<String> query = queries.get(i);
			String dividend = query.get(0);
			String divisor = query.get(1);
			visited.clear();
			if (graph.containsKey(dividend) && graph.containsKey(divisor)) {
				answers[i] = calculateDivision(1, dividend, divisor, visited, graph);
			} else answers[i] = -1.0;
		}
		return answers;
	}

	private double calculateDivision(double multiplicand, String dividend, String divisor, Set<String> visited, Map<String, Map<String, Double>> graph) {
		if (!visited.contains(dividend)) {
			visited.add(dividend);
			Map<String, Double> nodes = graph.get(dividend);
			if (nodes.containsKey(divisor)) {
				return multiplicand * nodes.get(divisor);
			} else {
				for (String node : nodes.keySet()) {
					double result = calculateDivision(multiplicand * nodes.get(node), node, divisor, visited, graph);
					if (result != -1.0) return result;
				}
			}
		}
		return -1.0;
	}
}