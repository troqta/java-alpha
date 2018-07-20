package com.telerik;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void fakeInput() {
        String input = "6 7 3\n" +
                "0 0\n" +
                "2 2\n" +
                "-2 2\n" +
                "3 -1";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    public static void main(String[] args) {
        fakeInput();
        Scanner in = new Scanner(System.in);
        int rows = in.nextInt();
        int cols = in.nextInt();
        int j = in.nextInt();
        in.nextLine();
        int row = in.nextInt();
        int col = in.nextInt();
        in.nextLine();
        int numberOfJumps = 0;
        int sum = 0;
        HashSet<char[]> visited = new HashSet<>();
        List<String[]> jumps = new ArrayList<>();
        for (int i = 0; i < j; i++) {
            jumps.add(in.nextLine().split(" "));
        }
        boolean hasEscaped = false;
        boolean isCaught = false;
        while (!hasEscaped && !isCaught) {
            for (String[] jump : jumps) {
                char[] currentPosition = {(char) row, (char) col};
                int dRow = Integer.parseInt(jump[0]);
                int dCol = Integer.parseInt(jump[1]);
                int nextRow = row + dRow;
                int nextCol = col + dCol;
                sum += getValue(row, col, cols);
                numberOfJumps++;
                if (nextCol < 0 || nextCol > cols - 1 || nextRow < 0 || nextRow > rows - 1) {
                    hasEscaped = true;
                    break;

                }
                if (visited.contains(currentPosition)) {
                    isCaught = true;
                    break;
                }
                visited.add(currentPosition);

                row = nextRow;
                col = nextCol;
            }
        }
        if (hasEscaped) {
            System.out.println("escaped " + sum);
        } else {
            System.out.println("caught " + numberOfJumps);
        }


    }

    public static int getValue(int row, int col, int cols) {
        return row * cols + 1 + col;
    }
}
