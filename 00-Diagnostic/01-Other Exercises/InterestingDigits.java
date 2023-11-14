package basic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lucas Su
 * @create 2023-07-26-13:47
 */
public class InterestingDigits {
    public int[] digits(int base) {
        List<Integer> integerList = new ArrayList<>();

        for (int i = 2; i < base; i++) {
            int mul = 0;
            int mulInBase = 0;
            boolean flag = true;
            while (flag && mulInBase < 1000) {
                String str = Integer.toString(mulInBase);
                char[] arr = str.toCharArray();
                int sum = 0;
                for (int i1 = 0; i1 < arr.length; i1++) {
                    sum += arr[i1] - '0';
                }
                if (sum % i != 0) {
                    flag = false;
                }
                mul += i;
                String newStr = Integer.toString(mul, base);
                mulInBase = Integer.parseInt(newStr);
            }

            if (flag) {
                integerList.add(i);
            }
        }

        int[] res = new int[integerList.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = integerList.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        InterestingDigits interestingDigits = new InterestingDigits();
        int[] arr = interestingDigits.digits(9);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
