package ru.jvst.leetcode.leetcode75;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/decode-string/">394. Decode String</a>
 * <div class="xFUwe" data-track-load="description_content"><p>Given an encoded string, return its decoded string.</p>
 *
 * <p>The encoding rule is: <code>k[encoded_string]</code>, where the <code>encoded_string</code> inside the square brackets is being repeated exactly <code>k</code> times. Note that <code>k</code> is guaranteed to be a positive integer.</p>
 *
 * <p>You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, <code>k</code>. For example, there will not be input like <code>3a</code> or <code>2[4]</code>.</p>
 *
 * <p>The test cases are generated so that the length of the output will never exceed <code>10<sup>5</sup></code>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre><strong>Input:</strong> s = "3[a]2[bc]"
 * <strong>Output:</strong> "aaabcbc"
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre><strong>Input:</strong> s = "3[a2[c]]"
 * <strong>Output:</strong> "accaccacc"
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <pre><strong>Input:</strong> s = "2[abc]3[cd]ef"
 * <strong>Output:</strong> "abcabccdcdcdef"
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= s.length &lt;= 30</code></li>
 * <li><code>s</code> consists of lowercase English letters, digits, and square brackets <code>'[]'</code>.</li>
 * <li><code>s</code> is guaranteed to be <strong>a valid</strong> input.</li>
 * <li>All the integers in <code>s</code> are in the range <code>[1, 300]</code>.</li>
 * </ul>
 * </div>
 **/

class DecodeString {
//    public String decodeString(String s) {
//        StringBuilder decoded = new StringBuilder();
//        int idx = 0;
//        while (idx < s.length()) {
//            idx += decodeChar(s, decoded, idx);
//        }
//        return decoded.toString();
//    }
//
//    private int decodeChar(String s, StringBuilder decoded, int idx) {
//        char c = s.charAt(idx);
//        int offset = 1;
//        if (Character.isAlphabetic(c)) {
//            decoded.append(c);
//        } else if (Character.isDigit(c)) {
//            offset += multiple(s, decoded, idx);
//        }
//        return offset;
//    }
//
//    private int multiple(String s, StringBuilder decoded, int idx) {
//
//        int lastNumIdx = idx;
//        while (s.charAt(lastNumIdx) != '[') lastNumIdx++;
//        int multiplier = Integer.parseInt(s.substring(idx, lastNumIdx));
//
//        int lastI = 0;
//        while (multiplier > 0) {
//            lastI = lastNumIdx;
//            while (s.charAt(lastI) != ']') {
//                lastI += decodeChar(s, decoded, lastI);
//            }
//            multiplier--;
//        }
//        return lastI - idx;
//    }

    public String decodeString(String s) {
        Deque<String> parts = new ArrayDeque<>();
        Deque<Integer> nums = new ArrayDeque<>();
        StringBuilder decoded = new StringBuilder();
        StringBuilder recurring = new StringBuilder();
        int num = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else {
                switch (c) {
                    case '[' : {
                        nums.push(num);
                        num = 0;
                        parts.push(decoded.toString());
                        decoded.setLength(0);
                        break;
                    }
                    case ']' : {
                        recurring.append(parts.pop());
                        recurring.append(decoded.toString().repeat(nums.pop()));
                        decoded.setLength(0);
                        decoded.append(recurring);
                        recurring.setLength(0);
                        break;
                    }
                    default:
                        decoded.append(c);
                }
            }
        }
        return decoded.toString();
    }





















//    public String decodeString(String s) {
//        Deque<Integer> numbers = new ArrayDeque<>();
//        Deque<String> parts = new ArrayDeque<>();
//        StringBuilder word = new StringBuilder();
//
//        int num = 0;
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (Character.isDigit(c)) { // construct a number
//                num = num * 10 + (c - '0');
//            } else if (c == '[') {
//                numbers.push(num);
//                num = 0;
//                parts.push(word.toString()); // save previously constructed part to stack
//                word.setLength(0); // clear the word
//            } else if (c == ']') {
//                // take a previous part, and we will append constructed word with repetitions to it
//                StringBuilder wholePart = new StringBuilder(parts.pop());
//                int repeat = numbers.pop();
//                for (int j = 0; j < repeat; j++) {
//                    wholePart.append(word);
//                }
//                word = wholePart;
//            } else {
//                word.append(c);
//            }
//        }
//        return word.toString();
//    }
}


































