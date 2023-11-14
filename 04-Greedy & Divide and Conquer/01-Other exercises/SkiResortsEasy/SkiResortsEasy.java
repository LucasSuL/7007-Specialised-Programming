package DivideOrGreedy;

/**
 * @author Lucas Su
 * @create 2023-09-13-15:42
 */
public class SkiResortsEasy {
    public int minCost(int[] altitude) {
        int res = 0;
        for (int i = 1; i < altitude.length; i++) {
            if (altitude[i] > altitude[i - 1]) {
                res += altitude[i] - altitude[i - 1];
                altitude[i] = altitude[i - 1];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new SkiResortsEasy().minCost(new int[]{3,2,2,1}));
        System.out.println(new SkiResortsEasy().minCost(new int[]{5,7,3}));
        System.out.println(new SkiResortsEasy().minCost(new int[]{6,8,5,4,7,4,2,3,1}));
        System.out.println(new SkiResortsEasy().minCost(new int[]{749,560,921,166,757,818,228,584,366,88}));
        System.out.println(new SkiResortsEasy().minCost(new int[]{712,745,230,200,648,440,115,913,627,621,186,222,741,954,581,193,266,320,798,745}));
    }
}
