package ru.jvst.leetcode;

/**
 <a href="https://leetcode.com/problems/reverse-vowels-of-a-string/">345. Reverse Vowels of a String</a>
 <div class="xFUwe" data-track-load="description_content"><p>Given a string <code>s</code>, reverse only all the vowels in the string and return it.</p>

 <p>The vowels are <code>'a'</code>, <code>'e'</code>, <code>'i'</code>, <code>'o'</code>, and <code>'u'</code>, and they can appear in both lower and upper cases, more than once.</p>

 <p>&nbsp;</p>
 <p><strong class="example">Example 1:</strong></p>
 <pre><strong>Input:</strong> s = "hello"
 <strong>Output:</strong> "holle"
 </pre><p><strong class="example">Example 2:</strong></p>
 <pre><strong>Input:</strong> s = "leetcode"
 <strong>Output:</strong> "leotcede"
 </pre>
 <p>&nbsp;</p>
 <p><strong>Constraints:</strong></p>

 <ul>
 <li><code>1 &lt;= s.length &lt;= 3 * 10<sup>5</sup></code></li>
 <li><code>s</code> consist of <strong>printable ASCII</strong> characters.</li>
 </ul>
 </div>
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
