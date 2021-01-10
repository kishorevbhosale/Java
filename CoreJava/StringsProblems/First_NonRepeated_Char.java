package CoreJava.StringsProblems;

import java.util.HashMap;
import java.util.Map;


public class First_NonRepeated_Char {
    public static void main(String[] args) {
        String str = "kaabecccbbaaadbccef";
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            countMap.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (countMap.get(ch) == 1) {
                System.out.println(ch);
                break;
            }
        }

    }
}
/*
Output:
k
 */