package bruteforce;

/**
 * @author Lucas Su
 * @create 2023-08-01-15:09
 *
 * //topcoder 80%
 * //15min
 * //卡住过。
 */
public class CompetitionStatistics {
    public static int consecutiveGrowth(int[] ratingChanges) {
        int longestLength = 0;
        int currentLength = 0;
        for (int i = 0; i < ratingChanges.length; i++) {
            if (ratingChanges[i] > 0) {
                currentLength++;
            }else {
                longestLength = Math.max(longestLength,currentLength);
                currentLength=0;
            }

            if(i==ratingChanges.length-1){
                longestLength = Math.max(longestLength,currentLength);
            }
        }
        return longestLength;
    }

    public static void main(String[] args) {
        int[] arr =
                {30, 5, -5, 3, 3, 1}
;
        System.out.println(consecutiveGrowth(arr));


    }
}
