package ru.jvst.leetcode;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AsteroidCollisionTest {
    static AsteroidCollision checker;

    @BeforeAll
    static void setUp() {
        checker = new AsteroidCollision();
    }

    @Test
    void asteroidCollision() {
        assertArrayEquals(new int[]{5,10}, checker.asteroidCollision(new int[]{5,10,-5}));
    }
}