public class Missing_Number {
    public static void main(String[] args) {
        //https://leetcode.com/problems/missing-number/description/
          int[] arr = {4,0,2,1};
        System.out.println(missingNumber(arr));
    }
    static int missingNumber(int[] nums){
      int i = 0;
        while (i < nums.length) {
            int correct = nums[i];
            if (correct < nums.length && nums[i] != nums[correct]) {
                // swap nums[i] with nums[correct]
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            } else {
                i++;
            }
        }
        for (int j = 0; j < nums.length; j++) {
            if(nums[j] != j){
                return j;
            }
        }
        return nums.length;
    }
}
