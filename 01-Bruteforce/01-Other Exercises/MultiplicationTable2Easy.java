package bruteforce;

/**
 * @author Lucas Su
 * @create 2023-08-14-23:29
 *
 * topcoder 75%
 * 25min
 */
public class MultiplicationTable2Easy {
    static String isGoodSet(int[] table, int[] t) {
        int len = (int) Math.sqrt(table.length);
        for (int i = 0; i < t.length; i++) {
            for (int j = 0 ; j < t.length; j++) {
                int index = t[i] * len + t[j];
                boolean flag = false;
                for (int k = 0; k < t.length; k++) {
                    if (t[k] == table[index]) {
                        flag = true;
                        break;
                    }
                }
                if(!flag){
                    return "Not good";
                }
            }
        }
        return "Good";
    }

    public static void main(String[] args) {
        System.out.println(isGoodSet(new int[]{1, 1, 2, 3,
                1, 0, 2, 3,
                3, 3, 0, 3,
                2, 2, 2, 0}, new int[]{1, 0}));
        System.out.println(isGoodSet(new int[]{1, 1, 2, 3,
                1, 0, 2, 3,
                3, 3, 0, 3,
                2, 2, 2, 0}, new int[]{2,3  }));
        System.out.println(isGoodSet(new int[]{1, 1, 2, 3,
                1, 0, 2, 3,
                3, 3, 0, 3,
                2, 2, 2, 0}, new int[]{0,1,2,3}));
        System.out.println(isGoodSet(new int[]{1, 1, 2, 3,
                1, 0, 2, 3,
                3, 3, 0, 3,
                2, 2, 2, 0}, new int[]{1}));
        System.out.println(isGoodSet(new int[]
                {2,2,2,2,2,2,
                        2,2,2,2,2,2,
                        2,2,2,2,2,2,
                        2,2,2,2,2,2,
                        2,2,2,2,2,2,
                        2,2,2,2,2,2}, new int[]{2,4,5}
        ));
        System.out.println(isGoodSet(new int[]
                {2,2,2,2,2,2,
                        2,2,2,2,2,2,
                        2,2,2,2,2,2,
                        2,2,2,2,2,2,
                        2,2,2,2,2,2,
                        2,2,2,2,2,2}, new int[]{0,1,3,4,5}

        ));
    }
}
