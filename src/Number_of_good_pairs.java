public class Number_of_good_pairs {
    public static void main(String[] args) {
        int[] arr = {1,2,3,1,1,3};
        System.out.println(good_pairs(arr));
    }
    static int good_pairs(int[] nums){
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(nums[i] == nums[j] && i < j){
                    count++;
                }
            }
        }
        return count;
    }
}
