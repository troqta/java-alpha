package com.TestBitConvert;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void fakeInput(){
        String input  = "2,1,0,2";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    public static void main(String[] args) {
        fakeInput();
        Scanner in = new Scanner(System.in);

        String[] numbers = in.nextLine().split(",");
        ArrayList<String> binaryString = new ArrayList<>();
        ArrayList<String> binaryNumbers = new ArrayList<>();
        int evenFlag=1;
        String result="";

        for (String number:
             numbers) {
            binaryString.add(Integer.toBinaryString(Integer.parseInt(number)));

        }
        
        for (String number:
             binaryString) {
            while(number.length()<8){
                number = "0"+number;
            }
            binaryNumbers.add(number);
        }
        for(String number : binaryNumbers){
            for (int i = 0; i < number.length(); i++) {
                if(evenFlag==1){
                    if(!isEven(i)){
                        result+=number.charAt(i);
                    }
                }
                if(evenFlag!=1){
                    if(isEven(i)){
                        result+=number.charAt(i);
                    }
                }


            }
            evenFlag*=-1;
        }
        System.out.println(result);
//        binaryNumbers.forEach(System.out::println);
    }
    public static boolean isEven(int i){
        if((i & 1)==0){
            return true;
        }
        return false;
    }
}
