package bruteforce;

import java.util.Arrays;

/**
 * @author Lucas Su
 * @create 2023-08-15-19:08
 *
 * topcoder 80%
 * 6 min
 */
public class SquareMaking {
    public static int getMinimalPrice(int a, int b, int c, int d){
        int[]arr = new int[]{a,b,c,d};
        Arrays.sort(arr);
        int minSum = 4000000;
        for (int i = arr[0]; i <= arr[3] ; i++) {
            int curr = Math.abs(i-arr[0]) + Math.abs(i-arr[1]) + Math.abs(i-arr[2]) + Math.abs(i-arr[3]);
            if(curr < minSum) minSum = curr;
        }
        return minSum;
    }

    public static void main(String[] args) {
        System.out.println(getMinimalPrice(5,6,5,5));
        System.out.println(getMinimalPrice(4,1,5,4));
        System.out.println(getMinimalPrice(2000,2000,2000,2000));
        System.out.println(getMinimalPrice(705451,
                751563,
                608515,
                994713
        ));
    }
}
