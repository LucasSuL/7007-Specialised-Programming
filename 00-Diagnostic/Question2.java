/**
 * @author Lucas Su
 * @create 2023-08-02-15:06
 */
public class Question2 {
    public int maxWaterContainer(int[] height) {
        int maxContain = -1;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int diff = j - i;
                maxContain = Math.max(diff * Math.min(height[i], height[j]), maxContain);
            }
        }
        return maxContain;
    }

    public static void main(String[] args) {
        Question2 q2 = new Question2();
        System.out.println(q2.maxWaterContainer(new int[]{2, 3, 10, 5, 6, 8, 7})); // Returns: 28
        System.out.println(q2.maxWaterContainer(new int[]{1, 2})); // Returns: 1
        System.out.println(q2.maxWaterContainer(new int[]{1, 1})); // Returns: 1
        System.out.println(q2.maxWaterContainer(new int[]{4, 3, 2, 1, 4}));
        System.out.println(q2.maxWaterContainer(new int[]{1, 2, 1}));
        System.out.println(q2.maxWaterContainer(new int[]{1, 2, 4, 3}));
        System.out.println(q2.maxWaterContainer(new int[]{2, 3, 4, 5, 18, 17, 6}));
        System.out.println(q2.maxWaterContainer(new int[]{6, 8, 10, 4, 2, 5}));
        int arr1[] = new int[100000];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = 1;
        }
        int arr2[] = new int[100000];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = i % 10001;
        }
        int arr3[] = new int[100000];
        for (int i = 0; i < arr3.length; i++) {
            arr3[i] = 10000;
        }
        int arr4[] = new int[10000];
        for (int i = 0; i < arr4.length; i++) {
            arr4[i] = 10000 - i;
        }

        System.out.println(q2.maxWaterContainer(arr1));
        System.out.println(q2.maxWaterContainer(arr2));
        System.out.println(q2.maxWaterContainer(arr3));
        System.out.println(q2.maxWaterContainer(arr4));

    }
}
