package telerik;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void fakeInput() {
        String input = "9\n" +
                "a1\n" +
                "b2\n" +
                "c3\n" +
                "d3\n" +
                "e2\n" +
                "f3\n" +
                "g2\n" +
                "h1\n" +
                "i2";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    public static void main(String[] args) {
        fakeInput();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        in.nextLine();
        HashSet<String> used = new HashSet<>();
        ArrayList<String> lines = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            lines.add(in.nextLine());
        }

        for (int i = 0; i < lines.size(); i++) {
            hdnl(used, lines, i, "");
        }


    }

    public static void hdnl(HashSet<String> used, ArrayList<String> lines, int index, String depth) {
        if(index+1 == lines.size()){
            if(!used.contains(lines.get(index))) {
                used.add(lines.get(index));
                System.out.println(depth + "</" + lines.get(index) + ">");
                System.out.println(depth + "</" + lines.get(index) + ">");
                return;
            }
        }



        for (int i = index; i < lines.size()-1; i++) {
            if (!used.contains(lines.get(i))) {
                used.add(lines.get(i));
                System.out.println(depth + "<" + lines.get(i) + ">");
                String current = lines.get(i);
                if(i+1<lines.size()) {
                    String next = lines.get(i + 1);

                    if ((int) current.charAt(1) < (int) next.charAt(1)) {

                        hdnl(used, lines, index, depth + " ");
                        System.out.println(depth + "</" + current + ">");
                    }
                    else if((int) current.charAt(1) == (int) next.charAt(1)){
                        System.out.println(depth + "</" + current + ">");
                        return;
                    }
                    else {
                        System.out.println(depth + "</" + current + ">");

                    }
                }
            }
        }


    }
}
