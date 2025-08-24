import java.util.Arrays;

public class single_num {
    public static void main(String[] args) {
        int[] arr = {2,2,1};
        //[1,2,2]
        System.out.println(singleNumber(arr));;
    }
    public static int singleNumber(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int i = 1;
        Arrays.sort(nums);
        while (i < nums.length){
            if(nums[i] == nums[i - 1]){
                i += 2;
            }else {
                return nums[i - 1];
            }
        }
        return nums[nums.length - 1];
    }
}
