package ru.jvst.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
<a href="https://leetcode.com/problems/dota2-senate/">649. Dota2 Senate</a>
<div class="xFUwe" data-track-load="description_content"><p>In the world of Dota2, there are two parties: the Radiant and the Dire.</p>

<p>The Dota2 senate consists of senators coming from two parties. Now the Senate wants to decide on a change in the Dota2 game. The voting for this change is a round-based procedure. In each round, each senator can exercise <strong>one</strong> of the two rights:</p>

<ul>
	<li><strong>Ban one senator's right:</strong> A senator can make another senator lose all his rights in this and all the following rounds.</li>
	<li><strong>Announce the victory:</strong> If this senator found the senators who still have rights to vote are all from the same party, he can announce the victory and decide on the change in the game.</li>
</ul>

<p>Given a string <code>senate</code> representing each senator's party belonging. The character <code>'R'</code> and <code>'D'</code> represent the Radiant party and the Dire party. Then if there are <code>n</code> senators, the size of the given string will be <code>n</code>.</p>

<p>The round-based procedure starts from the first senator to the last senator in the given order. This procedure will last until the end of voting. All the senators who have lost their rights will be skipped during the procedure.</p>

<p>Suppose every senator is smart enough and will play the best strategy for his own party. Predict which party will finally announce the victory and change the Dota2 game. The output should be <code>"Radiant"</code> or <code>"Dire"</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> senate = "RD"
<strong>Output:</strong> "Radiant"
<strong>Explanation:</strong> 
The first senator comes from Radiant and he can just ban the next senator's right in round 1. 
And the second senator can't exercise any rights anymore since his right has been banned. 
And in round 2, the first senator can just announce the victory since he is the only guy in the senate who can vote.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> senate = "RDD"
<strong>Output:</strong> "Dire"
<strong>Explanation:</strong> 
The first senator comes from Radiant and he can just ban the next senator's right in round 1. 
And the second senator can't exercise any rights anymore since his right has been banned. 
And the third senator comes from Dire and he can ban the first senator's right in round 1. 
And in round 2, the third senator can just announce the victory since he is the only guy in the senate who can vote.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == senate.length</code></li>
	<li><code>1 &lt;= n &lt;= 10<sup>4</sup></code></li>
	<li><code>senate[i]</code> is either <code>'R'</code> or <code>'D'</code>.</li>
</ul>
</div>
**/

class Dota2Senate {
	public String predictPartyVictory(String senate) {
		return vote(senate.getBytes(), 0);
	}

	private String vote(byte[] senators, int voiceBalance) {
		int radiant = 0;
		int dire = 0;
		for (int i = 0; i < senators.length; i++) {
			if (senators[i] == 'R') {
				if (voiceBalance >= 0) radiant++;
				else senators[i] = ' ';
				voiceBalance++;
			} else if (senators[i] == 'D') {
				if (voiceBalance <= 0) dire++;
				else senators[i] = ' ';
				voiceBalance--;
			}
		}
		if (radiant == 0) return "Dire";
		else if (dire == 0) return "Radiant";
		else return vote(senators, voiceBalance);
	}

	//Queue Solution
//	public String predictPartyVictory(String senate) {
//		Queue<Integer> r = new LinkedList<>();
//		Queue<Integer> d = new LinkedList<>();
//		byte[] senators = senate.getBytes();
//		for (int i = 0; i < senators.length; i++) {
//			if (senators[i] == 'R') r.add(i);
//			else d.add(i);
//		}
//		while (!r.isEmpty() && !d.isEmpty()) {
//			int rSenator = r.poll();
//			int dSenator = d.poll();
//			if (rSenator < dSenator) r.add(senate.length() + rSenator);
//			else d.add(senate.length() + dSenator);
//		}
//		return r.isEmpty() ? "Dire" : "Radiant";
//	}
}