package CoreJava.StringsProblems;

import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Count_Vowels_Consonants {
    private static final Set<Character> allVowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(String.format("Vowels  = %s,\nConsonants = %s", getCount(str.toLowerCase()).getKey(),
                getCount(str.toLowerCase()).getValue()));

        System.out.println(String.format("Vowels  = %s,\nConsonants = %s", getCountUsingJava8(str.toLowerCase()).getKey(),
                getCountUsingJava8(str.toLowerCase()).getValue()));

    }

    public static Pair<Integer, Integer> getCount(String str) {
        Integer vowels = 0;
        Integer consonants = 0;
        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            if (allVowels.contains(ch)) {
                vowels++;
            } else if (ch >= 'a' && ch <= 'z') {
                consonants++;
            }
        }
        return new Pair<>(vowels, consonants);
    }


    public static Pair<Long, Long> getCountUsingJava8(String str) {
        Long consonants = str.chars().filter(ch -> !allVowels.contains((char) ch))
                .filter(ch -> ch >= 'a' && ch <= 'z').count();
        Long vowels = str.chars().filter(ch -> allVowels.contains((char) ch)).count();
        return new Pair<>(vowels, consonants);
    }
}


/*
Output:

This is our tres qwer
Vowels  = 6,
Consonants = 11
Vowels  = 6,
Consonants = 11

 */