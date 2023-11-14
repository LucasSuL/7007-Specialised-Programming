package DP;

/**
 * @author Lucas Su
 * @create 2023-09-01-19:40
 * https://www.bilibili.com/video/BV1AB4y1w7eT/?spm_id_from=333.337.search-card.all.click&vd_source=301d1af1e50acdef3f3e805c66d2b654
 */
public class T_longest_sub_sequence {
    //DP
    int[] dp;

    public int longest(int[] nums) {

        dp = new int[nums.length];

        int res = 0;
        int curr = 0;
        for (int i = 0; i < nums.length; i++) {
            curr = longestFrom(nums, i);
            if (curr > res) res = curr;
        }
        return res;
    }

    private int longestFrom(int[] nums, int i) {
        if (i == nums.length - 1) return 1;

        if (dp[i] != 0) return dp[i];

        int res = 0;
        int longestFromJ = 0;

        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] > nums[i]) {
                res = longestFrom(nums, j);
                if (res > longestFromJ) longestFromJ = res;
            }
        }
        dp[i] = longestFromJ + 1;
        return longestFromJ + 1;
    }

    public static void main(String[] args) {
        int res = new T_longest_sub_sequence().longest(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6});
        System.out.println(res);
    }
}
