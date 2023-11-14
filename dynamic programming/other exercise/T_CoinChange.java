package DP;

import java.util.Arrays;

/**
 * @author Lucas Su
 * @create 2023-09-06-15:58
 */
public class T_CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, 99999);
        dp[0] = 0;

        int len = coins.length;
        for (int i = coins[0]; i < amount + 1; i++) {

            for (int j = 0; j < len; j++) {
                if (i >= coins[j])
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }
        if (dp[amount] != 99999) return dp[amount];
        else return -1;
    }

    public static void main(String[] args) {
        System.out.println(new T_CoinChange().coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(new T_CoinChange().coinChange(new int[]{2}, 3));
        System.out.println(new T_CoinChange().coinChange(new int[]{1,2}, 2));
    }

}
