package recursion;

/**
 * @author Lucas Su
 * @create 2023-08-01-18:19
 */
public class DerivativeSequence {
    public static int[] derSeq(int[] a, int n) {
        if (n == 0)
            return a;
        else {
            int[] arr = new int[a.length - 1];
            for (int i = 0; i < a.length-1; i++) {
                arr[i] = a[i+1]-a[i];
            }
            return derSeq(arr,n-1);
        }
    }

    public static void main(String[] args) {
        int []a =
                {-100,100}
                ;
        int[]arr = derSeq(a,0);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
