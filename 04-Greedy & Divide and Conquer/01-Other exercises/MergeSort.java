package DivideConquer;

/**
 * @author Lucas Su
 * @create 2023-10-04-14:50
 */
public class MergeSort {
    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    private void sort(int[] nums, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            sort(nums, l, m);
            sort(nums, m + 1, r);
            merge(nums, l, m, r);
        }
    }

    private void merge(int[] nums, int l, int m, int r) {
        // create two new arrays for use
        int l1 = m - l + 1;
        int l2 = r - m;
        int[] L = new int[l1];
        int[] R = new int[l2];

        // copy and paste original part into new arrays
        for (int i = 0; i < L.length; i++) {
            L[i] = nums[l + i];
        }
        for (int i = 0; i < R.length; i++) {
            R[i] = nums[m + 1 + i];
        }

        // initial two pointers(i, j) for both new arrays and a new pointer(k) for original array.
        int i = 0, j = 0;
        int k = l;

        // while both pointers are valid, put the smaller value into corresponding position
        while (i < l1 && j < l2) {
            if (L[i] < R[j]) {
                nums[k] = L[i];
                k++;
                i++;
            } else {
                nums[k] = R[j];
                k++;
                j++;
            }
        }

        // copy and paster the remaining part into original array.
        while (i < l1) {
            nums[k] = L[i];
            k++;
            i++;
        }
        while (j < l2) {
            nums[k] = R[j];
            k++;
            j++;
        }
    }

    public static void main(String[] args) {
        MergeSort ms = new MergeSort();
        int[] array = ms.sortArray(new int[]{38, 27, 43, 10});

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
