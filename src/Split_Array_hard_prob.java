public class Split_Array_hard_prob {
    public static void main(String[] args) {
      int k = 2;
      int[] nums = {7,2,5,10,8};
        System.out.println(split_array(nums,k));
    }
    static int split_array(int[] nums,int m){
        int start = 0;
        int end = 0;
        for(int num : nums){
            start = Math.max(start,num);
            end += num;
        }
        while (start < end){
            int mid = start + (end - start)/2;
            int sum = 0;
            int pieces = 1;
            //Now we need to check 2 conditions
            //1:To check if sum exceeds mid,code snippet for number of sub-arrays
            for (int num : nums){
                if(sum + num > mid){
                    sum = num;
                    pieces++;
                }else sum += num;

            }
            //for checking if no. of pieces is > required
            if(pieces > m){
                start = mid + 1;
            }else end = mid;
        }
        return start;//return start or end as start == end
    }
}
