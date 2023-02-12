import java.util.*;

public class StringPermutations {

    public static void swap(StringBuilder str, int i, int j) {
        char ch = str.charAt(i);
        str.setCharAt(i, str.charAt(j));
        str.setCharAt(j, ch);
    }

    public static void solve(StringBuilder str, int start, List<String> result) {
        if(start >= str.length() - 1) {
            result.add(str.toString());
            return;
        }
        for(int i = start; i < str.length(); i++) {
            StringPermutations.swap(str, i, start);
            StringPermutations.solve(str, start + 1, result);
            StringPermutations.swap(str, i, start);
        }
    }

    public static List<String> permute(String string) {
        List<String> result = new ArrayList<String>();
        StringPermutations.solve(new StringBuilder(string), 0, result);
        return result;
    }

    public static void main(String[] args) {
        String string = "ABC";
        List<String> result = StringPermutations.permute(string);
        for(String s : result) {
            System.out.print(s + " ");
        }
    } 
}
