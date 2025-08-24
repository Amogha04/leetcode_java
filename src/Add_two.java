import java.util.Arrays;

public class Add_two {
    public static void main(String[] args) {
        int[] arr = {12,13,24,1,3,56};
        int target = 4;
        System.out.println(Arrays.toString(add_two(arr,target)));
    }
    static int[] add_two(int[] arr,int target){
        for (int i = 0; i < arr.length ; i++) {
            for (int j = 0; j < arr.length ; j++) {
                if(arr[i] + arr[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }
}