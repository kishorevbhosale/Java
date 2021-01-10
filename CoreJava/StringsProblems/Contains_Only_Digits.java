package CoreJava.StringsProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Contains_Only_Digits {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Boolean res = false;
        //using regx
        res = str.matches("[0-9]+");
        System.out.println(res);

        // Fastest way
        System.out.println(containsOnlyDigits(str));

    }

    public static boolean containsOnlyDigits(String str) {
        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            if (!Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }
}

/*
Output:
Test124
false
false

1234
true
true

Note:
Java 8 functional style and regular expression-based solutions are usually slow,
so if speed is a requirement,
then it's better to rely on the first solution using Character.isDigit().
 */

