import java.util.* ;
public class Panagram {
    public static void main(String[] args) {
        String names = "thequickbrownfoxjumpsoverthelazydog";
        char[] name = names.toCharArray();
        System.out.println(Arrays.toString(name));
        System.out.println(check_panagram(names));
    }

    static boolean check_panagram(String sentence) {
            Set<Character> letters = new HashSet<>();

            for (char c : sentence.toLowerCase().toCharArray()) {
                if (c >= 'a' && c <= 'z') {
                    letters.add(c);
                }
                if (letters.size() == 26) {
                    return true; // All letters found
                }
            }

            return false; // Not all letters found
    }
}
