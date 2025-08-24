public class Peak_index_MA {
    public static void main(String[] args) {
         int[] arr = {3,4,5,1};
        System.out.println(peakIndexInMountainArray(arr));
    }
//    static int peakIndexInMountainArray(int[] arr){
//        int start = 0;
//        int end = arr.length - 1;
//        while (start < end){
//            int mid = start + (end - start)/2;
//            if(arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]){
//                return mid;
//            } else if (arr[mid] < arr[mid + 1]) {
//                start = mid;
//            }else end = mid;
//        }
//        return -1;
//    }
     static int peakIndexInMountainArray(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        while (start < end){
            int mid = start + (end - start)/2;
            if(arr[mid] > arr[mid + 1]){
                end = mid;
            }else start = mid + 1;
        }
        return start;
     }
}
