package ru.jvst.leetcode.leetcode75;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.jvst.leetcode.leetcode75.AsteroidCollision;

import static org.junit.jupiter.api.Assertions.*;

class AsteroidCollisionTest {
    AsteroidCollision checker;

    @BeforeEach
    void setUp() {
        checker = new AsteroidCollision();
    }

    @Test
    void asteroidCollision() {
        assertArrayEquals(new int[]{5,10}, checker.asteroidCollision(new int[]{5,10,-5}));
        assertArrayEquals(new int[]{}, checker.asteroidCollision(new int[]{8,-8}));
        assertArrayEquals(new int[]{10}, checker.asteroidCollision(new int[]{10,2,-5}));
    }
}