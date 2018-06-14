package telerik;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void fakeInput() {
        String input = "2\n" +
                "1:cups:Sugar\n" +
                "1.006:ls:Old milK\n" +
                "2\n" +
                "800:mls:old MILK\n" +
                "1.5:cups:sugar";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    public static void main(String[] args) {
        fakeInput();
        Scanner in = new Scanner(System.in);
        Map<String, String> unitsTable = new HashMap<>();


    }
}
