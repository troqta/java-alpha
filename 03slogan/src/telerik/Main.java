package telerik;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void fakeInput() {
        String input = "2\n" +
                "test it here now\n" +
                "testhere\n" +
                "hello world my\n" +
                "hellomyworldhello";

        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    public static void main(String[] args) {
        fakeInput();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        in.nextLine();
        Boolean invalid = false;
        for (int i = 0; i < n; i++) {
            StringBuilder result = new StringBuilder();
            List<String> words = Arrays.stream(in.nextLine().split(" ")).collect(Collectors.toList());
            String slogan = in.nextLine();
            String word = "";

            for (int j = 0; j < slogan.length(); j++) {
                if (j == slogan.length() - 1 && !words.contains(word+slogan.charAt(j))) {
                    System.out.println("NOT VALID");
                    invalid = true;
                    break;
                }else {
                    if(!words.contains(word)){
                        word+=slogan.charAt(j);
                        if(j==slogan.length()-1){
                            testMethod(result, word, slogan.charAt(j));
                        }
                    }
                    else {
                        result.append(word).append(" ");
                        word = "";
                        word+=slogan.charAt(j);
                    }
                }
            }
            if (invalid) {
                invalid = false;
                continue;
            }
            System.out.println(result);
        }
    }
    public static void testMethod(StringBuilder result, String word, char letter){
        result.append(word).append(" ");
        word = "";
        word+=letter;
    }
}
