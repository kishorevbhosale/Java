package com.sk.demo.challange;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Day1A {
    public static void main(String[] args) {
        Set<Integer> sortedSet = new TreeSet<>(Collections.reverseOrder());
        try(BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\sonal\\OneDrive\\Desktop\\input.txt"))) {
            String line = reader.readLine();
            int max = -1;
            while (line != null) {
                int sum=0;
                while(line != null && line.trim().length()!= 0) {
                    sum += Integer.parseInt(line);
                    line = reader.readLine();
                }
                sortedSet.add(sum);
                max = Math.max(max, sum);
                line = reader.readLine();
            }
            System.out.println("Final Max : "+max);
            System.out.println("Max 3 sum : "+sortedSet.stream().limit(3).collect(Collectors.summarizingInt(i->i)).getSum());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
