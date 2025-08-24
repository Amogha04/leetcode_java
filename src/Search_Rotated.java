public class Search_Rotated {
    public static void main(String[] args) {
        int[] arr = {3,4,5,6,1,2};
        System.out.println(find_pivot(arr));
        System.out.println(search(arr,2));
    }
    static int search(int[] arr,int target){
        int pivot = find_pivot(arr);
        if(pivot == -1){
            return binary_search(arr,target,0, arr.length - 1);
        }
        if (arr[pivot] == target){
            return pivot;
        }
        if(target < arr[0]){
           return binary_search(arr,target,pivot + 1, arr.length - 1);
        }
        else return binary_search(arr,target,0,pivot - 1);

    }
    static int binary_search(int[] arr,int target,int start,int end){
        while (start <= end){
            int mid = start + (end - start)/2;
            if (target == arr[mid]){
                return mid;
            }
            if(target > arr[mid]){
                start = mid + 1;
            }
            else end = mid - 1;
        }
        return -1;
    }
    static int find_pivot(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        //4 cases for finding pivot
        //1: mid > mid + 1 -> return mid
        //2: mid < mid - 1 -> return mid - 1
        //3: mid <= start -> start = mid + 1
        //4: mid > start -> end = mid - 1
        while (start <= end){
            int mid = start + (end - start)/2;
            if(mid < end && arr[mid] > arr[mid + 1]){
                return mid;
            }
            if(mid > start && arr[mid] < arr[mid - 1]){
                return mid - 1;
            }
            if(arr[mid] <= arr[start]){
                end = mid - 1;
            }else start = mid + 1;
        }
        return -1;
    }
}
// NOTE: DO ROTATED DUPLICATES LATER !!!!!!!
