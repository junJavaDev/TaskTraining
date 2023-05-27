package ru.jvst.leetcode.leetcode75;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.jvst.leetcode.leetcode75.DecodeString;

import static org.junit.jupiter.api.Assertions.*;

class DecodeStringTest {

    DecodeString checker;

    @BeforeEach
    void setUp() {
        checker = new DecodeString();
    }

    @Test
    void decodeString() {
        assertEquals("aaaaaaaaaabcbc", checker.decodeString("10[a]2[bc]"));
        assertEquals("accaccacc", checker.decodeString("3[a2[c]]"));
        assertEquals("abcabccdcdcdef", checker.decodeString("2[abc]3[cd]ef"));
        assertEquals("leetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcode", checker.decodeString("100[leetcode]"));
    }
}