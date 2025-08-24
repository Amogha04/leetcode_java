public class First_Missing_Positive {
    public static void main(String[] args) {
        //https://leetcode.com/problems/first-missing-positive/description/
        int[] nums = {7,8,9,11,12};
        System.out.println(first_missing_positive(nums));
    }
    static int first_missing_positive(int[] nums){
        int i = 0;
        while(i < nums.length){
            int correct = nums[i] - 1;
            if(nums[i] > 0 && correct < nums.length && nums[i] != nums[correct]){
                int temp = 0;
                temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            }else i++;
        }
        for (int j = 0; j < nums.length; j++) {
            if(nums[j] != j + 1){
                return j + 1;
            }
        }
        return i + 1;
    }
}
