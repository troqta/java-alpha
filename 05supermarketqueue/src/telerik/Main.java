package telerik;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static void fakeInput() {
        String input = "Append Nakov\n" +
                "Serve 1\n" +
                "Find Ina\n" +
                "Append Mike\n" +
                "Insert 0 Peter\n" +
                "Append Penka\n" +
                "Insert 3 Doncho\n" +
                "Serve 5\n" +
                "Append Asya\n" +
                "Insert 4 Nakov\n" +
                "Append Nakov\n" +
                "Find Asya\n" +
                "Find Nakov\n" +
                "Serve 3\n" +
                "Find Peter\n" +
                "Serve 4\n" +
                "Find Nakov\n" +
                "Insert 1 Ina\n" +
                "End";

        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    static LinkedList<String> queue = new LinkedList<>();
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) {
        fakeInput();
       // Scanner in = new Scanner(System.in);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] command = in.readLine().split(" ");

            while (!command[0].equals("End")) {
                switch (command[0]) {
                    case "Append":
                        appendToQueue(command[1]);
                        break;

                    case "Insert":
                        insertToQueue(Integer.valueOf(command[1]), command[2]);
                        break;

                    case "Find":
                        findCount(command[1]);
                        break;

                    case "Serve":
                        serve(Integer.parseInt(command[1]));
                        break;

                }
                command = in.readLine().split(" ");
            }
        }
         catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(output);

    }

    private static void serve(int count) {
        if (count > queue.size()) {
            output.append("Error\n");
            return;
        }
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            list.add(queue.pollFirst());
        }
        list.forEach(x -> output.append(x).append(" "));
        output.append("\n");
    }

    private static void findCount(String name) {
        if (!queue.contains(name)) {
            output.append(0);
        } else {
            output.append(queue.stream()
                    .filter(x -> x.equals(name))
                    .count());
        }
        output.append("\n");
    }

    private static void insertToQueue(int index, String name) {

        if (index > queue.size() || index < 0) {
            output.append("Error");
            output.append("\n");
            return;
        }

        queue.add(index, name);
        output.append("OK");
        output.append("\n");
    }

    private static void appendToQueue(String name) {
        queue.addLast(name);
        output.append("OK");
        output.append("\n");
    }
}
