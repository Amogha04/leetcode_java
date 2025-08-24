public class majority_element {
    //https://leetcode.com/problems/majority-element/description/
    public static void main(String[] args) {
     int[] arr = {2,2,1,1,1,2,2};
     System.out.println(majorityElement(arr));
    }
    //Boyer-Moore algorithm
    public static int majorityElement(int[] nums) {
       int majority = nums[0];
       int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(count == 0){
                majority = nums[i];
                count = 1;
            }
            else if(nums[i] == majority){
                count++;
            }else count--;
        }
        return majority;
    }
}
