import java.util.Objects;

public class SubSequence {
    //https://leetcode.com/problems/is-subsequence/description/
    public static void main(String[] args) {
     String s = "atbcgh";
     String t = "abc";
     System.out.println(isSubsequence(s,t));
    }
    public static boolean isSubsequence(String s, String t) {
        return ans(s,t,"");
    }

    private static boolean ans(String s, String t,String p) {
      if(Objects.equals(t, p)){
          return true;
      }
      if(s.isEmpty()){
          return false;
      }
      char c = s.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            ans(s.substring(1),t,p + c);
            ans(s.substring(1),t,p);
        }
      return false;
    }
}
