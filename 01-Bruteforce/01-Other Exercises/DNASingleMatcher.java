package bruteforce;

/**
 * @author Lucas Su
 * @create 2023-08-14-15:55
 */
public class DNASingleMatcher {
    static int longestMatch(String sequence1, String sequence2) {
        int max = 0;
        for (int i = 0; i < sequence1.length(); i++) {
            int currMax = 0;
            int start = i;
            for (int j = 0; j < sequence2.length(); j++) {
                if (start < sequence1.length() && sequence1.charAt(start) == sequence2.charAt(j)) {
                    currMax++;
                    start++;
                }
            }
            max = Math.max(max, currMax);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestMatch("ACGTACGTACGTACGTACGTACGTACGTACGTACGTACGTACGTACGTAC", "GTACGTACGTACGTACGTACGTACGTACGTACGTACGTACGTACGTACGT"));
    }
}
