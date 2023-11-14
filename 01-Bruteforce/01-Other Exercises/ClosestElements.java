package bruteforce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Lucas Su
 * @create 2023-08-09-20:16
 * <p>
 * An integer a is closer to x than an integer b if:
 * <p>
 * |a - x| < |b - x|, or
 * |a - x| == |b - x| and a < b
 */
public class ClosestElements {
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List <Integer> resList  = new ArrayList<>();
        int start = 0;
        int end = arr.length - 1;

        while (end - start >= k) {
            if (Math.abs(arr[start] - x) > Math.abs(arr[end] - x)) {
                start++;
            }else{
                end--;
            }
        }

        for (int i = start; i <= end; i++) {
            resList .add(arr[i]);
        }
        return resList;
    }

    public static void main(String[] args) {

        int[] arr =
                {1, 2, 3, 4, 5};
        int k =
                4;
        int x =
                3;
        List<Integer> list = null;
        list = findClosestElements(arr, k, x);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
