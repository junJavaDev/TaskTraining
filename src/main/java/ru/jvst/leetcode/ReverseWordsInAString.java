package ru.jvst.leetcode;

/**
 <a href="https://leetcode.com/problems/reverse-vowels-of-a-string/">345. Reverse Vowels of a String</a>
 <p> Given an input string s, reverse the order of the words.
 <p> A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
 <p> Return a string of the words in reverse order concatenated by a single space.
 <p> Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.
 <blockquote><pre>
 Example 1:
 Input: s = "the sky is blue"
 Output: "blue is sky the"</pre>
 <pre>
 Example 2:
 Input: s = "  hello world  "
 Output: "world hello"
 Explanation: Your reversed string should not contain leading or trailing spaces.</pre>
 <pre>
 Example 3:
 Input: s = "a good   example"
 Output: "example good a"
 Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.</pre>
 <pre>
 Constraints:
 1 <= s.length <= 104
 s contains English letters (upper-case and lower-case), digits, and spaces ' '.
 There is at least one word in s.</pre></blockquote>

 <p> Follow-up: If the string data type is mutable in your language, can you solve it in-place with O(1) extra space?
 **/

public class ReverseWordsInAString {
    public String reverseWords(String s) {
        String[] words = s.split("\\s+");
        StringBuilder result = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            result.append(" ");
        }
        return result.toString().trim();
    }
}
