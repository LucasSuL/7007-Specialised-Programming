package bruteforce;

/**
 * @author Lucas Su
 * @create 2023-08-16-13:17
 *
 * tp- 20 min
 */
public class TwoStamps {
    public static int minCircles(String[] page) {
        int count = 0;
        for (int i = 0; i < page.length; i++) {
            String str = page[i];
            if (str.charAt(0) == ')') return -1;

            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                char c_next = ' ';
                if (j != str.length() - 1) {
                    c_next = str.charAt(j + 1);
                }
                if (c == '(' && c_next == ')') {
                    count++;
                    j++;
                } else if (c == '(' && c_next == ' ') {
                    count++;
                    j++;
                } else if (c == ' ' && c_next == ')') {
                    count++;
                    j++;
                } else if (c == '(' && c_next == '(') {
                    count++;
                } else if (c == ')' && c_next == ')') {
                    count += 2;
                    j++;
                } else if (c == ')' && c_next == ' ') {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(minCircles(new String[]
                {"    ",
                        " () ",
                        "    "}
        ));
        System.out.println(minCircles(new String[]
                {
                        "(())"}

        ));
        System.out.println(minCircles(new String[]
                {"(   ",
                        "(   ",
                        "(   "}
        ));
        System.out.println(minCircles(new String[]
                {"(   ",
                        ")   ",
                        ")   "}
        ));
        System.out.println(minCircles(new String[]
                {"( ) ",
                        "    ",
                        "    "}
        ));
        System.out.println(minCircles(new String[]
                {"( ( ( (  ) ) ) )"}

        ));
        System.out.println(minCircles(new String[]

                {"    ",
                        "    ",
                        "    "}

        ));
    }
}
