package Package1;


import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int flag = 0;
        int sum=0;
        int rows = in.nextInt();
        int cols = in.nextInt();
        int row=0;
        int col=0;
        int dCol =1;
        int dRow =1;
        int endCol = isEven(rows-1)? 0 : cols-1;
        while(true){



            int nextRow = row + dRow;
            int nextCol = col +dCol;
            if(nextCol == cols || nextCol == 0) {
                dCol *= -1;
                nextRow++;
            }
            dRow*=-1;
            sum+=getValue(row, col);
            row =nextRow;
            col=nextCol;
            if(nextRow>rows && nextCol==endCol){
                break;

            }

            }
        System.out.println(sum);
        }



    public static int getValue(int n, int m){
        return 1+(3*n)+(3*m);
    }
    public static boolean isAtTheEnd(int row, int col, int endCol, int rows){
        if((row == rows-1) && col == endCol){
            return true;
        }
        return false;
    }
    public static boolean isEven(int i){
        if((i%2)==0){
            return true;
        }
        return false;
    }

}