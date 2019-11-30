/*
    438. Find All Anagrams in a String
    ---
    Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

    Strings consists of lowercase English letters only and the length of both strings s and p
    will not be larger than 20,100.

    The order of output does not matter.
    ---
    Example 1:

    Input:
    s: "cbaebabacd" p: "abc"

    Output:
    [0, 6]

    Explanation:
    The substring with start index = 0 is "cba", which is an anagram of "abc".
    The substring with start index = 6 is "bac", which is an anagram of "abc".

    ---
    Example 2:

    Input:
    s: "abab" p: "ab"

    Output:
    [0, 1, 2]

    Explanation:
    The substring with start index = 0 is "ab", which is an anagram of "ab".
    The substring with start index = 1 is "ba", which is an anagram of "ab".
    The substring with start index = 2 is "ab", which is an anagram of "ab".
 */

import java.util.*;

public class findAnagram {
    // Time Complexity: O(n)

    // Sliding window solution to finding anagram
    public static List<Integer> findAllAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<Integer>();
        
        if(s == null || p == null || s.length() == 0 || p.length() == 0) {
            return res;
        }
        
        int len1 = s.length();
        int len2 = p.length();
        
        if(len2 > len1)
        	return res;
        
        int[] anagram = new int[128];

        /* 
         * compare the 2 strings. If char only appears in str1, anagram array will be set to 1
         * If char only appears in str2, anagram array will set that position to -1.
         * If char appears in both, the +/- will negate and be 0.
         * ex: str1="abc" str2="abc"=> all char are the same: [0 0 0 0 ...] 
         * ex: str1="ab" str2="ad"  => 'b' appears in str1 (+1), 'c' appears in str2 (-1): [0 1 0 -1 ...]
        */
        for(int i = 0; i < len2; i++) {
            anagram[s.charAt(i)]++;
            anagram[p.charAt(i)]--;
        }
        
        int diff = 0;
        for(int i : anagram) {
        	//System.out.print(i);	for debugging and seeing anagram char array
            if(i != 0) diff++;
        }

        //System.out.println("diff: " + diff);	//for debugging and seeing diff count
        
        /*
         * Same idea as above with the +1/-1
         * If diff = 0, str1 has an anagram of str2 and chars match
         * Always have a rolling window of str2.length
         */
        for(int i = len2; i < len1; i++) {
            if(diff == 0) res.add(i - len2);	// add anagram position
            
            char c1 = s.charAt(i);
            char c2 = s.charAt(i - len2);
            
            if(c1 == c2) continue;	// if new char in rolling window matches, skip this iteration
            
            anagram[c1]++;  //new char hasn't been seen before (+1)
            anagram[c2]--;  //remove oldest char from rolling window (-1)
            if(anagram[c1] == 1) diff++;      //new char appeared, 2 str are even further apart (more diffs)
            else if(anagram[c1] == 0) diff--; //new char is one from str2 anagram, getting closer (less diff)
            
            /* for debugging to see anagram char array
            for(int j : anagram) {
            	System.out.print(j);
            }
            */
            
            if(anagram[c2] == -1) diff++;     //oldest char was one from str2, further apart now (more diffs)
            else if(anagram[c2] == 0) diff--; //oldest char wasn't originally from str2, when it first came
                                              //  in, it got a +1, but it is leaving window now so we are   
                                              //  getting closer with 1 less mismatch (less diff)
            
            //System.out.println("diff:" + diff);	//for debugging and seeing diff count
        }
        
        if(diff == 0) {
            res.add(len1 - len2);
        }
        return res;
    }
	
    public static void main(String args[]) {
        String s1 = "1badefbacg";
        String s2 = "abc";
        List<Integer> output = findAllAnagrams(s1, s2);
		
        System.out.print(output);
    }
}
