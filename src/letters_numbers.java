import java.util.ArrayList;

public class letters_numbers {
    //https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
    public static void main(String[] args) {
      String digits = "23";
      ArrayList<String> result = helper("",digits);
        System.out.println(result);
    }
    static ArrayList<String> helper(String p,String digits){
        if(digits.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        int digit = digits.charAt(0) - '0';
        ArrayList<String> ans = new ArrayList<>();
        if ((digit >= 2 && digit <= 6)) {
            for (int i = (digit - 2) * 3; i <= (digit - 2) * 3 + 2; i++) {
                char ch = (char)('a' + i);
                ans.addAll(helper(p + ch, digits.substring(1)));
            }
        } else if (digit == 7) {
            for (int i = (digit - 2) * 3; i <= (digit - 2) * 3 + 3; i++) {
                char ch = (char)('a' + i);
                ans.addAll(helper(p + ch, digits.substring(1)));
            }
        } else if (digit == 8) {
            for (int i = (digit - 2) * 3 + 1; i <= (digit - 2) * 3 + 3; i++) {
                char ch = (char)('a' + i);  // i = 19 to 21
                ans.addAll(helper(p + ch, digits.substring(1)));
            }
        } else if (digit == 9) {
            for (int i = (digit - 2) * 3 + 1; i <= (digit - 2) * 3 + 4; i++) {
                char ch = (char)('a' + i);  // i = 22 to 25
                ans.addAll(helper(p + ch, digits.substring(1)));
            }
        }
        return ans;
    }
}
