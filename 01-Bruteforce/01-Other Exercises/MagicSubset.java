package bruteforce;

/**
 * @author Lucas Su
 * @create 2023-08-01-14:54
 * //topcoder 85%
 * //15 min
 */
public class MagicSubset {
    public static int findBest(int[] values) {
        if (values.length == 1) {
            if (values[0] >= 0) return 0;
            else return -values[0];
        }

        int positive = 0;
        int negative = 0;
        for (int i = 1; i < values.length; i++) {
            if (values[i] > 0) {
                positive += values[i];
            } else {
                negative += values[i];
            }
        }
        return Math.max(positive, -(negative + values[0]));

    }

    public static void main(String[] args) {
        int arr[] =
                {-3,1,-4,1,5,-9,2,6,-5,3,5}

                ;
        System.out.println(findBest(arr));
    }
}
