import java.util.Arrays;

public class Zero_indexed {
    public static void main(String[] args) {
        int[] arr = {0,2,1,5,3,4};
        System.out.println(Arrays.toString(buildArray(arr)));
    }
    static int[] buildArray(int[] nums){
        int[] new_array = new int[nums.length];
        for(int i = 0;i < new_array.length ; i++){
            new_array[i] = nums[nums[i]];
        }
        return new_array;
    }
}
