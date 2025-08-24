import java.util.Arrays;

public class First_and_Last_element {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 4, 4, 6, 7, 8};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(searchRange(arr, 4)));
    }
    static int find_start(int[] arr,int target){
        int start = 0;
        int end = arr.length - 1;
        int first = -1;
        while (start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] > target){
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else if (arr[mid] == target) {
               first = mid;
               end = mid - 1; // there could be previous occurences so search left
            }
        }
        return first;
    }
    static int find_end(int[] arr,int target){
        int start = 0;
        int end = arr.length - 1;
        int last = -1;
        while (start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] > target){
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else if (arr[mid] == target) {
                last = mid;
                start = mid + 1; // there could be previous occurences so search left
            }
        }
        return last;
    }

    static int[] searchRange(int[] nums, int target) {
        int start = find_start(nums,target);
        int last = find_end(nums,target);
        int[] arr = {start,last};
        return arr;
    }
}
