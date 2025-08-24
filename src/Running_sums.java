import java.util.Arrays;

public class Running_sums {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(Arrays.toString(running_sums(arr)));
    }

    static int[] running_sums(int[] arr){
        int sum = 0;
        int[] ans = new int[arr.length];
        for (int i = 0;i < arr.length;i++){
            ans[i] = sum + arr[i];
            sum = sum + arr[i];
        }
        return ans;
    }
}
