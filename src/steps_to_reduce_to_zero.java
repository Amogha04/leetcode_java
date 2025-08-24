public class steps_to_reduce_to_zero {
    public static void main(String[] args) {
        //https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/description/
        int num = 14;
        System.out.println(numberOfSteps(num));
    }

    static int numberOfSteps(int num) {
       return helper(num,0);
    }

    static int helper(int num, int steps) {
        if(num == 0){
            return steps;
        }
        int rem = num % 2;
        if(rem == 0){
            return helper(num / 2, steps + 1);
        }else return helper(num - 1,steps + 1);
    }
}
