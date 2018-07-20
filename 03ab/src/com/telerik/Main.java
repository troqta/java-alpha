package com.telerik;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void fakeInput() {
        String input = "3\n" +
                "1 3";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    public static void main(String[] args) {
        fakeInput();
        Scanner in = new Scanner(System.in);
        LinkedList<char[]> items = new LinkedList<char[]>();
        int n = in.nextInt();
        in.nextLine();
        char[] item = new char[n];
        String[] inputArray = in.nextLine().split(" ");
        char[] input = new char[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            input[i] = inputArray[i].charAt(0);
        }
        Arrays.sort(input);
        rep(items, input, item, 0);


        for (char[] rep : items) {
            System.out.println(rep);
        }
    }

    private static void rep(LinkedList<char[]> reps, char[] input, char[] item, int count) {
        if (count < item.length) {
            for (int i = 0; i < input.length; i++) {
                item[count] = input[i];
                rep(reps, input, item, count + 1);
            }
        } else {
            reps.add(item.clone());
        }

    }
}
