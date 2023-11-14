package DP;

/**
 * @author Lucas Su
 * @create 2023-09-13-13:58
 */
public class Question2 {
//    int[] memo;

    public int maxScore(int[] nums, int[] mul) {
        int n = nums.length;
        int[][] dp = new int[n][n]; // Create a 2D DP array to store results.
        return helper(nums, mul, 0, n - 1, 0, dp);
    }

    private int helper(int[] nums, int[] mul, int l, int r, int mulPointer, int[][] dp) {
        if (mulPointer == mul.length) return 0; // Base case: we have processed all multipliers.
        if (dp[l][r] != 0) return dp[l][r]; // If the result is already computed, return it.

        int chooseLeft = nums[l] * mul[mulPointer] + helper(nums, mul, l + 1, r, mulPointer + 1, dp);
        int chooseRight = nums[r] * mul[mulPointer] + helper(nums, mul, l, r - 1, mulPointer + 1, dp);

        // Store the result in the DP array.
        dp[l][r] = Math.max(chooseLeft, chooseRight);

        return dp[l][r];
    }


    public static void main(String[] args) {
        Question2 q2 = new Question2();
        System.out.println(q2.maxScore(new int[]{1, 2, 3}, new int[]{3, 2, 1})); // Returns: 14
        System.out.println(q2.maxScore(new int[]{-5, -3, -3, -2, 7, 1}, new int[]{-10, -5, 3, 4, 6})); // Returns: 102
        System.out.println(q2.maxScore(new int[]{-688, -977, -729}, new int[]{-160, -312, -983})); // Returns: 1297919
        System.out.println(q2.maxScore(new int[]{985, -682, 839, -81, -206, -905, 668, 577, 999, 929, -763, -852, 631, 118, 990, 1, -251, -354, 57, -491, -725, -786, 514, -968, 142}, new int[]{-771, -131, 290, 796, 906, -751, -355, 889, -981, 692, 642, -543, -270, -372, -778})); // Returns: 3944466
        System.out.println(q2.maxScore(new int[]{940, 64, 733, 177, -181, -397, -728, -829, -499, 984}, new int[]{-623, -699, 666, -295}));
        System.out.println(q2.maxScore(new int[]{-14, 487, 193, 950, 817, 281, 795, -799, 726, 65, 817, -127, -498, 231, 620, -667, 414}, new int[]{-410, 768, 277, -515, 119, 92, 331, -598, -233, 895, 743, -726, 98, -166, -770, 651, -532}));
        System.out.println(q2.maxScore(new int[]{651, 610}, new int[]{941, 479}));
        System.out.println(q2.maxScore(new int[]{18, 778, -544, 224, 153, 755, -743, -97, 837, -699, 728, 110, -84, 130, -2, -448, 755, 866, 200, 996, -124}, new int[]{-180, 645, 953, 260, -627, 133, -77, -374, -597, 912, -296, -983, -712, 430, 535, 562, -687}));
        System.out.println(q2.maxScore(new int[]{-327, -895, 578, 448, -681, 41, -912, 101, 794, -308, -514, -777}, new int[]{245, -527, 55, 337}));
        System.out.println(q2.maxScore(new int[]{667, 407}, new int[]{562}));
        System.out.println(q2.maxScore(new int[]{-433, 259, 321, 421, 845, -422, -531, -851, -925, 797, 139, -750, -981, -690, 670, -167, -165, -571, 611, -321, -537, -431, -65, 601}, new int[]{-460, -396, -730, 801, 805, 497, -754, -354, -177, 279, -612, -718, 255, -189}));
        System.out.println(q2.maxScore(new int[]{-354, -630, -876, 798, -344, 301, -164, 132, -917, 248, -646, -412, 331, -456, -975, 893, 435, -733, 562, 670, 677, -204, -935, 845, 625}, new int[]{-300, 936, -57, -419, 432, 506, -458, -341, -218, 165, -367, -71, -841, 737, -47, 407, 41}));
        System.out.println(q2.maxScore(new int[]{261}, new int[]{-245}));
        System.out.println(q2.maxScore(new int[]{156, -276, 637, 123, -319, -18, 653, 104, -766, -993}, new int[]{356, 417, 405, -252, 867, -96, 507}));
        System.out.println(q2.maxScore(new int[]{371, -632, -573, -749, 742, 517, -285, -991, 133, 914, 474, -925, 491, 753, -343, 378, 431, -566, 734, -952, 139}, new int[]{-311, -653, 700, 422, 528, 685, 460, 6, -458, 0, 992}));
        System.out.println(q2.maxScore(new int[]{-728, -701, 913, 105, 84, -507, -880, -434}, new int[]{-460, -605, -942}));
        System.out.println(q2.maxScore(new int[]{-717}, new int[]{688}));
        System.out.println(q2.maxScore(new int[]{-293, -853, -600, 859, 959, -911, 606, -738, -310, -234}, new int[]{672, 539, 928, -635}));
    }

}
