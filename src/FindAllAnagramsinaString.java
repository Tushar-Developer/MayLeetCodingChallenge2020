/*

Find All Anagrams in a String
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
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


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsinaString {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s == null || s.length() == 0 || s.length() < p.length()) {
            return ans;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // The number of distinct characters
        int counter = map.size();
        for (int left = 0, right = 0; right < s.length(); right++) {
            char cRight = s.charAt(right);
            if (map.containsKey(cRight)) {
                map.put(cRight, map.get(cRight) - 1);
                if (map.get(cRight) == 0) {
                    counter -= 1;
                }
            }

            while (counter <= 0) {
                char cLeft = s.charAt(left);
                if (map.containsKey(cLeft)) {
                    map.put(cLeft, map.get(cLeft) + 1);
                    if (map.get(cLeft) > 0) {
                        counter += 1;
                    }
                }
                if (right - left + 1 == p.length()) {
                    ans.add(left);
                }
                left++;
            }
        }

        return ans;
    }
}
