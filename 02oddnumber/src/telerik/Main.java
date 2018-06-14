package telerik;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void fakeInput() {
        String input = "9\n" +
                "-1\n" +
                "0\n" +
                "1\n" +
                "2\n" +
                "3\n" +
                "2\n" +
                "1\n" +
                "0\n" +
                "-1";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    public static void main(String[] args) {
        fakeInput();
        Scanner in = new Scanner(System.in);

        int numbers = in.nextInt();
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers; i++) {
            long number = in.nextLong();
            if (!map.containsKey(number)) {
                map.put(number, 1);
            } else {
                int value = map.get(number);
                value++;
                map.put(number, value);
            }
        }
        for (long key : map.keySet()) {
            int value = map.get(key);
            if (value % 2 != 0) {
                System.out.println(key);
                break;
            }
        }

    }
}
