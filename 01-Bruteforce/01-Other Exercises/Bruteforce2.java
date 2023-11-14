package bruteforce;

/**
 * @author Lucas Su
 * @create 2023-07-31-15:09
 */
public class Bruteforce2 {

    //n=n/2 (n %2==0)
    //n=3n+1 (n%2==1)

    public static long LongestCollatzSequence() {
        int maxCount = 0;
        long maxNumberIndex = 0;

        for (long i = 1; i < 1000; i++) {
            int count = 1;
            long num = i;
            while (true) {
                if (num % 2 == 0) {
                    num = num / 2;
                    count++;
                } else if (num % 2 == 1) {
                    num = 3 * num + 1;
                    count++;
                }
                if (num == 1) break;
            }
            if(count>maxCount){
                maxCount = count;
                maxNumberIndex = i;
            }
        }
        return maxNumberIndex;
    }

    public static void main(String[] args) {
        System.out.println(LongestCollatzSequence());
    }
}
