package bruteforce;

/**
 * @author Lucas Su
 * @create 2023-08-09-20:53
 */
public class SearchInRotatedSortedArray {
    public static int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;

        // Find the index of the pivot element (the smallest element)
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[n - 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(left);
        return -1;
    }

    public static void main(String[] args) {
//        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int[] nums = {3, 5, 1};
        System.out.println(search(nums, 3));
    }
}
