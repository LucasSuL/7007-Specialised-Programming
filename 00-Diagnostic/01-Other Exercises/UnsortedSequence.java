package basic;

import java.util.Arrays;

/**
 * @author Lucas Su
 * @create 2023-07-28-19:08
 */
public class UnsortedSequence {
    public int[] getUnsorted(int[] s) {
        Arrays.sort(s);
        int last = s[s.length - 1];
        for (int i = s.length - 1; i >= 0; i--) {
            int num = s[i];
            if (num != last) {
                int temp = s[i + 1];
                s[i + 1] = num;
                s[i] = temp;

                return s;
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        UnsortedSequence unsortedSequence = new UnsortedSequence();
        int[] arr =
                {1,1}
                ;
        int[]arr1 = unsortedSequence.getUnsorted(arr);
        if(arr1.length==0){
            System.out.println(0);
        }else {

            for (int i = 0; i < arr1.length; i++) {
                System.out.println(arr1[i]);
            }
        }
    }
}
