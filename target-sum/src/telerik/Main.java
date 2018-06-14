package telerik;

public class Main {

    public static void main(String[] args) {
        int[] array = {1, 1, 1, 1, 1};
        System.out.println(new Solution().findTargetSumWays(array, 3));
    }

    static class Solution {
        public int findTargetSumWays(int[] nums, int S) {
            int count = solve(nums, 3, 0);
            return count;
        }

        private int solve(int[] nums, int i, int currentCount) {
            for (int num : nums) {

            }
            return currentCount;
        }
    }
}
