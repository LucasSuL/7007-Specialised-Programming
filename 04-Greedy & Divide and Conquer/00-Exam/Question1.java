/**
 * @author Lucas Su
 * @create 2023-10-11-13:51
 * <p>
 * XY-> YZ
 * YX-> ZY
 */
public class Question1 {
    public int maxPoint(String s) {
        int score = 0;
        char[] sArray = s.toCharArray();

        for (int i = 0; i < sArray.length; i++) {
            int curr_sc = 0;

            if (sArray[i] == 'Y') {
                int L_X = 0;
                int R_X = 0;
                int index = i;
                while (index > 0) {
                    index--;
                    if (sArray[index] == 'X') L_X++;
                    else break;
                }
                index = i;
                while (index < sArray.length - 1) {
                    index++;
                    if (sArray[index] == 'X') R_X++;
                    else break;
                }

                if (L_X > R_X) {
                    curr_sc++;
                    sArray[i - 1] = 'Y';
                    sArray[i] = 'Z';
                    i = 0;
                } else if (R_X > L_X) {
                    curr_sc++;
                    sArray[i] = 'Z';
                    sArray[i + 1] = 'Y';
                    i = 0;
                } else {
                    // Lx = Rx
                    if (R_X != 0) { // 随便换一个
                        curr_sc++;
                        sArray[i - 1] = 'Y';
                        sArray[i] = 'Z';
                        i = 0;
                    }else{ // both are 0
                        continue;
                    }
                }
            }
            score += curr_sc;
        }
        return score;
    }


    public static void main(String[] args) {
        Question1 q1 = new Question1();
        //XY->YZ YX->ZY
        System.out.println(q1.maxPoint("XYXY")); // Returns: 2
        System.out.println(q1.maxPoint("YXYXYX")); // Returns: 3
        System.out.println(q1.maxPoint("XXXXXXXX")); // Returns: 0
        System.out.println(q1.maxPoint("YYYYYYYY")); // 0
        System.out.println(q1.maxPoint("XYXYXYXY")); // 4
        System.out.println(q1.maxPoint("YXYXYXYX")); // 4
        System.out.println(q1.maxPoint("XXXXYXXX")); // 4
        System.out.println(q1.maxPoint("YYYYXYYY")); // 1
        System.out.println(q1.maxPoint("XYXYXYYX")); // 4
        System.out.println(q1.maxPoint("YXXYYXXY")); // 4
        System.out.println(q1.maxPoint("XXYXXYXX")); // 4 YZZYZZXX
        System.out.println(q1.maxPoint("YYXYYXYY")); // YYXYYXYY
        System.out.println(q1.maxPoint("XYXYYXYXYXYX"));
        System.out.println(q1.maxPoint("YXYXYXYXYXYX"));
        System.out.println(q1.maxPoint("XXXXXYXXXXYXXXXX")); // YZZZZZXXXXYXXXXX
        System.out.println(q1.maxPoint("YYYYYXYYYYXYYYYY")); // YYYYYXYYYYXYYYYY
    }
}
