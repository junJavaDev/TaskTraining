package ru.jvst.leetcode;

/**
 * <a href="https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/">1456. Maximum Number of Vowels in a Substring of Given Length</a>
 * <p> Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
 * <p> Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
 * <blockquote><pre>
 * Example 1:
 * Input: s = "abciiidef", k = 3
 * Output: 3
 * Explanation: The substring "iii" contains 3 vowel letters.
 * Example 2:
 * Input: s = "aeiou", k = 2
 * Output: 2
 * Explanation: Any substring of length 2 contains 2 vowels.
 * Example 3:
 * Input: s = "leetcode", k = 3
 * Output: 2
 * Explanation: "lee", "eet" and "ode" contain 2 vowels.
 * <pre>
 * Constraints:
 * 1 <= s.length <= 105
 * s consists of lowercase English letters.
 * 1 <= k <= s.length</pre></blockquote>
 **/

class MaximumNumberOfVowelsInASubstringOfGivenLength {
    public int maxVowels(String s, int k) {
        int maxVowels = 0;
        char[] sChars = s.toCharArray();
        for (int i = 0; i < k; i++) {
            if (isVowel(sChars[i]))
                maxVowels++;
        }
        int count = maxVowels;
        for (int i = k; i < sChars.length; i++) {
            if (isVowel(sChars[i - k]))
                count--;
            if (isVowel(sChars[i]))
                count++;
            maxVowels = Math.max(count, maxVowels);
        }
        return maxVowels;
    }

    public static boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
