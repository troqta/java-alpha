import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class Main {

    static void fakeInput() {
        String input = "koeko\n" +
                "kociokkociiev";

        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    public static void main(String[] args) {
        fakeInput();
        Scanner in = new Scanner(System.in);

        String word = in.nextLine();
        String bigString = in.nextLine();
        int index = 0;
        boolean isContained = false;
        for (Character c : word.toCharArray()) {
            for (int i = index; i < bigString.length(); i++) {
                if (!bigString.contains(c.toString())) {
                    System.out.println(false);
                    return;
                }
                if (c == bigString.charAt(i)) {
                    index = i;
                    isContained = true;
                    break;
                }
                if (i == bigString.length() - 1 && !isContained) {
                    System.out.println(false);
                    return;
                }
                isContained = false;
            }
        }
        System.out.println(true);
    }
}
