package telerik;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {

    }

    class Solution {
        public int calPoints(String[] ops) {
            int sum = 0;
            Stack<Integer> stack = new Stack<>();

            for (String op : ops) {
                switch (op) {
                    case "+":
                        int temp = stack.pop();
                        int tempSum = temp + stack.peek();
                        stack.push(temp);
                        stack.push(tempSum);
                        break;
                    case "D":
                        stack.push(2 * stack.peek());
                        break;
                    case "C":
                        stack.pop();
                        break;
                    default:
                        stack.push(Integer.parseInt(op));
                        break;
                }
            }
            while (!stack.isEmpty()){
                sum+=stack.pop();
            }

            return sum;
        }
    }
}
