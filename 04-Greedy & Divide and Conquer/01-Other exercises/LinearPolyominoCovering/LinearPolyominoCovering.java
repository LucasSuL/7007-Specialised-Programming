package DivideOrGreedy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lucas Su
 * @create 2023-09-19-16:05
 */
public class LinearPolyominoCovering {
    public static String findCovering(String region) {
        List<Integer> list = new ArrayList<>();
        int curr = 0;
        for (int i = 0; i < region.length(); i++) {
            if (region.charAt(i) == 'X') {
                curr++;
                if (i == region.length() - 1)
                    if (curr % 2 != 0) return "impossible";
                    else list.add(curr);
            } else if (region.charAt(i) == '.') {
                if (curr % 2 != 0) return "impossible";
                else list.add(curr);
                curr = 0;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            int rem = list.get(i) % 4;
            int count4A = list.get(i) / 4;

            for (int j = 0; j < 4 * count4A; j++) {
                sb.append('A');
            }
            if (rem != 0) {
                sb.append('B');
                sb.append('B');
            }
            if (i != list.size() - 1)
                sb.append('.');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(findCovering("XXXXXX"));
        System.out.println(findCovering("XX.XX"));
        System.out.println(findCovering("XXXX....XXX.....XX"));
        System.out.println(findCovering("X"));
        System.out.println(findCovering("XX.XXXXXXXXXX..XXXXXXXX...XXXXXX"));
    }
}
