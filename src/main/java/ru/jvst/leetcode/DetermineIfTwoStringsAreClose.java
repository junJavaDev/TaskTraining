package ru.jvst.leetcode;

import java.util.*;

/**
<a href="https://leetcode.com/problems/determine-if-two-strings-are-close/">1657. Determine if Two Strings Are Close</a>
<div class="xFUwe" data-track-load="description_content"><p>Two strings are considered <strong>close</strong> if you can attain one from the other using the following operations:</p>

<ul>
	<li>Operation 1: Swap any two <strong>existing</strong> characters.

	<ul>
		<li>For example, <code>a<u>b</u>cd<u>e</u> -&gt; a<u>e</u>cd<u>b</u></code></li>
	</ul>
	</li>
	<li>Operation 2: Transform <strong>every</strong> occurrence of one <strong>existing</strong> character into another <strong>existing</strong> character, and do the same with the other character.
	<ul>
		<li>For example, <code><u>aa</u>c<u>abb</u> -&gt; <u>bb</u>c<u>baa</u></code> (all <code>a</code>'s turn into <code>b</code>'s, and all <code>b</code>'s turn into <code>a</code>'s)</li>
	</ul>
	</li>
</ul>

<p>You can use the operations on either string as many times as necessary.</p>

<p>Given two strings, <code>word1</code> and <code>word2</code>, return <code>true</code><em> if </em><code>word1</code><em> and </em><code>word2</code><em> are <strong>close</strong>, and </em><code>false</code><em> otherwise.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> word1 = "abc", word2 = "bca"
<strong>Output:</strong> true
<strong>Explanation:</strong> You can attain word2 from word1 in 2 operations.
Apply Operation 1: "a<u>bc</u>" -&gt; "a<u>cb</u>"
Apply Operation 1: "<u>a</u>c<u>b</u>" -&gt; "<u>b</u>c<u>a</u>"
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> word1 = "a", word2 = "aa"
<strong>Output:</strong> false
<strong>Explanation: </strong>It is impossible to attain word2 from word1, or vice versa, in any number of operations.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> word1 = "cabbba", word2 = "abbccc"
<strong>Output:</strong> true
<strong>Explanation:</strong> You can attain word2 from word1 in 3 operations.
Apply Operation 1: "ca<u>b</u>bb<u>a</u>" -&gt; "ca<u>a</u>bb<u>b</u>"
<code>Apply Operation 2: "</code><u>c</u>aa<u>bbb</u>" -&gt; "<u>b</u>aa<u>ccc</u>"
Apply Operation 2: "<u>baa</u>ccc" -&gt; "<u>abb</u>ccc"
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= word1.length, word2.length &lt;= 10<sup>5</sup></code></li>
	<li><code>word1</code> and <code>word2</code> contain only lowercase English letters.</li>
</ul>
</div>
**/

class DetermineIfTwoStringsAreClose {

	/**
	The task can be formulated with two conditions:
	1. The unique characters in both Strings must be the same, regardless of the number of repetitions
	2. The number of occurrences of characters must be the same, regardless of which characters exactly how many

	 {26} - the number of letters in the alphabet
	 {freq} - the number of characters in a string
	 {bytesW1[i] - 'a'} - alphabet character in byte format 0-25
	 {freqW1[i] == 0 ^ freqW2[i] == 0} - if the number of characters in any word is zero, and the second one is not zero, then one of the words has no letter
	**/
	 public boolean closeStrings(String word1, String word2) {
		if (word1.length() != word2.length()) return false;

		int[] freqW1 = new int[26];
		int[] freqW2 = new int[26];

		byte[] bytesW1 = word1.getBytes();
		byte[] bytesW2 = word2.getBytes();

		for (int i = 0; i < bytesW1.length; i++) {
			freqW1[bytesW1[i] - 'a']++;
			freqW2[bytesW2[i] - 'a']++;
		}

		for (int i = 0; i < 26; i++) {
			if (freqW1[i] == 0 ^ freqW2[i] == 0)
				return false;
		}

		Arrays.sort(freqW1);
		Arrays.sort(freqW2);
		return Arrays.equals(freqW1, freqW2);
	}


	public boolean closeStrings2(String word1, String word2) {
		if (word1.length() != word2.length()) return false;
		var charsWord1 = new HashMap<Character, Integer>();
		var charsWord2 = new HashMap<Character, Integer>();
		for (int i = 0; i < word1.length(); i++) {
			charsWord1.put(word1.charAt(i), charsWord1.getOrDefault(word1.charAt(i), 0) + 1);
			charsWord2.put(word2.charAt(i), charsWord2.getOrDefault(word2.charAt(i), 0) + 1);
		}
		var charsValues1 = new ArrayList<>(charsWord1.values());
		var charsValues2 = new ArrayList<>(charsWord2.values());
		Collections.sort(charsValues1);
		Collections.sort(charsValues2);

		return charsWord1.keySet().equals(charsWord2.keySet()) &&
				charsValues1.equals(charsValues2);
	}
}