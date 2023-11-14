package bruteforce;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Lucas Su
 * @create 2023-08-12-23:13
 */
public class FindAllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            String str = s.substring(i, i + p.length());

            int[] charCount = new int[26]; // Assuming input strings contain only lowercase English letters

            for (int i1 = 0; i1 < str.length(); i1++) {
                charCount[str.charAt(i1) - 'a']++;
                charCount[p.charAt(i1) - 'a']--;
            }

            boolean flag = true;
            for (int i1 = 0; i1 < charCount.length; i1++) {
                if (charCount[i1] != 0) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FindAllAnagrams f = new FindAllAnagrams();
        List<Integer> res = f.findAnagrams("acdcaeccde", "c");

        for (Integer i : res) {
            System.out.println(i);
        }
    }
}
