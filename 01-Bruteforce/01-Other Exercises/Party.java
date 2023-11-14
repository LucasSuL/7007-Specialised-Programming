package bruteforce;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Lucas Su
 * @create 2023-08-15-19:14
 *
 * topcoder 80%
 * 60 min...
 */
public class Party {
    public static double averageNames(int n, int[] personA, int[] personB) {
        Set<Integer>[] count = new HashSet[n];
        for (int i = 0; i < count.length; i++) {
            count[i] = new HashSet<>();
        }

        for (int i = 0; i < personA.length; i++) {
            count[personA[i]].add(personB[i]);
            count[personB[i]].add(personA[i]);
            count[personA[i]].addAll(count[personB[i]]);
            count[personB[i]].addAll(count[personA[i]]);
        }

        int sum = 0;
        for (int i = 0; i < count.length; i++) {
            Set<Integer> set = count[i];
            set.remove(i);
            sum += count[i].size();
        }

        return (double) sum / n;
    }

    public static void main(String[] args) {
        System.out.println(averageNames(4, new int[]{0,1,2}
                , new int[]{1,2,3}
        ));
        System.out.println(averageNames(25, new int[]{14, 14, 16, 4, 14, 16, 2, 16, 8, 15, 17, 17, 3, 3, 19, 17, 20, 4, 24, 8}
                , new int[]{16, 2, 23, 16, 11, 8, 5, 19, 15, 20, 19, 18, 14, 12, 22, 9, 0, 7, 23, 10}
        ));
    }
}
