public class Duplicate_num {
    public static void main(String[] args) {
        //https://leetcode.com/problems/find-the-duplicate-number/
        int[] arr = {3,1,3,4,2};
        System.out.println(duplicate_num(arr));
    }
    static int duplicate_num(int[] arr){
        int i = 0;
        while (i < arr.length){
            int correct = arr[i] - 1;
            if(arr[i] != arr[correct]){
                int temp;
                temp = arr[i];
                arr[i] = arr[correct];
                arr[correct] = temp;
            }else i++;
        }
        for (int j = 0; j < arr.length; j++) {
            if(arr[j] != j + 1){
                return arr[j];
            }
        }
        return -1;
    }
}
