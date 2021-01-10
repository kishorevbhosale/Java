package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionMethods {
    public static void main(String[] args) {
        HashSet<Integer> hashSet = new HashSet<>();
        Stream<Integer> stream = Stream.of(5, 13, 4, 21, 13, 27, 2, 59, 59, 34);
        System.out.println("Using hashSet : "+stream.filter(num->!hashSet.add(num)).collect(Collectors.toSet()));
        stream.close();

        List<Integer> list = Arrays.asList(5, 13, 4, 21, 13, 27, 2, 59, 59, 34);
        System.out.println("Using Frequency : "+list.stream().filter(num-> Collections.frequency(list,num)>1).collect(Collectors.toSet()));

        Integer arr1[] = {10, 20, 30, 40, 50};
        Integer arr2[] = {60, 70, 80, 90, 100};
        Integer arr3[] = {60, 70, 30, 90, 100};
        System.out.println("Disjoint operation arr1 and arr2: "+Collections.disjoint(Arrays.asList(arr1),Arrays.asList(arr2)));
        System.out.println("Disjoint operation arr2 and arr3: "+Collections.disjoint(Arrays.asList(arr1),Arrays.asList(arr3)));


        List<String>  mylist = new ArrayList<String>();
        mylist.add("practice");
        mylist.add("code");
        mylist.add("code");
        mylist.add("quiz");
        mylist.add("geeksforgeeks");

        System.out.println("Frequency of given word : "+Collections.frequency(mylist, "code"));


        System.out.println("Original List : " + mylist);
        Collections.rotate(mylist, 2);
        System.out.println("Rotated List: " + mylist);

        System.out.println("Original Array : " + Arrays.toString(arr1));
        Collections.rotate(Arrays.asList(arr1), 2);
        System.out.println("Modified Array : " + Arrays.toString(arr1));

        Collections.sort(mylist, Collections.reverseOrder());

        // Let us print the sorted list
        System.out.println("List after the use of Collection.reverseOrder() and Collections.sort() :\n" + mylist);

        Collections.shuffle(mylist);

        System.out.println("Shuffled List : " + mylist);

        System.out.println("Before swap list : "+mylist);
        Collections.swap(mylist, 1, 3);
        System.out.println("After swap(mylist, 1, 3) : "+ mylist);

        Collections.binarySearch(Arrays.asList(arr3), 30);
        System.out.println("Binary search in collection - index of 30 : "+Collections.binarySearch(Arrays.asList(arr3), 30));
    }
}
/*
        Using hashSet : [59, 13]

        Using Frequency : [59, 13]

        Syntax:
        public static boolean disjoint(Collection<?> c1, Collection<?> c2)
        Parameters :
        c1 - a collection
        c2 - a collection
        Returns :
        true if the two specified collections have no elements in common.
        Throws:
        NullPointerException - if either collection is null.
        NullPointerException - if one collection contains a null element and null is not an eligible
        element for the other collection.
        ClassCastException - if one collection contains an element that is of a type which is ineligible
        for the other collection.

        Disjoint operation arr1 and arr2: true
        Disjoint operation arr2 and arr3: false

        Frequency of given word : 2

        Original List : [practice, code, code, quiz, geeksforgeeks]
        Rotated List: [quiz, geeksforgeeks, practice, code, code]
        Original Array : [10, 20, 30, 40, 50]
        Modified Array : [40, 50, 10, 20, 30]

        List after the use of Collection.reverseOrder() and Collections.sort() :
        [quiz, practice, geeksforgeeks, code, code]

        Shuffled List : [code, geeksforgeeks, practice, quiz, code]

        Before swap list : [code, geeksforgeeks, code, quiz, practice]
        After swap(mylist, 1, 3) : [code, quiz, code, geeksforgeeks, practice]

        Binary search in collection - index of 30 : 2
*/
