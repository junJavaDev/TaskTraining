package ru.jvst.leetcode;

/**
 <a href="https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/">1456. Maximum Number of Vowels in a Substring of Given Length</a>
 <div class="xFUwe" data-track-load="description_content"><p>Given a string <code>s</code> and an integer <code>k</code>, return <em>the maximum number of vowel letters in any substring of </em><code>s</code><em> with length </em><code>k</code>.</p>

 <p><strong>Vowel letters</strong> in English are <code>'a'</code>, <code>'e'</code>, <code>'i'</code>, <code>'o'</code>, and <code>'u'</code>.</p>

 <p>&nbsp;</p>
 <p><strong class="example">Example 1:</strong></p>

 <pre><strong>Input:</strong> s = "abciiidef", k = 3
 <strong>Output:</strong> 3
 <strong>Explanation:</strong> The substring "iii" contains 3 vowel letters.
 </pre>

 <p><strong class="example">Example 2:</strong></p>

 <pre><strong>Input:</strong> s = "aeiou", k = 2
 <strong>Output:</strong> 2
 <strong>Explanation:</strong> Any substring of length 2 contains 2 vowels.
 </pre>

 <p><strong class="example">Example 3:</strong></p>

 <pre><strong>Input:</strong> s = "leetcode", k = 3
 <strong>Output:</strong> 2
 <strong>Explanation:</strong> "lee", "eet" and "ode" contain 2 vowels.
 </pre>

 <p>&nbsp;</p>
 <p><strong>Constraints:</strong></p>

 <ul>
 <li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
 <li><code>s</code> consists of lowercase English letters.</li>
 <li><code>1 &lt;= k &lt;= s.length</code></li>
 </ul>
 </div>
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
