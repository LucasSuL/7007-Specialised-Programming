package DivideOrGreedy;

/**
 * @author Lucas Su
 * @create 2023-09-28-12:19
 * https://leetcode.com/problems/gas-station/description/
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int total_surplus = 0;
        int surplus = 0;
        int start = 0;
        for (int i = 0; i < len; i++) {
            total_surplus += gas[i] - cost[i];
            surplus += gas[i] - cost[i];

            if(surplus < 0){
                surplus = 0;
                start = i +1;
            }
        }

        if(total_surplus < 0) return -1;
        return start;
    }


    public static void main(String[] args) {
        GasStation gs = new GasStation();
        System.out.println(gs.canCompleteCircuit(new int[]{2,3,4}, new int[]{3,4,3})); // -1
        System.out.println(gs.canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2})); // 3
        System.out.println(gs.canCompleteCircuit(new int[]{5,1,2,3,4}, new int[]{4,4,1,5,1})); // 4
        System.out.println(gs.canCompleteCircuit(new int[]{4,5,2,6,5,3}, new int[]{3,2,7,3,2,9})); // -1
        System.out.println(gs.canCompleteCircuit(new int[]{6,0,1,3,2}, new int[]{4,5,2,5,5})); // -1
    }
}
