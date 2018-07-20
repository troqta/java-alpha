package com.expressions;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] numbersString = in.nextLine().split("");
//        in.nextLine();
//        int n = in.nextInt();
        LinkedList<Integer> numbers = new LinkedList<>();
        for (String number : numbersString) {
            numbers.add(Integer.parseInt(number));
        }
        char[] operations = {'*', '+', '-'};
        permutateSigns(operations, numbers, 0, "");
    }

    public static void permutateSigns(char[] operations, LinkedList<Integer> numbers, int pos, String expression) {
        expression += numbers.get(pos);
        if (pos == numbers.size() - 1) {
            System.out.println(expression);
        } else {
            for (char operation : operations) {
                permutateSigns(operations, numbers, pos + 1, expression + operation);
            }
        }
    }
}
