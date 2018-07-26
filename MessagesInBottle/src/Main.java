import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void fakeInput() {
        String args = "1122\n" +
                "A1B12C11D2";

        System.setIn(new ByteArrayInputStream(args.getBytes()));
    }

    public static Map<String,Character> cyphers;
    public static List<String> outputResults;
    private static int counter;

    public static void main(String[] args) throws IOException {
        fakeInput();
        cyphers = new TreeMap<>();
        outputResults = new ArrayList<>();
        counter = 0;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String secretMessage = reader.readLine();
        String inputCypher = reader.readLine();

        Pattern pattern = Pattern.compile("[A-Z]\\d+");
        Matcher matcher = pattern.matcher(inputCypher);

        while (matcher.find()) {
            String current = matcher.group();
            cyphers.put(current.substring(1),current.charAt(0));
        }

        decode(secretMessage,"");
        System.out.println(counter);
        outputResults.forEach(System.out::println);
    }

    public static void decode(String secretMessage,String result) {
        if(secretMessage.length() == 0) {
            counter++;
            outputResults.add(result);
            return;
        }

        for (String code : cyphers.keySet()){
            if(secretMessage.startsWith(code)) {
                decode(secretMessage.substring(code.length()),result + cyphers.get(code));
            }
        }
    }
}