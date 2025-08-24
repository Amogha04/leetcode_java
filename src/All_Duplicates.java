import java.util.ArrayList;
import java.util.List;

public class All_Duplicates {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(all_duplicates(nums));
    }
    static List<Integer> all_duplicates(int[] nums){
        int i = 0;
        while (i < nums.length){
            int correct = nums[i] - 1;
            if(nums[i] != nums[correct]){
                int temp;
                temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            }else i++;
        }
        List<Integer> result = new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            if(nums[j] != j + 1){
                result.add(nums[j]);
            }
        }
        return result;
    }
}
