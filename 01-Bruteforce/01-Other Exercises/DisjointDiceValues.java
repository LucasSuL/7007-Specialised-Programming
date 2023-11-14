package bruteforce;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lucas Su
 * @create 2023-08-01-16:17
 */
public class DisjointDiceValues {
    public static double getProbability(int A, int B) {
        // count 111...A digit - 666...A digit each digit not over 6:
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = new StringBuilder();
        for (int i = 0; i < A; i++) {
            sb1.append(1);
            sb2.append(6);
        }

        for (int i = 0; i < B; i++) {
            sb3.append(1);
            sb4.append(6);
        }

        int start = Integer.parseInt(sb1.toString());
        int end = Integer.parseInt(sb2.toString());
        int start1 = Integer.parseInt(sb3.toString());
        int end1 = Integer.parseInt(sb4.toString());

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int i = start; i <= end; i++) {
            String str = Integer.toString(i);
            if (!(str.contains("7") | str.contains("8") | str.contains("9") | str.contains("0"))) {
                list1.add(i);
            }
        }

        for (int i = start1; i <= end1; i++) {
            String str = Integer.toString(i);
            if (!(str.contains("7") | str.contains("8") | str.contains("9") | str.contains("0"))) {
                list2.add(i);
            }
        }

        int count = 0;
        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                int sequence1 = list1.get(i);
                int sequence2 = list2.get(j);
                String str1 = Integer.toString(sequence1); //145
                String str2 = Integer.toString(sequence2); // 24
                boolean flag = false;
                loop1: for (int i1 = 0; i1 < str1.length(); i1++) {
                    for (int i2 = 0; i2 < str2.length(); i2++) {
                        if (str1.charAt(i1) == str2.charAt(i2)) {
                            flag = true;
                            break loop1;
                        }
                    }
                }
                if(flag) count++;
            }
        }

        return count/Math.pow(6,A+B);
    }

    public static void main(String[] args) {
        System.out.println(getProbability(4,1));
//        System.out.println(getProbability(4, 1));
    }
}
