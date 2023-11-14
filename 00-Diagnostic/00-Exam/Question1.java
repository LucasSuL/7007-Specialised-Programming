import java.util.ArrayList;
import java.util.List;

/**
 * @author Lucas Su
 * @create 2023-08-02-14:10
 */
public class Question1 {
    public String determineBallColor(long r, long g, long b, long k) {
        // 1st round rgb could not be 0, reduce the problem scale simply
        long calc[] = {r, g, b, k / 3};
        long min = Long.MAX_VALUE;
        for (int i = 0; i < calc.length; i++) {
            if (calc[i] < min) {
                min = calc[i];
            }
        }
        r -= min;
        g -= min;
        b -= min;
        k -= 3 * min;

        // for the 1st round, if k happens to be 0, then we can be sure B is the last one.
        if (k == 0) return "BLUE";

        // else: we have to consider how many 0s we have in rgb
        Long rgb[] = {r, g, b};
        int numZero = countZero(rgb);

        if (numZero == 3) return "BLUE"; // after first round --> 0,0,0 represent BLUE is the last one destroyed

        if (numZero == 2) { // find the one that is not 0
            for (int i = 0; i < rgb.length; i++) {
                if (rgb[i] != 0) {
                    if (i == 0) return "RED";
                    else if (i == 1) return "GREEN";
                    else return "BLUE";
                }
            }
        }
        if (numZero == 0) {
            if (k == 0) return "BLUE";
            else if (k == 1) return "RED";
            else return "GREEN";
        }

        // else: numZero == 1, reduce the problem size again
        long calcTwo[] = {r, g, b, k / 2};
        long min1 = Long.MAX_VALUE;

        for (int i = 0; i < calcTwo.length; i++) {
            if (calcTwo[i] != 0 && calcTwo[i] < min1) {
                min1 = calcTwo[i];
            }
        }
        for (int i = 0; i < rgb.length; i++) {
            if (rgb[i] != 0) rgb[i] -= min1;
        }
        k -= 2 * min1;

        // find which element is not 0
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < rgb.length; i++) {
            if (rgb[i] != 0) {
                list.add(i);
            }
        }

        if (list.size() == 2) { // && k / 3 == 0?
            if (k == 0) {
                // choose the last one that is not 0, which should between G and B
                if (list.get(1) == 1) return "GREEN";
                if (list.get(1) == 2) return "BLUE";
            } else if (k == 1) {
                // choose the first one that is not 0, which should between R and G
                if (list.get(0) == 0) return "RED";
                if (list.get(0) == 1) return "GREEN";
            }
        } else if (list.size() == 1) {
            // simply return the element that is not 0 (list.get0)
            if (list.get(0) == 0) return "RED";
            if (list.get(0) == 1) return "GREEN";
            if (list.get(0) == 2) return "BLUE";
        }
        return "ERROR";
    }

    private int countZero(Long[] rgb) {
        int countZero = 0;
        for (int i = 0; i < rgb.length; i++) {
            if (rgb[i] == 0) {
                countZero++;
            }
        }
        return countZero;
    }

    public static void main(String[] args) {
        Question1 q1 = new Question1();
        System.out.println(q1.determineBallColor(1, 1, 1, 3)); // Returns: "BLUE"
        System.out.println(q1.determineBallColor(3, 4, 5, 4)); // Returns: "RED"`
        System.out.println(q1.determineBallColor(7, 7, 1, 7)); // Returns: "GREEN"`
        System.out.println(q1.determineBallColor(1000000000000L, 1, 1, 1000000000002L)); // Returns: "RED"
        System.out.println(q1.determineBallColor(653, 32, 1230, 556)); // Returns: "BLUE"
        System.out.println(q1.determineBallColor(39, 4, 29, 7));
        System.out.println(q1.determineBallColor(33, 38, 18, 85));
        System.out.println(q1.determineBallColor(1362806, 9637722, 7058502, 1977778));
        System.out.println(q1.determineBallColor(17964018705L, 65273511246L, 31105494141L, 50314587302L));
        System.out.println(q1.determineBallColor(66977089037L, 56944425814L, 82337384434L, 197258589648L));
        System.out.println(q1.determineBallColor(271281576404L, 789227539981L, 962212822048L, 1863718050608L));
        System.out.println(q1.determineBallColor(26, 26, 26, 33));
        System.out.println(q1.determineBallColor(726158833853L, 726158833853L, 726158833853L, 932704193638L));
        System.out.println(q1.determineBallColor(999999999, 999999999, 999999999, 999999999));
        System.out.println(q1.determineBallColor(10000000000L, 10000000000L, 10000000000L, 10000000000L));
        System.out.println(q1.determineBallColor(1000000000000L, 999999999999L, 99999999999L, 1999999999999L));

    }
}
