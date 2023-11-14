package DP;

/**
 * @author Lucas Su
 * @create 2023-08-21-14:13
 *
 * https://community.topcoder.com/stat?c=problem_solution&cr=22689544&rd=13513&pm=10033
 */
public class PrimeSoccer {
    public static boolean isPrime(int p){
        if (p <= 1) return false;
        for (int i = 2; i < p; i++) if (p % i == 0) return false;
        return true;
    }

    static double prob(double prob) {
        int len = 2;
        double[] dp = new double[len+1]; //可能得分是：0 -- len
        dp[0] = 1;
        for (int i = 0; i < len; i++) {
            for (int j = len; j > 0; j--) {
                dp[j] = dp[j] * (1 - prob) + dp[j - 1] * prob;
            }
            dp[0] = dp[0] * (1 - prob);
        }
        double res = 0;
        for (int i = 0; i < len+1; i++) if (isPrime(i)) res += dp[i];
        return res;
    }

    public static double getProbability(int A, int B){
        double p1 = prob(A / 100.0);
        double p2 = prob(B / 100.0);
        return p1 + p2 - p1 * p2;
    }

    public static void main(String[] args) {
        System.out.println(getProbability(50,50));
    }
}
