package basic;

/**
 * @author Lucas Su
 * @create 2023-07-25-12:32
 */
public class FunnyFence {
    public int getLength(String s) {

        char arr[] = s.toCharArray();
        int start = 0;

        int count = 1;
        while(start != arr.length-1) {
            int curr = 1;
            for (int i = start; i < arr.length - 1; i++) {
                if (arr[i + 1] != arr[i]) {
                    curr++;
                    start = i+1;
                } else {
                    start = i+1;
                    break;
                }
            }
            if(curr>count){
                count = curr;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        FunnyFence funnyFence = new FunnyFence();
        int res = funnyFence.getLength("|||-||--|--|---|-||-|-|-|--||---||-||-||-|--||"
        );
        System.out.println(res);
    }
}
