public class NumArray {
    private int[] nums;

    //https://leetcode.com/problems/range-sum-query-immutable/description/
    public NumArray(int[] nums){
        this.nums = nums;
    }
    public int sumRange(int left, int right) {
      int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += nums[i];
        }
        return sum;
    }
}
