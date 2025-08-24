import java.util.Arrays;

public class Shufftle_array {
    public static void main(String[] args) {
     int[] arr = {2,5,1,3,4,7};
     System.out.println(Arrays.toString(shuffle(arr, arr.length / 2)));
    }
    static int[] shuffle(int[] nums, int n){
        int[] ans = new int[2 * n];

        for (int i = 0; i < n; i++) {
            ans[2 * i] = nums[i];       // x1, x2, x3...
            ans[2 * i + 1] = nums[i + n]; // y1, y2, y3...
        }

        return ans;
    }
}
