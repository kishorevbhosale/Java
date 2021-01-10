package CoreJava.StringsProblems;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Reverse_String {
    public static void main(String[] args) {
        Pattern PATTERN = Pattern.compile(" +");
        String str = "This is reversed";

        // using java8
        String str1 = PATTERN.splitAsStream(str)
                .map(w -> new StringBuilder(w).reverse())
                .collect(Collectors.joining(" "));

        System.out.println(str1);


        // simple logic
        StringBuilder sb = new StringBuilder();
        String[] strs = str.split(" ");
        for (int i = 0; i < strs.length; i++) {
            for (int j = strs[i].length() - 1; j >= 0; j--) {
                sb.append(strs[i].charAt(j));
            }
            sb.append(" ");
        }
        System.out.println(sb);
    }
}

/*
output :
sihT si desrever
sihT si desrever
 */