package com.sk.demo.challange;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Day1A {
    public static void main(String[] args) {
        Set<Integer> sortedSet = new TreeSet<>(Collections.reverseOrder());
        int max = -1, sum=0;
        try(BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\sonal\\OneDrive\\Desktop\\input.txt"))) {
            String line = reader.readLine();
            while (line != null) {
                if(line.trim().length() == 0) {
                    max = Math.max(max, sum);
                    sum = 0;
                }else {
                    sum += Integer.parseInt(line);
                    sortedSet.add(sum);
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Final Max : "+max);
        System.out.println("Max 3 sum : "+sortedSet.stream().limit(3).collect(Collectors.summarizingInt(i->i)).getSum());
    }
}
