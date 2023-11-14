package bruteforce;

/**
 * @author Lucas Su
 * @create 2023-08-01-14:45
 *
 * //topcoder 90%
 */
public class DigitsSum {
    public static int lastDigit(int n) {

        while (true) {
            int sum = 0;
            String str = Integer.toString(n);
            char[] arr = str.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i]-'0';
            }
            if (sum < 10)
                return sum;
            n=sum;
        }
    }

    public static void main(String[] args) {
        System.out.println(lastDigit(314));
    }
}
