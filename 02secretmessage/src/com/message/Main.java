package com.message;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        String result=getSecretMessage(input, "", 1);

        System.out.println(result);
    }

    public static String getSecretMessage(String input, String result, int numberOfRepetitions){
        if(input.charAt(0)=='}' || input.length()==0){
            return result;
        }

        for (int i = 0; i < input.length(); i++) {
            if (Character.isLetter(input.charAt(i))) {

                for (int j = 0; j < numberOfRepetitions; j++) {
                    result += input.charAt(i);
                }
            }
            else if (Character.isDigit(input.charAt(i))) {
                if (input.charAt(i + 1) == '{') {

                    numberOfRepetitions= Integer.parseInt(String.valueOf(input.charAt(i)));
                    getSecretMessage(input.substring(i + 1), result, numberOfRepetitions);
                }
               else if (Character.isDigit(input.charAt(i + 1))) {
                    if (input.charAt(i + 2) == '{') {

                        numberOfRepetitions=Integer.parseInt(String.valueOf(input.charAt(i))+ String.valueOf(input.charAt(i+1)));
                        getSecretMessage(input.substring(i + 2), result, numberOfRepetitions);
                    }
                    else if (Character.isDigit(input.charAt(i + 2))) {

                            if (input.charAt(i + 2) == '{') {

                                numberOfRepetitions = Integer.parseInt(String.valueOf(input.charAt(i)) + String.valueOf(input.charAt(i + 1))+String.valueOf(input.charAt(i+2)));
                                getSecretMessage(input.substring(i + 2), result, numberOfRepetitions);
                            }



                    }
                }
            }
        }
        return result;

    }
}
