package ru.junjavadev.leetcode;

/**
 * <a href="https://leetcode.com/problems/is-subsequence/">392. Is Subsequence</a>
 * <p> Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 * <p> A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 * <blockquote><pre>
 * Example 1:
 * Input: s = "abc", t = "ahbgdc"
 * Output: true
 * Example 2:
 * Input: s = "axc", t = "ahbgdc"
 * Output: false
 * <pre>
 * Constraints:
 * 0 <= s.length <= 100
 * 0 <= t.length <= 104
 * s and t consist only of lowercase English letters.</pre></blockquote>
 * <p> Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 109, and you want to check one by one to see if t has its subsequence. In this scenario, how would you change your code?
 * loop
 **/

class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) return true;
        int sI = 0;
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == s.charAt(sI)) {
                if (sI == s.length() - 1) return true;
                sI++;
            }

        }
        return false;
    }
}