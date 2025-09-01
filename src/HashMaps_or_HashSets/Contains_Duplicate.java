package HashMaps_or_HashSets;

public class Contains_Duplicate {
    public static void main(String[] args) {
     int[] nums = {1,2,3,1};
        System.out.println(containsNearbyAlmostDuplicate(nums,3,0));
    }
    //You are given an integer array nums and two integers indexDiff and valueDiff.
    //
    //Find a pair of indices (i, j) such that:
    //
    //i != j,
    //abs(i - j) <= indexDiff.
    //abs(nums[i] - nums[j]) <= valueDiff, and
    //Return true if such pair exists or false otherwise.
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
    //https://leetcode.com/problems/contains-duplicate-iii/
        for(int i = 0;i < nums.length;i++){
            for(int j = 0;j < nums.length;j++){
                if(i != j && Math.abs(i - j) <= indexDiff &&
                        Math.abs(nums[i] - nums[j]) <= valueDiff){
                    return true;
                }
            }
        }
        return false;
    }
}
