package basic;

/**
 * @author Lucas Su
 * @create 2023-07-28-18:29
 */
public class ExplodingRobots {
    public String canExplode(int x1, int y1, int x2, int y2, String instructions) {
        int[] arr = new int[4];
        char[] chars = instructions.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == 'U') arr[0]++;
            else if (c == 'D') arr[1]++;
            else if (c == 'L') arr[2]++;
            else arr[3]++;
        }

        boolean flag = false;
        int x = x1 - x2;
        int y = y1 - y2;

        int abs_x = Math.abs(x);
        int abs_y = Math.abs(y);
        if (x * y >= 0) {
            if (abs_y <= arr[0] + arr[1] && abs_x <= arr[2] + arr[3]) {
                flag = true;
            }
        }

        String res = "safe";
        if (flag) res = "explode";
        return res;
    }

    public static void main(String[] args) {
        ExplodingRobots explodingRobots = new ExplodingRobots();
        System.out.println(explodingRobots.canExplode(10, 5, -9, -10, "LULULULLLUULRULULULULULULLULULLULD"));
    }
}
