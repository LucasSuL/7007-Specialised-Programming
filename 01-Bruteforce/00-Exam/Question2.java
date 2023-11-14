package bruteforce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Lucas Su
 * @create 2023-08-16-15:11
 */
public class Question2 {
    public static List<int[]> getDiagonalCoordinates(int i, int j, int size) {
        List<int[]> diagonalCoords = new ArrayList<>();

        // 方向1：从左上到右下的对角线
        for (int diff = -size + 1; diff < size; diff++) {
            int x = i + diff;
            int y = j + diff;

            if (x >= 0 && x < size && y >= 0 && y < size) {
                int[] coord = {x, y};
                diagonalCoords.add(coord);
            }
        }

        // 方向2：从右上到左下的对角线
        for (int diff = -size + 1; diff < size; diff++) {
            int x = i + diff;
            int y = j - diff;

            if (x >= 0 && x < size && y >= 0 && y < size) {
                int[] coord = {x, y};
                diagonalCoords.add(coord);

            }
        }
        return diagonalCoords;
    }

    public static int[] addAttackers(int[] row, int[] col, int add) {
        List<Integer> rowList = new ArrayList<>();
        for (int num : row) {
            rowList.add(num);
        }
        List<Integer> colList = new ArrayList<>();
        for (int num : col) {
            colList.add(num);
        }

        boolean flag[][] = new boolean[50][50];
        for (int i = 0; i < row.length; i++) {
            List<int[]> diagonalCoords = getDiagonalCoordinates(row[i], col[i], 50);

            for (int j = 0; j < diagonalCoords.size(); j++) {
                int m = diagonalCoords.get(j)[0];
                int n = diagonalCoords.get(j)[1];

                flag[m][n] = true;
            }
        }

        int[] res = new int[2 * add];
        List<Integer> resList = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {

                if (resList.size() != 2 * add && !(rowList.contains(i) || colList.contains(j))) {
                    if(!flag[i][j]) {
                        resList.add(i);
                        resList.add(j);
                        rowList.add(i);
                        colList.add(j);

                        List<int[]> diagonalCoords1 = getDiagonalCoordinates(i, j, 50);

                        for (int q = 0; q < diagonalCoords1.size(); q++) {
                            int m = diagonalCoords1.get(q)[0];
                            int n = diagonalCoords1.get(q)[1];
                            flag[m][n] = true;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = addAttackers(new int[]{3}, new int[]{5}, 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        int[] arr1 = addAttackers(new int[]{0}, new int[]{1}, 1);
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i]+" ");
        }
        System.out.println();

        int[] arr2 = addAttackers(new int[]{0}, new int[]{1}, 3);
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i]+" ");
        }        System.out.println();

        int[] arr3 = addAttackers(new int[]{14, 19}, new int[]{3, 47}, 0);
        for (int i = 0; i < arr3.length; i++) {
            System.out.print(arr3[i]+" ");
        }        System.out.println();

        int[] arr4 = addAttackers(new int[]{}, new int[]{}, 2);
        for (int i = 0; i < arr4.length; i++) {
            System.out.print(arr4[i]+" ");
        }        System.out.println();

        int[] arr5 = addAttackers(new int[]{1,2,3}, new int[]{7,2,9}, 1);
        for (int i = 0; i < arr5.length; i++) {
            System.out.print(arr5[i]+" ");
        }        System.out.println();

        int[] arr6 = addAttackers(new int[]{}, new int[]{}, 16);
        for (int i = 0; i < arr6.length; i++) {
            System.out.print(arr6[i]+" ");
        }        System.out.println();

        int[] arr7 = addAttackers(new int[]{}, new int[]{}, 0);
        for (int i = 0; i < arr7.length; i++) {
            System.out.print(arr7[i]+" ");
        }        System.out.println();

        int[] arr8 = addAttackers(new int[]{4, 35, 36, 16, 24, 39, 1, 34, 32, 28, 2, 23}, new int[]{27, 29, 21, 32, 25, 2, 6, 0, 22, 15, 35, 45}, 4);
        for (int i = 0; i < arr8.length; i++) {
            System.out.print(arr8[i]+" ");
        }        System.out.println();

        int[] arr9 = addAttackers(new int[]{38, 35, 48, 15, 2, 21, 24, 34, 6, 14, 30, 26}, new int[]{21, 36, 12, 46, 8, 6, 32, 16, 41, 44, 47, 38}, 4);
        for (int i = 0; i < arr9.length; i++) {
            System.out.print(arr9[i]+" ");
        }        System.out.println();

        int[] arr10 = addAttackers(new int[]{43, 49, 35, 22, 30, 36, 46, 14, 7, 13, 38, 0}, new int[]{18, 15, 16, 34, 19, 49, 33, 38, 40, 24, 35, 10}, 4);
        for (int i = 0; i < arr10.length; i++) {
            System.out.print(arr10[i]+" ");
        }        System.out.println();

        int[] arr11 = addAttackers(new int[]{4, 32, 34}, new int[]{17, 39, 30}, 13);
        for (int i = 0; i < arr11.length; i++) {
            System.out.print(arr11[i]+" ");
        }        System.out.println();

        int[] arr12 = addAttackers(new int[]{23, 2, 43, 45, 20, 36, 13, 11, 30, 8, 33, 6, 28, 41}, new int[]{48, 38, 30, 40, 1, 15, 22, 11, 12, 6, 25, 17, 0, 7}, 2);
        for (int i = 0; i < arr12.length; i++) {
            System.out.print(arr12[i]+" ");
        }        System.out.println();

        int[] arr13 = addAttackers(new int[]{4, 1, 2, 11, 32, 12, 31, 29, 36, 44, 34, 40, 39, 24}, new int[]{23, 16, 8, 47, 31, 49, 33, 36, 0, 4, 21, 2, 15, 7}, 2);
        for (int i = 0; i < arr13.length; i++) {
            System.out.print(arr13[i]+" ");
        }        System.out.println();

        int[] arr14 = addAttackers(new int[]{5}, new int[]{19}, 15);
        for (int i = 0; i < arr14.length; i++) {
            System.out.print(arr14[i]+" ");
        }        System.out.println();


    }
}
