import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class k_freq_ele {
    public static void main(String[] args) {
        //https://leetcode.com/problems/top-k-frequent-elements/
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums,k)));
    }

    private static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums){
            map.put(num,map.getOrDefault(num,0) + 1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> max = new PriorityQueue<>
                ((a,b) -> b.getValue() - a.getValue());
        max.addAll(map.entrySet());

        int[] ans = new int[k];
        for (int i = 0;i < k;i++){
            ans[i] = max.poll().getKey();
        }
        return ans;
    }
}
