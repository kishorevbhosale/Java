package collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class SumEvenCountDigits {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
        int n = Integer.valueOf(br.readLine());
        while (n > 0) {
            String str = br.readLine();
            List<String> num = Arrays.asList(str.split(" "));
            HashSet<String> hs = new HashSet<>();
            hs.addAll(num);
            int resultList = 0;
            for (String ch : hs) {
                long count = num.stream().filter(c -> c.equals(ch))
                        .count();
                if (count % 2 == 0)
                    resultList += (Integer.valueOf(ch));

            }
            System.out.println(resultList);
            n--;
        }
    }
}
