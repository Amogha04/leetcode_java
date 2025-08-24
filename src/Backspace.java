public class Backspace {
    //https://leetcode.com/problems/backspace-string-compare/description/
    public static void main(String[] args) {
     String s = "ab#c";
     String t = "ad#c";
     System.out.println(backspaceCompare(s,t));
    }
    public static boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }

    public static String build(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c == '#') {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1); // simulate backspace
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
