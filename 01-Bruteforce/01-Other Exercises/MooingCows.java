package bruteforce;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Lucas Su
 * @create 2023-08-01-15:45
 * topcoder 75%
 * 25min
 */
public class MooingCows {
    public static int dissatisfaction(String[] farmland) {
        int y = farmland.length;
        int x = farmland[0].length();

        char[][] arr = new char[y][x];
        List<Integer> listY = new ArrayList<>();
        List<Integer> listX = new ArrayList<>();

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                arr[i][j] = farmland[i].charAt(j);
                if (farmland[i].charAt(j) == 'C') {
                    listY.add(i);
                    listX.add(j);
                }
            }
        }

        int numberOfCows = listX.size();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < numberOfCows; i++) {
            int current = 0;
//            int currentY = listY.get(i);
//            int currentX = listX.get(i);

            for (int j = 0; j < numberOfCows; j++) {
                current += Math.pow(listY.get(i) - listY.get(j), 2);
                current += Math.pow(listX.get(i) - listX.get(j), 2);
            }
            min = Math.min(min, current);
        }
        return min;
    }

    public static void main(String[] args) {
        String[] arr1 =
                {"C..",
                        ".C.",
                        ".C."};
        String[] arr2 =

                {"CCCC",
                        "CCCC",
                        "CCCC"};
        String[] arr3 =
                {"C"};
        String[] arr4 =
                {"CCC....",
                        "C......",
                        "....C.C",
                        ".C.CC..",
                        "C......"};
        System.out.println(dissatisfaction(arr1));
        System.out.println(dissatisfaction(arr2));
        System.out.println(dissatisfaction(arr3));
        System.out.println(dissatisfaction(arr4));
    }
}
