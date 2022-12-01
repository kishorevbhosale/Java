package com.sk.demo.challange;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day1A {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\sonal\\OneDrive\\Desktop\\input.txt";

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            int max = -1;
            while (line != null) {
                int sum=0;
                while(line != null && line.trim().length()!= 0) {
                    sum += Integer.parseInt(line);
                    System.out.println(line+"    "+sum);
                    line = reader.readLine();
                }
                max = Math.max(max, sum);
                line = reader.readLine();
                System.out.println("MAX = "+max);
                System.out.println("=======================");
            }
            System.out.println("Final Max : "+max);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
