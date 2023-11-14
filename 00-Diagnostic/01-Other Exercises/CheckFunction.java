package basic;

/**
 * @author Lucas Su
 * @create 2023-07-31-15:50
 */
public class CheckFunction {
    public static int newFunction(String code){
        int[]val = {6,2,5,5,4,5,6,3,7,6};
        int sum = 0;

        char[]arr = code.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            int index = arr[i]-'0';
            sum+=val[index];
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(newFunction("73254370932875002027963295052175"));
    }
}
