/*

Permutation in String
Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.



Example 1:

Input: s1 = "ab" s2 = "eidbaooo"
Output: True
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input:s1= "ab" s2 = "eidboaoo"
Output: False


Note:

The input strings only contain lower case letters.
The length of both given strings is in range [1, 10,000].
   Hide Hint #1
Obviously, brute force will result in TLE. Think of something else.
   Hide Hint #2
How will you check whether one string is a permutation of another string?
   Hide Hint #3
One way is to sort the string and then compare. But, Is there a better way?
   Hide Hint #4
If one string is a permutation of another string then they must one common metric. What is that?
   Hide Hint #5
Both strings must have same character frequencies, if one is permutation of another. Which data structure should be used to store frequencies?
   Hide Hint #6
What about hash table? An array of size 26?


 */


import java.util.HashMap;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {

        HashMap<Character, Integer> dict = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            int feq = dict.getOrDefault(s1.charAt(i), 0);
            dict.put(s1.charAt(i), feq + 1);
        }

        HashMap<Character, Integer> temp = new HashMap<>();
        int i = 0;
        for (int j = 0; j < s2.length(); j++) {
            if (!dict.containsKey(s2.charAt(j))) {
                i = j + 1;
                temp.clear(); //clear counter
                continue;
            }

            int count = temp.getOrDefault(s2.charAt(j), 0);
            if (count == 0 || count < dict.get(s2.charAt(j))) {
                temp.put(s2.charAt(j), count + 1);

                if (j - i + 1 == s1.length()) {
                    return true;
                }
            } else {
                while (i < j) {
                    if (s2.charAt(i) == s2.charAt(j)) {
                        i++;
                        break;
                    }

                    temp.put(s2.charAt(i), temp.get(s2.charAt(i)) - 1);
                    i++;
                }
            }
        }

        return false;
    }
}
