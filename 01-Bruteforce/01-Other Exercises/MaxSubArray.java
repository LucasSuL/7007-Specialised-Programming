package bruteforce;

import java.util.Arrays;

/**
 * @author Lucas Su
 * @create 2023-08-12-23:37
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
//        if(nums.length==1){
//            return nums[0];
//        }
//
//        int maxSum = -99999;
//        for (int i = 1; i <= nums.length; i++) {
//            int len = i;
//
//            int tmpMax = -99999;
//            for (int j = 0; j < nums.length - len + 1; j++) {
//
//                int tmpSum = 0;
//                for (int k = j; k < j + len; k++) {
//                    tmpSum += nums[k];
//                }
//                if (tmpSum > tmpMax) {
//                    tmpMax = tmpSum;
//                }
//            }
//            if (tmpMax > maxSum) {
//                maxSum = tmpMax;
//            }
//        }
//        return maxSum;

        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];

            if (currentSum > maxSum) {
                maxSum = currentSum;
            }

            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return maxSum;
    }

    public boolean isPalindrome(int x) {
        String str = Integer.toString(x);
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public int maxProfit(int[] prices) {
        int currMin = 10001;
        int diff = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < currMin)
                currMin = prices[i];

            if ((prices[i] - currMin) > diff)
                diff = prices[i] - currMin;
        }
        return diff;
    }



    public static void main(String[] args) {
//        System.out.println(new MaxSubArray().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
//        System.out.println(new MaxSubArray().maxSubArray(new int[]{4, -1, 2, 1, -5, 4}));
//        System.out.println(new MaxSubArray().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(new MaxSubArray().maxProfit(new int[]{4,7,1,2}));
    }
}
