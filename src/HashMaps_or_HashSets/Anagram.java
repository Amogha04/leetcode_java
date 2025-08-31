package HashMaps_or_HashSets;

import java.util.HashMap;
import java.util.Map;

public class Anagram {
    //https://leetcode.com/problems/valid-anagram/description/
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(isAnagram(s,t));
    }
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character,Integer> string1 = new HashMap<>();
        Map<Character,Integer> string2 = new HashMap<>();

        for (char c : s.toCharArray()){
            string1.put(c,string1.getOrDefault(c,0) + 1);
        }
        for (char c : t.toCharArray()){
            string2.put(c,string2.getOrDefault(c,0) + 1);
        }
        return string1.equals(string2);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
    //https://leetcode.com/problems/group-anagrams/
     Map<String,List<String>> map = new HashMap<>();
     for(String word : strs){
         char[] c = word.toCharArray();
         Arrays.sort(c);
         String key = new String(c);

         if(!map.containsKey(key)){
             map.put(key,new ArrayList<>());
         }
         map.get(key).add(word);
     }
     return new ArrayList<>(map.values());
    }
}
