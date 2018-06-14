package telerik;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        int[] input = {2, 1, 5, 6, 2, 3};
        System.out.println(new Solution().largestRectangleArea(input));

    }

    static class Solution {
        public int largestRectangleArea(int[] heights) {
            Stack<Integer> stack = new Stack<>();

            int i = 0;
            int best = 0;

            while (i < heights.length) {
                if (stack.empty() || heights[i] >= heights[stack.peek()]) {
                    stack.push(i);
                    i++;

                } else {

                    int end = i - 1;
                    int start = stack.pop();
                    int current = (end - start) * heights[end];
                    best = Math.max(best, current);
                }
            }
            return best;
        }
    }
}
