package com.telerik;

import java.io.ByteArrayInputStream;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void fakeInput() {
        String input = "105\n" +
                "5";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    public static void main(String[] args) {
        fakeInput();
        Scanner in = new Scanner(System.in);

        String[] numbersString = in.nextLine().split("");
        int[] numbers = new int[numbersString.length];
        for (int i = 0; i < numbersString.length; i++) {
            numbers[i] = Integer.parseInt(numbersString[i]);
        }
        int n = in.nextInt();
        int counter = 0;
        String[] operators = {"+", "*", "-", ""};

        int maxEnc = 1;
        for (int i = 0; i < numbers.length - 1; i++)
            maxEnc *= operators.length;

        int[] digits = new int[operators.length];
        int tmp;
        for (int i = 0; i < maxEnc; i++) {
            tmp = i;

            for (int j = 0; j < operators.length; j++) {
                digits[j] = tmp % operators.length;
                tmp /= operators.length;
            }

            String result = "";
            for (int j = 0; j < numbers.length - 1; j++) {

                result += numbers[j] + operators[digits[j]];
            }
            result += numbers[numbers.length - 1];

            int resultNumber = (int) eval(result);
            System.out.println(result + "=" + resultNumber);
            if (n == resultNumber) {
                counter++;
            }
        }
        System.out.println(counter);
    }

    public static double eval(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char) ch);
                return x;
            }

            double parseExpression() {
                double x = parseTerm();
                for (; ; ) {
                    if (eat('+')) x += parseTerm();
                    else if (eat('-')) x -= parseTerm();
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (; ; ) {
                    if (eat('*')) x *= parseFactor();
                    else if (eat('/')) x /= parseFactor();
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor();
                if (eat('-')) return -parseFactor();

                double x;
                int startPos = this.pos;
                if (eat('(')) {
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') {
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') {
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                } else {
                    throw new RuntimeException("Unexpected: " + (char) ch);
                }


                return x;
            }
        }.parse();
    }
}
