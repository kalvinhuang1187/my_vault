/*
3. Longest Substring Without Repeating Characters
---
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

public class Solution {
    /*
    The idea is use a hash set to track the longest substring without repeating characters so far.
    Use a fast pointer i to see if character i is in the hash set or not, if not, great, 
    add it to the hash set, move i forward and update the max length, otherwise, 
    delete from the head by using a slow pointer j until we can put character i to the hash set.
    */
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        
        int i = 0;
        int j = 0;
        int max = 0;
        
        while (i < s.length()) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                max = Math.max(max, set.size());
                i++;
            }
            else {
                set.remove(s.charAt(j));
                j++;
            }
        }
        
        return max;
    }
}

