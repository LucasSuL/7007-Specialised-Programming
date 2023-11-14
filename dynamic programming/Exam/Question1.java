package DP;

import java.util.Arrays;

/**
 * @author Lucas Su
 * @create 2023-09-13-13:58
 */
public class Question1 {

    public int minSteps(String word1, String word2) {

        int[][] memo = new int[word1.length() + 1][word2.length() + 1]; // a dp array to memorise calculated results.

        for (int i = 0; i < memo.length; i++) { // initialize array with unreachable minimum numbers (-1) which are ready to be replaced.
            Arrays.fill(memo[i], -1);
        }
        return minStepsRecursive(word1, word2, 0, 0, memo);
    }

    private int minStepsRecursive(String word1, String word2, int i, int j, int[][] memo) {
        // base condition: if we reach the end of a string, return the other string's remaining length.
        if (i == word1.length()) return word2.length() - j;
        if (j == word2.length()) return word1.length() - i;

        if (memo[i][j] != -1) return memo[i][j]; // calculated before, just return the result to save time.

        // same character --> just recursive call with both moving to the next character.
        if (word1.charAt(i) == word2.charAt(j)) memo[i][j] = minStepsRecursive(word1, word2, i + 1, j + 1, memo);
        else {
            int deleteFromWord1 = minStepsRecursive(word1, word2, i + 1, j, memo) + 1;
            int deleteFromWord2 = minStepsRecursive(word1, word2, i, j + 1, memo) + 1;
            memo[i][j] = Math.min(deleteFromWord1, deleteFromWord2);
        }
        return memo[i][j];
    }


    public static void main(String[] args) {
        Question1 q1 = new Question1();
        System.out.println(q1.minSteps("sea", "eat")); // Returns: 2
        System.out.println(q1.minSteps("leetcode", "etco")); // Returns: 4
        System.out.println(q1.minSteps("pp", "itm")); // Returns: 5
        System.out.println(q1.minSteps("nw", "for")); // Returns: 5
        System.out.println(q1.minSteps("bbs", "vjkc")); // Returns: 7
        System.out.println(q1.minSteps("ueg", "samq"));
        System.out.println(q1.minSteps("dqdzw", "fzcmop"));
        System.out.println(q1.minSteps("witim", "gkyvfy"));
        System.out.println(q1.minSteps("balhqtzfka", "rxfdithj"));
        System.out.println(q1.minSteps("apsuummteb", "nodfftho"));
        System.out.println(q1.minSteps("luisgmhiihskdpj", "fdthfuczbanhqswfpw"));
        System.out.println(q1.minSteps("jzvjinkpvlzfjzk", "jpxsbpupirervvqktm"));
        System.out.println(q1.minSteps("zvrywlucuzvbsaezeaxa", "cwzpnxqiregjztcznereui"));
        System.out.println(q1.minSteps("chroblesmqczebeuqixm", "rnzdqrxnbshuauxixkxwsg"));
        System.out.println(q1.minSteps("xsugyizivpfyywnldyejjcvpv", "tqhkdhxbeobrdmzwlyltuyxau"));
        System.out.println(q1.minSteps("rcdzsvfldsyqjbqmtoshnsxtv", "vzmcicdcyoymecjwwcvkvbihm"));

    }
}
