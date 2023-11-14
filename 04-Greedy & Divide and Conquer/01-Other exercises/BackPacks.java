package Greedy;

import java.util.Arrays;

/**
 * @author Lucas Su
 * @create 2023-10-04-14:31
 */
public class BackPacks {
    static int getMin(int[] item) {
        Arrays.sort(item);
        int n = item.length;

        // Initialize the number of backpacks required and the current backpack's remaining capacity
        int backpacks = 0;
        int remainingCapacity = 300;

        for (int i = n - 1; i >= 0; i--) {
            if (remainingCapacity >= item[i]) {
                // If the current item can fit in the current backpack, put it in
                remainingCapacity -= item[i];
            } else {
                // If the current item doesn't fit in the current backpack, use a new backpack
                backpacks++;
                remainingCapacity = 300 - item[i]; // Start a new backpack with this item's weight
            }
        }

        // If there are items left after the loop, add one more backpack
        if (remainingCapacity < 300)  backpacks++;

        return backpacks;
    }

    public static void main(String[] args) {
//        System.out.println(getMin(new int[]{150, 150, 150, 150, 150}));
//        System.out.println(getMin(new int[]{130, 140, 150, 160}));
//        System.out.println(getMin(new int[]{101, 101, 101, 101, 101, 101, 101, 101, 101}));
        System.out.println(getMin(new int[]{101, 200, 101, 101, 101, 101, 200, 101, 200}));
//        System.out.println(getMin(new int[]{123, 145, 167, 213, 245, 267, 289, 132, 154, 176, 198}));
    }
}
