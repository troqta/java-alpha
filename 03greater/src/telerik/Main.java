package telerik;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    static void fakeInput() {
        String input = "2,4\n" +
                "1,2,3,4";

        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    public static void main(String[] args) {
        fakeInput();
        Scanner in = new Scanner(System.in);
        List<Integer> output = new ArrayList<>();
        List<Integer> bag1 = Arrays.stream(in.nextLine().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> bag2 = Arrays.stream(in.nextLine().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());


        for (int number : bag1) {
            int index = bag2.indexOf(number);
            if (number == bag2.get(bag2.size() - 1)) {
                output.add(-1);
                continue;
            }
            for (int i = index + 1; i < bag2.size(); i++) {
                if (bag2.get(i) > number) {
                    output.add(bag2.get(i));
                    break;
                }
                if (i == bag2.size() - 1) {
                    output.add(-1);
                    break;
                }

            }
        }

        System.out.println(output.stream().map(Object::toString)
                .collect(Collectors.joining(",")));
    }
}
