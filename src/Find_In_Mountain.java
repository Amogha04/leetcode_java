public class Find_In_Mountain {
    public static void main(String[] args) {
        int[] arr = {0,1,2,4,2,1};
        System.out.println(findInMountainArray(3,arr));
    }
        static int find_peak(int[] arr){
            int start = 0;
            int end = arr.length - 1;
            while(start < end){
                int mid = start + (end - start)/2;
                if(arr[mid] > arr[mid + 1]){
                    end = mid;
                }else start = mid + 1;
            }
            return start;
        }
        static int o_binary(int[] arr, int target,int start,int end){
            start = 0;
            end = arr.length - 1;
            while (start <= end){
                int mid = start + (end - start)/2;
                if (arr[mid] < arr[mid] + 1){
                    if(arr[mid] == target){
                        return mid;
                    }else if(arr[mid] > target){
                        end = mid - 1;
                    }else start = mid + 1;
                }else{
                    if(arr[mid] == target){
                        return mid;
                    }else if(arr[mid] < target){
                        end = mid - 1;
                    }else start = mid + 1;
                }
            }
            return -1;
        }
        static int findInMountainArray(int target,int[] mountainArr) {
            int ele = find_peak(mountainArr);
            int ans = -1;
            if(ele > target){
                ans = o_binary(mountainArr,target,ele,mountainArr.length - 1);
            }else ans = o_binary(mountainArr,target,0,ele);
            return ans;
        }
}
