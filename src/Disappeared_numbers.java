import java.util.ArrayList;
import java.util.List;

public class Disappeared_numbers {
    //https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 5, 8, 3, 7};
        System.out.println(findDisappearedNumbers(nums));
    }
    static List<Integer> findDisappearedNumbers(int[] nums){
        int i = 0;
        while (i < nums.length) {
            int correct = nums[i] - 1;
            // swap only if nums[i] is not at its correct position and not a duplicate
            if (nums[i] >= 1 && nums[i] <= nums.length && nums[i] != nums[correct]) {
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            } else {
                i++;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                result.add(j + 1); // j + 1 is the missing number
            }
        }

        return result;
    }
}
