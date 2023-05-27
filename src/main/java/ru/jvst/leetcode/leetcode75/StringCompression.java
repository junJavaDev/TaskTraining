package ru.jvst.leetcode.leetcode75;

/**
 <a href="https://leetcode.com/problems/string-compression/">443. String Compression</a>
 <p> Given an array of characters chars, compress it using the following algorithm:
 <p> Begin with an empty string s. For each group of consecutive repeating characters in chars:
 <ul>
    <li>If the group's length is 1, append the character to s.</li>
    <li>Otherwise, append the character followed by the group's length.</li>
 </ul>
 <p> The compressed string s should not be returned separately, but instead, be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.
 <p> After you are done modifying the input array, return the new length of the array.
 <p> You must write an algorithm that uses only constant extra space.
 <hr><blockquote><pre>
 Example 1:
 Input: chars = ["a","a","b","b","c","c","c"]
 Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
 Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".</pre>
 <pre>
 Example 2:
 Input: chars = ["a"]
 Output: Return 1, and the first character of the input array should be: ["a"]
 Explanation: The only group is "a", which remains uncompressed since it's a single character.</pre>
 <pre>
 Example 3:
 Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
 Output: Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
 Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".</pre>
 <hr><pre>
 Constraints:
 1 <= chars.length <= 2000
 chars[i] is a lowercase English letter, uppercase English letter, digit, or symbol./pre></blockquote>
 **/

class StringCompression {
    public static void main(String[] args) {
        StringCompression stringCompression = new StringCompression();
        System.out.println(stringCompression.compress(new char[] {'a','a','b','b','c','c','c'}));
    }
    public int compress(char[] chars) {
        int repeatQuantity = 0;
        int size = 1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[size-1] == chars[i]) {
                repeatQuantity++;
            } else {
                size += writeQuantity(size, repeatQuantity, chars);
                chars[size] = chars[i];
                size++;
                repeatQuantity = 1;
            }
        }
        size += writeQuantity(size, repeatQuantity, chars);
        return size;
    }

    private int writeQuantity(int size, int quantity, char[] chars) {
        if (quantity > 1) {
            char[] src = String.valueOf(quantity).toCharArray();
            System.arraycopy(src, 0, chars, size, src.length);
            return src.length;
        }
        return 0;
    }
}