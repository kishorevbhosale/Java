package CoreJava.Objects_Immutability_Switch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class NullCheck {
    public static void main(String[] args) {
        List<Integer> numList = Arrays.asList(null, 2, 4, 5, null, 6, null, 9);
        System.out.println(getEven(numList));
        System.out.println(functionalEvenList(numList));
    }

    public static List<Integer> getEven(List<Integer> numList) {
        List<Integer> evenList = new ArrayList<>();
        if (Objects.isNull(numList)) {
            return Collections.EMPTY_LIST;
        } else {

            for (Integer i : numList) {
                if (Objects.nonNull(i) && i % 2 == 0) {
                    evenList.add(i);
                }
            }
        }
        return evenList;
    }

    public static List<Integer> functionalEvenList(List<Integer> numList) {
        if (Objects.isNull(numList)) {
            throw new IllegalArgumentException("List can not be empty");
        }
        return numList.stream()
                .filter(Objects::nonNull)
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList());
    }
}


/*
Output :
[2, 4, 6]
[2, 4, 6]


input as null ->
[]
Exception in thread "main" java.lang.IllegalArgumentException: List can not be empty
	at CoreJava.Objects_Immutability_Switch.NullCheck.functionalEvenList(NullCheck.java:34)
	at CoreJava.Objects_Immutability_Switch.NullCheck.main(NullCheck.java:14)
 */