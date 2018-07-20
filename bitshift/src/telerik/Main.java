package telerik;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    static void fakeInput() {
        String input = "@@@xx@*\n" +
                "1 -1 -1 4";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    public static void main(String[] args) {
        fakeInput();
        Scanner in = new Scanner(System.in);
        int index = 0;
        int souls = 0;
        int food = 0;
        int deadlocks = 0;
        int jumps = 0;
        boolean isDeadLocked = false;
        StringBuilder input = new StringBuilder(in.nextLine());
        List<Integer> moves = Arrays.stream(in.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (int move : moves) {
            jumps++;


            if (input.charAt(index) == '@') {
                souls++;
                input.setCharAt(index, '0');
            }
            if (input.charAt(index) == '*') {
                food++;
                input.setCharAt(index, '0');
            }
            if (input.charAt(index) == 'x') {
                if (isEven(index) && souls > 0) {
                    souls--;
                    input.setCharAt(index, '@');
                    deadlocks++;
                } else if (!isEven(index) && food > 0) {
                    food--;
                    input.setCharAt(index, '*');
                    deadlocks++;
                } else {
                    isDeadLocked = true;
                    break;
                }

            }
            if (index + move > input.length() - 1) {
                index = input.length() - 1 - move;
            } else if (index + move < 0) {
                index = input.length() - 1 - index + move;
            } else {
                index += move;
            }
        }
        if (isDeadLocked) {
            System.out.println("You are deadlocked, you greedy kitty!");
            System.out.println("Jumps before deadlock: " + jumps);
        } else {
            System.out.println("Coder souls collected: " + souls);
            System.out.println("Food collected: " + food);
            System.out.println("Deadlocks: " + deadlocks);
        }
    }

    static boolean isEven(int n) {
        return n % 2 == 0;
    }

}
