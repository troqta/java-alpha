package telerik;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void fakeInput() {
        String input = "Fun exam right";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    public static void main(String[] args) {
        fakeInput();
        Scanner in = new Scanner(System.in);
        List<String> words = Arrays.stream(in.nextLine()
                .split(" "))
                .collect(Collectors.toList());
        int end = words.size();
        int counter = 0;
        StringBuilder result = new StringBuilder();

        while (counter < end) {
            for (int i = 0; i < words.size(); i++) {
                if (!words.get(i).equals("")) {
                    result.append(words.get(i).charAt(words.get(i).length() - 1));
                    words.set(i, words.get(i).substring(0, words.get(i).length() - 1));
                } else {
                    counter++;
                    words.remove(i);
                }
            }
        }
        System.out.println(result);

    }
}
