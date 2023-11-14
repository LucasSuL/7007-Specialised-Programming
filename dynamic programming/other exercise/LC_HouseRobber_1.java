package DP;

/**
 * @author Lucas Su
 * @create 2023-09-12-15:12
 * https://leetcode.com/problems/house-robber/
 * <p>
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 *
 *
 * Find recursive relation
 * Recursive (top-down)
 * Recursive + memo (top-down)
 * Iterative + memo (bottom-up)
 * Iterative + N variables (bottom-up)
 */
public class LC_HouseRobber_1 {

//    int[] memo;

    public int rob(int[] nums) {
        if(nums.length==0) return 0;

        int [] dp = new int [nums.length+1];
        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i+1] = Math.max(dp[i],dp[i-1]+nums[i]);
        }
        return dp[nums.length];

//        memo = new int[nums.length];
//        Arrays.fill(memo, -1);
//        return rob(nums, nums.length - 1);
//    }
//
//    private int rob(int[] nums, int i) {
//        /**
//         * robber at house i, if rob i means he skipped i-1, or skip i and means he robbed i-2 or i-3.
//         */
//        if (i < 0) return 0;
//
//        if(memo[i] != -1) return memo[i];
//        memo[i] = Math.max(nums[i] + rob(nums, i - 2), rob(nums, i - 1));
//
//        return memo[i];
    }

    public static void main(String[] args) {
        System.out.println(new LC_HouseRobber_1().rob(new int[]{1,2,3,1})); //4
        System.out.println(new LC_HouseRobber_1().rob(new int[]{2,7,9,3,1}));
        System.out.println(new LC_HouseRobber_1().rob(new int[]{2,1,1,2}));
        System.out.println(new LC_HouseRobber_1().rob(new int[]{104,209,137,52,158,67,213,86,141,110,151,127,238,147,169,138,240,185,246,225,147,203,83,83,131,227,54,78,165,180,214,151,111,161,233,147,124,143}));
    }


}
