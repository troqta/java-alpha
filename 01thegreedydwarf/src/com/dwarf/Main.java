package com.dwarf;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class Main {
    public static void fakeInput() {
        String input = "4 3\n" +
                "3 2 4\n" +
                "2 0 3\n" +
                "1 1 5\n" +
                "2 2 5";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    public static void main(String[] args) {
        fakeInput();

        Scanner in = new Scanner(System.in);
        int rows = in.nextInt();
        int cols = in.nextInt();
        in.nextLine();

        int coins = 0;

        String[][] inputArray = new String[rows][cols];


        for (int i = 0; i < rows; i++) {
            inputArray[i] = in.nextLine().split(" ");
        }

        int row = 0;
        int col = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (Integer.parseInt(inputArray[i][j]) == 0) {
                    row = i;
                    col = j;
                    int startRow = i;
                    int startCol = j;
                    break;
                }
            }
        }

        String[] directionString = bestDirection(row, col, inputArray).split(",");
        while (true) {
            directionString = bestDirection(row, col, inputArray).split(",");
            if (directionString[0].equals("")) {
                break;
            }
            int tempNum = Integer.parseInt(inputArray[row][col]);
            int rowD = Integer.parseInt(directionString[0]);
            int colD = Integer.parseInt(directionString[1]);
            if (Integer.parseInt(inputArray[row][col]) == 0) {
                row += rowD;
                col += colD;
                continue;
            } else {

                coins += 1;
                tempNum--;
                inputArray[row][col] = Integer.toString(tempNum);
                row = row + rowD;
                col = col + colD;
            }


        }
        System.out.println(coins);
    }

    public static boolean surroundedBy0(int row, int col, String[][] matrix) {
        if ((!isOutOfBounds(row + 1, col, matrix) && Integer.parseInt(matrix[row + 1][col]) == 0) &&
                (!isOutOfBounds(row - 1, col, matrix) && Integer.parseInt(matrix[row - 1][col]) == 0) &&
                (!isOutOfBounds(row, col + 1, matrix) && Integer.parseInt(matrix[row][col + 1]) == 0) &&
                (!isOutOfBounds(row, col - 1, matrix) && Integer.parseInt(matrix[row][col - 1]) == 0)) {
            return true;
        }
        return false;
    }

    public static boolean isOutOfBounds(int rows, int cols, String[][] matrix) {
        if ((rows < matrix.length && rows > 0) && (cols < matrix[rows - 1].length && cols > 0)) {
            return false;
        }
        return true;
    }

    public static String bestDirection(int row, int col, String[][] matrix) {
        String direction = "";
        int max = 0;


        if (!isOutOfBounds(row, col + 1, matrix)) {
            if (Integer.parseInt(matrix[row][col + 1]) >= max && Integer.parseInt(matrix[row][col + 1]) != 0) {
                max = Integer.parseInt(matrix[row][col + 1]);
                direction = "0" + "," + "+1";
            }

        }
        if (!isOutOfBounds(row, col - 1, matrix)) {
            if (Integer.parseInt(matrix[row][col - 1]) >= max && Integer.parseInt(matrix[row][col - 1]) != 0) {
                max = Integer.parseInt(matrix[row][col - 1]);
                direction = "0" + "," + "-1";
            }
        }
        if (!isOutOfBounds(row + 1, col, matrix)) {
            if (Integer.parseInt(matrix[row + 1][col]) >= max && Integer.parseInt(matrix[row + 1][col]) != 0) {
                max = Integer.parseInt(matrix[row + 1][col]);
                direction = "+1" + "," + "0";
            }
        }
        if (!isOutOfBounds(row - 1, col, matrix)) {
            if (Integer.parseInt(matrix[row - 1][col]) >= max && Integer.parseInt(matrix[row - 1][col]) != 0) {
                max = Integer.parseInt(matrix[row - 1][col]);
                direction = "-1" + "," + "0";
            }
        }

        return direction;
    }

}
