public class Square_root {
    public static void main(String[] args) {
        System.out.println(square_root(40 , 3));
    }
    static double square_root(int x , int p){
        int start = 0;
        int end = x;
        double ans = 0.0;
        if(x < 0){
            System.out.println("Cannot find square roots of negative number");
            return -1;
        }
        if(x == 0 || x == 1){
            return x;
        }
        while (start <= end){
            int mid = start + (end - start)/2;
            if((long)mid * mid == x){
                return mid;
            } else if ((long)mid * mid < x) {
                 ans = mid;
                start = mid + 1;
            }else end = mid - 1;
        }
        double inc = 0.1;
        for (int i = 0; i < p; i++) {
            while (ans * ans <= x){
                ans+= inc;
            }
            ans-=inc;
            inc/=10;
        }
        return ans;
    }
}
