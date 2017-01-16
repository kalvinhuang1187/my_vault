/*
242. Valid Anagram
---
Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.
 */

public class ValidAnagram{
    public boolean isAnagram(String s, String t) {
        int[] alphabet = new int[128];
        
        for (int i = 0; i < s.length(); i++)
            alphabet[s.charAt(i)]++;
            
        for (int j = 0; j < t.length(); j++)
            alphabet[t.charAt(j)]--;
            
        for (int k : alphabet) {
            if (k != 0)
                return false;
        }
        
        return true;
    }
}

