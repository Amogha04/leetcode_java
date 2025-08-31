package HashMaps_or_HashSets;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Intersection_Arrays {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        System.out.println(Arrays.toString(intersection(nums1,nums2)));
    }
    public static int[] intersection(int[] nums1, int[] nums2) {
    //https://leetcode.com/problems/intersection-of-two-arrays/
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for(int i : nums1){
            set1.add(i);
        }
        for(int i : nums2){
            set2.add(i);
        }

        Set<Integer> retain = new HashSet<>(set1);
        retain.retainAll(set2);

        int[] result = new int[retain.size()];
        int i = 0;
        for (Integer num : retain){
            result[i++] = num;
        }
        return result;
    }
}
