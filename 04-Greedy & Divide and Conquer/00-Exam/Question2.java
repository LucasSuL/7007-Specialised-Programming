import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Lucas Su
 * @create 2023-10-11-13:51
 */
public class Question2 {
    public boolean[] eleganceTest(int[] nums, int[] queries) {

        boolean[] results = new boolean[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int query = queries[i];

            int test = 0;
            for (int j = 0; j < nums.length; j++)
                test += nums[j];

            if (test == query) results[i] =  true;
            else results[i] = isElegant(nums, query);
        }
        return results;
    }

    private boolean isElegant(int[] nums, int target) {

        int n = nums.length;
        Arrays.sort(nums);
        int mid = (nums[0] + nums[n - 1]) / 2;

        // split array
        int split_index = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= mid) {
                split_index++;
            } else {
                break;
            }
        }
        if (split_index == 0 || n - split_index == 0) return false;
        int[] L = new int[split_index];
        int[] R = new int[n - split_index];

        // assign value
        System.arraycopy(nums, 0, L, 0, L.length);
        System.arraycopy(nums, L.length, R, 0, R.length);

        // calc sum
        int sum_L = 0;
        int sum_R = 0;
        for (int i = 0; i < L.length; i++) {
            sum_L += L[i];
        }
        for (int i = 0; i < R.length; i++) {
            sum_R += R[i];
        }

        // case0: one is equal to target, return true
        if (sum_L == target || sum_R == target) return true;

            // case1: both smaller -> return false
        else if (sum_L < target && sum_R < target) return false;

            // case2: 1 is bigger, recursive call to the bigger.
        else if (sum_L > target && sum_R < target) {
            return isElegant(L, target);
        } else if (sum_L < target && sum_R > target) {
            return isElegant(R, target);
        }
        // case3: both bigger, recursive call both, return res1 & res2
        else if (sum_L > target && sum_R > target) {
            return isElegant(L, target) || isElegant(R, target);
        }


//        System.out.println(sum_L);
//        System.out.println(sum_R);

        System.out.println("ERROR");
        return false;
    }


    public static void main(String[] args) {
        Question2 q2 = new Question2();
        List<boolean[]> list = new ArrayList<>();
        list.add(q2.eleganceTest(new int[]{1, 2, 3, 4, 5}, new int[]{3, 8, 9})); //{true, false, true}
        list.add(q2.eleganceTest(new int[]{3, 1, 3, 1, 3}, new int[]{1, 3, 11})); //{false, false, true}
        list.add(q2.eleganceTest(new int[]{1, 1, 2, 3, 5, 8, 13}, new int[]{5, 21, 8})); //{true, true, true}
        list.add(q2.eleganceTest(new int[]{2, 4, 6, 8, 10, 12, 14, 16, 18, 20}, new int[]{10, 20, 30, 40}));
        list.add(q2.eleganceTest(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, new int[]{8, 16, 24, 32}));
        list.add(q2.eleganceTest(new int[]{1, 1, 2, 2, 3, 3}, new int[]{2, 4, 6}));
        list.add(q2.eleganceTest(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}, new int[]{15, 30, 45, 60, 75}));
        list.add(q2.eleganceTest(new int[]{1, 3, 5, 7, 9, 11, 13, 15, 17}, new int[]{17, 34, 51, 68}));
        list.add(q2.eleganceTest(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}, new int[]{12, 24, 36, 48}));
        list.add(q2.eleganceTest(new int[]{5, 10, 15, 20, 25, 30, 35}, new int[]{35, 70, 105}));
        list.add(q2.eleganceTest(new int[]{2, 4, 6, 8, 10, 12, 14, 16}, new int[]{16, 32, 48}));

        for (int i = 0; i < list.size(); i++) {
            boolean[] booleans = list.get(i);
            for (int j = 0; j < booleans.length; j++) {
                System.out.print(booleans[j] + ", ");
            }
            System.out.println();
        }

    }
}
