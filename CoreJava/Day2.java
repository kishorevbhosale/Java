package com.sk.demo.challange;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day2 {
    public static void main(String[] args) {
        int your_sum = 0;
        int oppent_sum = 0;
        try(BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\sonal\\OneDrive\\Desktop\\input.txt"))) {
            String line = reader.readLine();
            while (line != null) {

                String input1 = line.split(" ")[0];
                String input2 = line.split(" ")[1];
                int val1 = getVal(input1);
                int val2 = getVal(input2);
                System.out.println(input1+": "+val1+"   "+input2+": "+val2);
                if (val1<val2){
                    your_sum += val2+6;
                    oppent_sum += val1;
                    System.out.println(input2+" win, opponent_sum ="+oppent_sum+" your_sum = "+your_sum);
                }
                else if(val1>val2){
                    your_sum += val2;
                    oppent_sum += val1+6;
                    System.out.println(input1+" win, opponent_sum ="+oppent_sum+" your_sum = "+your_sum);
                }
                else{
                    your_sum += val2+3;
                    oppent_sum += val1+3;
                    System.out.println(" draw, opponent_sum ="+oppent_sum+" your_sum = "+your_sum);
                }

                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("opponent_sum = "+oppent_sum+" your_sum = "+your_sum);
    }

    private static int getVal(String x){
        switch (x) {
            case "A":
            case "X":
                return 1;
            case "B":
            case "Y":
                return 2;
            case "C":
            case "Z":
                return 3;
            default:
                return 0;
        }
    }
}

/*
A = Rock (1)       = X
B = Paper  (2)     = Y
C = Scissors (3)   = Z
lost = 0
win = 6
draw = 3
A Y => 1 : 2 =>  2+6
B X => 2 : 1 =>  1+0
C Z => 3 : 3 =>  3+3

B Y => 2+3 => 5
A Z => 3+6 => 5+9
A Z => 3+6 => 14+9

 */
