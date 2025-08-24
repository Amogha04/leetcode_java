public class GreaterthanChar {
    public static void main(String[] args) {
        //https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
    char[] arr = {'x','x','y','y'};
        System.out.println(nextGreatestLetter(arr,'z'));
    }
    static char nextGreatestLetter(char[] letters, char target){
        int start = 0;
        int end = letters.length - 1;
        if(target >= letters[letters.length -1]){
            return letters[0];
        }
        while (start <= end){
            int mid = start + (end - start)/2;
            if(letters[mid] > target ){
                end = mid - 1;
            } else if (letters[mid] < target) {
                start = mid + 1;
            }
        }
        return letters[start % letters.length];
    }
}
