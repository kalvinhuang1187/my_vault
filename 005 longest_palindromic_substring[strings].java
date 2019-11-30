/*
5. Longest Palindromic Substring
---
Given a string s, find the longest palindromic substring in s.
You may assume that the maximum length of s is 1000.

Example 1:
Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Example 2:
Input: "cbbd"
Output: "bb"

Example 3:
Input: "abbad"
Output: "abba"
*/

/* 
Solution: Expand Around Center
A palindrome mirrors around its center. Therefore, a palindrome can be expanded from its center

ex: "abbad"
1st Pass:
ODD:
  i, j = 0; str = a
  inside "extend" for loop: s.charAt(i) = a
                            s.charAt(j) = a
  return s.substring(i + 1, j) [0,1]    = a
  max = "a"
EVEN:
  i = 0; j(i+1) = 1; str = ab
  inside "extend" for loop: s.charAt(i) = a
                            s.charAt(j) = b
  break

2nd Pass:
ODD:
  i, j = 1; str = b
  inside extend for loop: s.charAt(i) = b
                          s.charAt(j) = b
  inside extend for loop: s.charAt(i) = a (i = 0, 2 char around index 1, i--)
                          s.charAt(j) = b (j = 2, 2 char around index 1, j++)
  return s.substring(i + 1, j) [1,2]  = b
EVEN:
  i = 1; j(i+1) = 2; str = bb
  inside "extend" for loop: s.charAt(i) = b
                            s.charAt(j) = b
  inside "extend" for loop: s.charAt(i) = a (i = 0, char around index 1, i--)
                            s.charAt(j) = a (i = 3, char around index 2, j++)
  return s.substring(i + 1, j) [1,2]  = b
  max = "abba"

3nd Pass:
ODD:
  i, j = 2; str = b
  inside extend for loop: s.charAt(i) = b
                          s.charAt(j) = b
  inside extend for loop: s.charAt(i) = b (i = 1, 2 char around index 2, i--)
                          s.charAt(j) = a (j = 3, 2 char around index 2, j++)
  return s.substring(i + 1, j) [2,3]  = b
EVEN:
  i = 2; j(i+1) = 3; str = ba
  inside "extend" for loop: s.charAt(i) = b
                            s.charAt(j) = a
  break
  
4nd Pass:
ODD:
  i, j = 3; str = a
  inside extend for loop: s.charAt(i) = a
                          s.charAt(j) = a
  inside extend for loop: s.charAt(i) = b (i = 2, 2 char around index 2, i--)
                          s.charAt(j) = d (j = 4, 2 char around index 2, j++)
  return s.substring(i + 1, j) [3,4]  = a
EVEN:
  i = 3; j(i+1) = 4; str = ad
  inside "extend" for loop: s.charAt(i) = a
                            s.charAt(j) = d
  break

5nd Pass:
ODD:
  i, j = 4; str = d
  inside extend for loop: s.charAt(i) = d
                          s.charAt(j) = d
  return s.substring(i + 1, j) [4,5]  = d
EVEN:
  i = 4; j(i+1) = 5; str = d_
  inside "extend" for loop: s.charAt(i) = d
                            s.charAt(j) = d
  return s.substring(i + 1, j) [5,5]    = _


Final Solution (max): "abba"
*/

public static String longestPalindrome(String s) {
  String max = "";
  
  for (int i = 0; i < s.length(); i++) {
      String odd_palin = extend(s, i, i);
      String even_pain = extend(s, i, i + 1);
      
      if (odd_palin.length() > max.length())
        max = odd_palin;
      if (even_pain.length() > max.length())
        max = even_pain;
  }
  
  return max;
}

private static String extend(String s, int i, int j) {
  for ( ; 0 <= i && j < s.length(); i--, j++) { 
    if (s.charAt(i) != s.charAt(j))
      break;
  }
  
  return s.substring(i + 1, j);
}