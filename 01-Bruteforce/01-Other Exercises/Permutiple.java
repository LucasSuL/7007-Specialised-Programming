package bruteforce;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lucas Su
 * @create 2023-08-16-12:48
 *
 * topcoder
 * 15min-- with GPT help with permutation
 */
public class Permutiple {
    public static List<String> getAllPermutations(String input) {
        List<String> result = new ArrayList<>();
        generatePermutations("", input, result);
        return result;
    }

    private static void generatePermutations(String prefix, String remaining, List<String> result) {
        int n = remaining.length();
        if (n == 0) {
            result.add(prefix);
            return;
        }

        for (int i = 0; i < n; i++) {
            generatePermutations(
                    prefix + remaining.charAt(i),
                    remaining.substring(0, i) + remaining.substring(i + 1),
                    result
            );
        }
    }

    public static String isPossible(int x) {
        String num = Integer.toString(x);
        List<String> permutations = getAllPermutations(num);

        for (int i = 0; i < permutations.size(); i++) {
//            System.out.println(permutations.get(i));
            int number = Integer.parseInt(permutations.get(i));
            if (number > x && number % x == 0) {
                return "POSSIBLE";
            }
        }
        return "IMPOSSIBLE";
    }

    public static void main(String[] args) {
        System.out.println(isPossible(142857));
        System.out.println(isPossible(14));
        System.out.println(isPossible(1035));
        System.out.println(isPossible(1000000));
        System.out.println(isPossible(100035));
        System.out.println(isPossible(4));
    }
}
