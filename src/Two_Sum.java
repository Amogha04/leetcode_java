import java.util.Arrays;

public class Two_Sum {
    public static void main(String[] args) {
        //https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
        int[] arr = {2,7,11,15};
        System.out.println(Arrays.toString(indices(arr, 9)));
    }
    static int[] indices(int[] arr,int target){
        int start = 0;
        int end = arr.length - 1;
            while (start <= end){
                int sum = arr[start] + arr[end];
                if(sum == target){
                    return new int[]{start + 1,end + 1};
                } else if (sum < target) {
                    start++;
                }else end--;
            }
            return new int[]{-1,-1};
    }
}
