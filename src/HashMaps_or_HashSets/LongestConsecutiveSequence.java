package HashMaps_or_HashSets;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive(nums));
    }
    public static int longestConsecutive(int[] nums) {
    //https://leetcode.com/problems/longest-consecutive-sequence/description/?utm_source=chatgpt.com
        if(nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int i : nums){
            set.add(i);
        }
        int longest = 1;
        int current = 1;

        int[] traverse = new int[set.size()];
        int index = 0;
        for(Integer i : set){
            traverse[index++] = i;
        }
        Arrays.sort(traverse);
        for (int i = 1; i < traverse.length; i++) {
            if(traverse[i] == (traverse[i - 1] + 1)){
             current++;
             longest = Math.max(current,longest);
            }else current = 1;
        }
        return longest;
    }
}
