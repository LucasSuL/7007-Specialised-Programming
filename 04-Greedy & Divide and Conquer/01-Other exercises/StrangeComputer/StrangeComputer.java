package DivideOrGreedy;

/**
 * @author Lucas Su
 * @create 2023-09-13-15:52
 */
public class StrangeComputer {
    public int setMemory(String mem) {

        int count = 0;
        if (mem.charAt(0) == '1') count++;

        for (int i = 1; i < mem.length(); i++) {
            if (mem.charAt(i) != mem.charAt(i - 1)) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new StrangeComputer().setMemory("0011"));
        System.out.println(new StrangeComputer().setMemory("000"));
        System.out.println(new StrangeComputer().setMemory("0100"));
        System.out.println(new StrangeComputer().setMemory("111000111"));
    }
}
