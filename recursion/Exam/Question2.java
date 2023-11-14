package recursion;

/**
 * @author Lucas Su
 * @create 2023-08-30-13:48
 */
public class Question2 {
    public static int minOperationsCount(int n) {
        // n >= 1
        if (n == 1) return 0; // no action
        if (n <= 4) return n; // 2: 1c+1p; 3: 1c+1p+1p; 4:1c+1p+1c+1p;

        int result = 0; // result value (steps)
        int cur_number = 1; // how many we got till now
        int copied = 0; // how many would we got in one paste

        while (cur_number < n) {

            // we can't paste small number once we got bigger cur_number,
            // so that our task is to always find the biggest doubled number that could still be divisible by n
            if (n % cur_number == 0) {
                copied = cur_number; // copy
                cur_number += copied; // paste
                result += 2; // two actions

            } else {
                // once we come here --> we could not copy anymore because we would surely fail.
                // only paste, and loop to check again if it could be divisible by n
                cur_number += copied; // paste
                result++; // one action
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(minOperationsCount(3));
        System.out.println(minOperationsCount(1));
        System.out.println(minOperationsCount(6));
        System.out.println(minOperationsCount(15));
        System.out.println(minOperationsCount(20));
        System.out.println(minOperationsCount(100));
        System.out.println(minOperationsCount(27));
        System.out.println(minOperationsCount(98));
        System.out.println(minOperationsCount(932));
        System.out.println(minOperationsCount(728));
        System.out.println(minOperationsCount(302));
        System.out.println(minOperationsCount(37));
        System.out.println(minOperationsCount(1000));
        System.out.println(minOperationsCount(10000));
        System.out.println(minOperationsCount(3003));
        System.out.println(minOperationsCount(3204));
    }
}
