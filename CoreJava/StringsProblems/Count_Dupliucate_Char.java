package CoreJava.StringsProblems;

import java.util.HashMap;
import java.util.Map;

public class Count_Dupliucate_Char {
    public static void main(String[] args) {
        String str = "aabcccbbaaadbc";
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (countMap.containsKey(ch)) {
                countMap.put(ch, countMap.get(ch) + 1);
            } else {
                countMap.put(ch, 1);
            }

            //countMap.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
        }
        System.out.println(countMap);
    }
}

/*
Output :
{a=5, b=4, c=4, d=1}
 */