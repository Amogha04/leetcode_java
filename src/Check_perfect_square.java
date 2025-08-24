public class Check_perfect_square {
    public static void main(String[] args) {
        //https://leetcode.com/problems/valid-perfect-square/description/
        int num = 30;
        System.out.println(isPerfect(num));
    }
    static boolean isPerfect(int num){
        if(num == 0 || num == 1){
            return true;
        }
        int start = 0;
        int end = num;
        while (start <= end){
            int mid = start + (end - start)/2;
            if((long)mid * mid == num){
                if(mid == (int)mid){
                    return true;
                }
            }
            if ((long)mid * mid < num){
                start = mid + 1;
            }else end = mid - 1;
        }
        return false;
    }
}