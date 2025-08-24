import java.util.Arrays;

public class Move_Zeroes {
    //https://leetcode.com/problems/move-zeroes/description/
    public static void main(String[] args) {
        int[] arr = {1,0,9,6,4,0,3};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void moveZeroes(int[] nums) {
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                nums[pos++] = nums[i];
            }
        }
        while (pos < nums.length){
            nums[pos++] = 0;
        }
    }
}
