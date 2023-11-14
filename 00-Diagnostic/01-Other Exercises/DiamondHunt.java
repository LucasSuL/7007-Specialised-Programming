package basic;

/**
 * @author Lucas Su
 * @create 2023-07-31-14:17
 */
public class DiamondHunt {
    public static int countDiamonds(String mine){
        int count=0;

        char[]arr= mine.toCharArray();
        while(mine.contains("<>")){
            mine = mine.replaceFirst("<>","");
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countDiamonds("<<>><>"));
    }
}
