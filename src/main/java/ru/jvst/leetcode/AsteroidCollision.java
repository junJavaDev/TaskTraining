package ru.jvst.leetcode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/asteroid-collision/">735. Asteroid Collision</a>
 * <div class="xFUwe" data-track-load="description_content"><p>We are given an array <code>asteroids</code> of integers representing asteroids in a row.</p>
 *
 * <p>For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.</p>
 *
 * <p>Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre><strong>Input:</strong> asteroids = [5,10,-5]
 * <strong>Output:</strong> [5,10]
 * <strong>Explanation:</strong> The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre><strong>Input:</strong> asteroids = [8,-8]
 * <strong>Output:</strong> []
 * <strong>Explanation:</strong> The 8 and -8 collide exploding each other.
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <pre><strong>Input:</strong> asteroids = [10,2,-5]
 * <strong>Output:</strong> [10]
 * <strong>Explanation:</strong> The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>2 &lt;= asteroids.length &lt;= 10<sup>4</sup></code></li>
 * <li><code>-1000 &lt;= asteroids[i] &lt;= 1000</code></li>
 * <li><code>asteroids[i] != 0</code></li>
 * </ul>
 * </div>
 **/

class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> armageddon = new LinkedList<>();
        for (int asteroid : asteroids) {
            if (armageddon.isEmpty() || asteroid > 0) {
                armageddon.add(asteroid);
            } else {
                move(armageddon, asteroid);
            }
        }
        return armageddon.stream().mapToInt(Integer::intValue).toArray();
    }

    private void move(LinkedList<Integer> armageddon, int asteroid) {
        if (armageddon.isEmpty() || armageddon.getLast() < 0) {
            armageddon.add(asteroid);
        } else {
            if (Math.abs(asteroid) > Math.abs(armageddon.getLast())) {
                armageddon.removeLast();
                move(armageddon, asteroid);
            } else if (Math.abs(asteroid) == Math.abs(armageddon.getLast())) {
                armageddon.removeLast();
            }
        }
    }
}