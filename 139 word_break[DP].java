/*
139 Word Break[DP]
---
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:
The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.

Example 1:
  Input: s = "leetcode", wordDict = ["leet", "code"]
  Output: true
  Explanation: Return true because "leetcode" can be segmented as "leet code".

Example 2:
  Input: s = "applepenapple", wordDict = ["apple", "pen"]
  Output: true
  Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
               Note that you are allowed to reuse a dictionary word.
  
Example 3:
  Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
  Output: false

Example 4:
  Input: s = "catsdog", wordDict = ["cats", "dog", "sand", "and", "cat"]
  Output: true
*/

/*
Solution:
- DP array of size N+1
- 2 index pointers
  - i refers to the book end index of the substring
  - j refers to the partitioning of substring: s1(0,j) and s2(j+1,i)

Begin by initializing dp[0] = true, because null string is always present in the dictionary 
  rest of dp array is false
For every such substring, we partition the string into two substrings s1 and s2 using j pointer 
  i now refers to the ending index of s2
To fill dp[i], check if dp[j] contains true (meaning if s1 is valid substring) and
  s2 is present in the dictionary. If both are true, mark dp[i] as true, else remains false
*/

public static boolean wordBreak(String s, ArrayList<String> wordDict) {
  Set<String> wordDictSet = new HashSet<String>(wordDict);
  boolean[] dp = new boolean[s.length() + 1]; 
  dp[0] = true;

  for (int i = 1; i <= s.length(); i++) {
        for (int j = 0; j < i; j++) {
            if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                dp[i] = true;
                break;
            }
        }
    }
            
  return dp[s.length()];
}