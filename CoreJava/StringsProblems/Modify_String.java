package CoreJava.StringsProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Modify_String {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        for (int i = 0; i < new Integer(str); i++) {
            String newstr = br.readLine();
            System.out.println(getResultString(newstr));

        }

    }

    public static StringBuilder getResultString(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            if (i > 0) {
                if (Character.isUpperCase(ch)) {
                    sb.append("_");
                    sb.append(Character.toLowerCase(ch));
                } else {
                    sb.append(Character.toLowerCase(ch));
                }
            } else {
                sb.append(Character.toLowerCase(ch));
            }
        }
        return sb;
    }
}

/*
Output:
2
ThisIsAwesome
this_is_awesome
TestCode
test_code
 */