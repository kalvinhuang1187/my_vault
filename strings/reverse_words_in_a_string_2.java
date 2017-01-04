/*
    186. Reverse Words in a String II
    ---
    Question
    Given an input string, reverse the string word by word.
    A word is defined as a sequence of non-space characters.
    The input string does not contain leading or trailing spaces 
    and the words are always separated by a single space.

    For example, Given s = "the sky is blue", return "blue is sky the".
    Could you do it in-place without allocating extra space?
*/

import java.util.List;

public class reverse_string {
  // Idea: Reverse twice, both in place.
  // Time Complexity: O(n)
  // Space Complexity: O(1)

  public static char[] reverseWords(char[] str) {
    // reverse the whole string
    reverse(str, 0, str.length - 1);
    
    int start = 0;
    
    // reverse each word of the reversed string
    for (int i = 0; i < str.length; i++) {
      if (str[i] == ' ') {
        reverse(str, start, i-1);
        start = i + 1;
      }
    }
    
    // reverse the last word
    // if there is only 1 word, this will solve that corner case
    reverse(str, start, str.length - 1);
    
    return str;
  }
  
  public static void reverse(char[] s, int start, int end) {
    while(start < end) {
      char c = s[start];
      s[start] = s[end];
      s[end] = c;
      
      start++;
      end--;
    }
  }
  
  public static void main(String args[]) {
    char[] str1 = "dog".toCharArray();
    System.out.println(reverseWords(str1));    // output: "dog"
    
    char[] str2 = "dog park".toCharArray();
    System.out.println(reverseWords(str2));    // output: "park dog"
    
  }
}

