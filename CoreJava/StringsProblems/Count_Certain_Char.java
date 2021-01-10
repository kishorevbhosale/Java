package CoreJava.StringsProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Count_Certain_Char {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toLowerCase();
        Character ch = (char) br.read();
        long count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.toLowerCase(ch) == str.charAt(i)) {
                count++;
            }
        }
        System.out.println(ch + " ocuured " + count + " times");


        //Using java8
        count = str.chars().filter(c -> Character.toLowerCase(ch) == c).count();
        System.out.println(ch + " ocuured " + count + " times");
    }
}

/*
Output :
I m in
i
i ocuured 2 times
i ocuured 2 times
 */