package CoreJava.StringsProblems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Sorting_Using_Stream {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Test", "Data", "Sample", "Code", "Data");
        List<String> sortedStrings = strings.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedStrings);

        List<String> ascendingSortedStrings = strings.stream().sorted((o1, o2) -> o1.compareTo(o2)).collect(Collectors.toList());
        System.out.println(ascendingSortedStrings);

        List<String> descendingSortedStrings = strings.stream().sorted((o1, o2) -> o2.compareTo(o1)).collect(Collectors.toList());
        System.out.println(descendingSortedStrings);

        List<String> naturalSorting = strings.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        System.out.println(naturalSorting);
    }


}
