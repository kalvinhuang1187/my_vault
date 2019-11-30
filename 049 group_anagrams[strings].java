/*
49. Group Anagrams
---
Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note: All inputs will be in lower-case.
 */

public class Anagram{
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        
        if (strs == null || strs.length == 0)
            return result;
            
        HashMap<String, List<String>> hm = new HashMap<String, List<String>>();
        for (String s : strs) {
            char[] c_array = s.toCharArray();
            Arrays.sort(c_array);
            
            String new_string = new String(c_array);
            
            if (hm.containsKey(new_string)) {
                hm.get(new_string).add(s);
            }
            else {
                ArrayList<String> al = new ArrayList<String>();
                al.add(s);
                hm.put(new_string, al);
            }
        }
        result.addAll(hm.values());
        
        return result;
    }
}

