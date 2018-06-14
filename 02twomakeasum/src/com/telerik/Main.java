package com.telerik;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void fakeInput() {
        String test = "1 2 4\n" +
                "1 2 3";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

    public static void main(String[] args) throws IOException {
        fakeInput();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Scanner in = new Scanner(System.in);
        String[] numbersString = br.readLine().split(" ");
        String[] sumsString = br.readLine().split(" ");
        ArrayList<Integer> sums = new ArrayList<>();
        for (String sum : sumsString) {
            sums.add(Integer.parseInt(sum));
        }
        HashSet<Integer> used = new HashSet<>();
        int result = 0;
        for (int i = 0; i < numbersString.length; i++) {
            for (int j = 0; j < numbersString.length; j++) {
                if (i == j) {
                    continue;
                }
                int sum = Integer.parseInt(numbersString[i]) + Integer.parseInt(numbersString[j]);
                for (int number : sums) {
                    if (number == sum && !used.contains(number)) {
                        result += 1;
                        used.add(number);
                        break;
                    }
                }

            }
        }
        System.out.println(result);
    }
}
