package bruteforce;

/**
 * @author Lucas Su
 * @create 2023-08-16-13:38
 *
 * 20 min TBD
 */
public class Xosceles {
    public static String[] draw(int xCount) {
        int c1 = 0;
        int c2 = 0;
        int len = 0;
        for (int i = 0; i < 50; i++) {
            if ((Math.pow(i, 2) + 2 * i + 1) == xCount) {
                c1 = i;
                len = i + 1;
                break;
            }
            if ((Math.pow(i, 2) + 3 * i + 2) == xCount) {
                c2 = i;
                len = i + 1;
                break;
            }
        }
        System.out.println(len);
        String[] res = new String[len];

        if (c1 > 0) {
            int base_len = 2 * len - 1;
            for (int i = 0; i < len; i++) {
                StringBuilder sb = new StringBuilder();


                res[i] = sb.toString();
            }
        } else if (c2 > 1) {
            int base_len = 2 * len;

            for (int i = 0; i < len; i++) {

            }
        } else {
            return new String[0];
        }
        return res;
    }

    public static void main(String[] args) {
        draw(4);
        draw(6);
        draw(16);
        draw(18);
        draw(100);
    }

}
