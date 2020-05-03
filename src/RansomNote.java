/*

Ransom Note
        Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return
        true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

        Each letter in the magazine string can only be used once in your ransom note.

        Note:
        You may assume that both strings contain only lowercase letters.

        canConstruct("a", "b") -> false
        canConstruct("aa", "ab") -> false
        canConstruct("aa", "aab") -> true
*/



import java.util.HashMap;
import java.util.Map;

public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        // if(ransomNote == null && magazine == null) return true;
        // if(ransomNote == null) return true;
        // if(magazine == null) return false;
        // if(ransomNote.length() == 0 && magazine.length() == 0) return true;
        // if(ransomNote.length() > magazine.length()) return false;

        Map<Character, Integer> freq = new HashMap<>();
        for(char c: magazine.toCharArray()) {
            if(freq.containsKey(c)) {
                freq.put(c, freq.get(c) + 1);
            } else {
                freq.put(c, 1);
            }
        }
        for(char c: ransomNote.toCharArray()) {
            if (freq.containsKey(c)) {
                if(freq.get(c) > 1) {
                    freq.put(c, freq.get(c) - 1);
                } else {
                    freq.remove(c);
                }
            }else{
                return false;
            }
        }
        return true;
    }
}
