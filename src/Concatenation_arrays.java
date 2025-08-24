import java.util.Arrays;

public class Concatenation_arrays {
    public static void main(String[] args) {
        int[] arr = {1,2,1};
        System.out.println(Arrays.toString(concatenation(arr)));
    }
    static int[] concatenation(int[] nums){
        int[] ans = new int[2 * nums.length];
        for (int i = 0;i < nums.length;i++){
            ans[i] = nums[i];
            ans[i + nums.length] = nums[i];
        }
        return ans;
    }
}
