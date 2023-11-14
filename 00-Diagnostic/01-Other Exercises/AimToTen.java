package basic;

/**
 * @author Lucas Su
 * @create 2023-07-25-11:44
 */
public class AimToTen {
    public int need(int[] marks){
        int sum = 0;
        for (int i = 0; i < marks.length; i++) {
            sum+=marks[i];
        }
        int len = marks.length;
        int original = len;
        double avg = (double) sum/len;
//        System.out.println(avg);

        while(avg<9.5){
            sum+=10;
            len+=1;
            avg = (double) sum/len;
        }
        return len-original;
    }

    public static void main(String[] args) {
        AimToTen aimToTen = new AimToTen();
        int[]arr = {10, 10, 10, 10};

        int res = aimToTen.need(arr);
        System.out.println(res);
    }
}
