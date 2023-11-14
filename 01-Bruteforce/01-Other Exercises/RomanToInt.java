package bruteforce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Lucas Su
 * @create 2023-08-09-19:10
 */
public class RomanToInt {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        List<Character> list = new ArrayList<>();
        List<Character> indexList = new ArrayList<>();
        indexList.add('I');
        indexList.add('V');
        indexList.add('X');
        indexList.add('L');
        indexList.add('C');
        indexList.add('D');
        indexList.add('M');

        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i)); //M CM XC IV
        }

        int res = 0;
        boolean flag = false;
        for (int i = 0; i < list.size() - 1; i++) {
            int a = indexList.indexOf(list.get(i + 1));
            int b = indexList.indexOf(list.get(i));
            if (a > b) {
                char c1 = list.get(i + 1);
                char c2 = list.get(i);
                res += map.get(c1) - map.get(c2);
                i++;
                if (i == list.size() - 1) flag = true;
            } else {
                res += map.get(list.get(i));
            }
        }
        if (!flag) {
            res += map.get(list.get(list.size() - 1));
        }
        return res;
    }

    public static void main(String[] args) {
        RomanToInt romanToInt = new RomanToInt();
        System.out.println(romanToInt.romanToInt("III"));
        System.out.println(romanToInt.romanToInt("MCMXCIV"));
    }
}
