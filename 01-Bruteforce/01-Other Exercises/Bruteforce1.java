package bruteforce;

/**
 * @author Lucas Su
 * @create 2023-07-31-12:24
 */
public class Bruteforce1 {
    //What is the 10001st prime number?
    public int prime(int index) {
//        List<Integer> integerList = new ArrayList<>();
        int count = 0;
        int num = 3;
        while (count < index) {
            boolean flag = false;
            for (int i = 2; i < num / 2; i++) {
                if (num % i == 0) flag = true;
            }
            if(!flag) {
                count++;
                num++;
            }else{
                num++;
            }
        }
        return num-1;
    }

    public static void main(String[] args) {
        Bruteforce1 bruteforce1 = new Bruteforce1();
        System.out.println(bruteforce1.prime(10001));
    }
}
