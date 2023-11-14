package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lucas Su
 * @create 2023-08-30-13:48
 */
public class Question1 {
    public static int minSquareGems(int n) {
//        // find all the possible gem bases.
//        List <Integer>list = new ArrayList<>();
//        for (int i = 1; i < Math.sqrt(n); i++) {
//            list.add(i);
//        }
//        System.out.println(list);

        // initialize dp array with base cases.
        // dp also prevent from stackoverflow since for this specific question there might be lots of recalculation
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = i; // initialize with worst case, we use all the 2 ^ 0 = 1, which we basically need 'n' of it.

            for (int j = 1; j * j <= i; j++) { // j*j is the possible answer. we try to go through all the possible j*j smaller than i
                int currCount = 1 + dp[i - j * j];
                if (currCount < dp[i])
                    dp[i] = currCount; //find the minimum number (best case) of former best number and new best number (iteration)
            }
        }
        return dp[n];
    }


    public static void main(String[] args) {
        System.out.println(minSquareGems(12)); // Returns: 3
        System.out.println(minSquareGems(13)); // Returns: 2
        System.out.println(minSquareGems(9999)); // Returns: 4
        System.out.println(minSquareGems(169)); // Returns: 1
        System.out.println(minSquareGems(135)); // Returns: 4
        System.out.println(minSquareGems(30));
        System.out.println(minSquareGems(28));
        System.out.println(minSquareGems(30000));
        System.out.println(minSquareGems(70000));
        System.out.println(minSquareGems(100000));
        System.out.println(minSquareGems(125));
        System.out.println(minSquareGems(79));
        System.out.println(minSquareGems(50));
        System.out.println(minSquareGems(75));
        System.out.println(minSquareGems(785));
        System.out.println(minSquareGems(9800));
    }
}
