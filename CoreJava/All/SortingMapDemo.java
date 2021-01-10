package collection;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SortingMapDemo {
    public static void main(String[] args) {
        Map<String, Integer> studentMap = new HashMap<String, Integer>();

        studentMap.put("Joti", 87);
        studentMap.put("Kartik", 82);
        studentMap.put("Yash", 91);
        studentMap.put("Larry", 89);
        studentMap.put("Narayan", 95);
        studentMap.put("Ajay", 86);

        System.out.println("\n studentMap : ");
        System.out.println(studentMap);

        //Default sorting ascending
        System.out.println("\n Default sorting ascending");
        Map<String, Integer> sortedStudentMap = new TreeMap<>(studentMap);
        System.out.println(sortedStudentMap);

        // Reverse sorting
        System.out.println("\n Reverse sorting");
        Map<String, Integer> revsortedStudentMap = new TreeMap<>(Collections.reverseOrder());
        revsortedStudentMap.putAll(studentMap);
        System.out.println(revsortedStudentMap);

        // Custom sorting
        System.out.println("\n Custom sorting");
        Map<String, Integer> customSortedStudentMap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int l1 = o1.length();
                int l2 = o2.length();
                if (l1>l2){
                    return -1;
                }else if (l1<l2){
                    return 1;
                }else {
                    return o2.compareTo(o1);
                }
            }
        });
        customSortedStudentMap.putAll(studentMap);
        System.out.println(customSortedStudentMap);
        
        
        System.out.println("\n comparingByKey():");
        Map<String, Integer> byKeySortedStudentMap
                = studentMap.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
        byKeySortedStudentMap.putAll(studentMap);
        System.out.println(byKeySortedStudentMap);
        
        
        System.out.println("\n comparingByVal():");

        Map<String, Integer> byValSortedStudentMap = studentMap.entrySet().stream()
                .sorted((Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

        byValSortedStudentMap.putAll(studentMap);
        System.out.println(byValSortedStudentMap);

    }
}

/*
output -

 studentMap :
{Yash=91, Narayan=95, Larry=89, Joti=87, Kartik=82, Ajay=86}

 Default sorting ascending
{Ajay=86, Joti=87, Kartik=82, Larry=89, Narayan=95, Yash=91}

 Reverse sorting
{Yash=91, Narayan=95, Larry=89, Kartik=82, Joti=87, Ajay=86}

 Custom sorting
{Narayan=95, Kartik=82, Larry=89, Yash=91, Joti=87, Ajay=86}

 comparingByKey():
{Yash=91, Narayan=95, Larry=89, Kartik=82, Joti=87, Ajay=86}

comparingByVal():
{Kartik=82, Ajay=86, Joti=87, Larry=89, Yash=91, Narayan=95}

*/
