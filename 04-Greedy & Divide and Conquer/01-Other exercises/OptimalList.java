package Greedy;

/**
 * @author Lucas Su
 * @create 2023-09-06-13:54
 * https://community.topcoder.com/stat?c=problem_statement&pm=7752
 */
public class OptimalList {
    public static String optimize(String inst){
        int[]dir = new int[2]; // E N S W
        for (int i = 0; i < inst.length(); i++) {
            if(inst.charAt(i) == 'N') dir[0]++;
            if(inst.charAt(i) == 'S') dir[0]--;
            if(inst.charAt(i) == 'E') dir[1]++;
            if(inst.charAt(i) == 'W') dir[1]--;
        }
        StringBuilder sb =new StringBuilder();
        int len1 = Math.abs(dir[0]);
        int len2 = Math.abs(dir[1]);

        if(dir[0]>0){
            if(dir[1]>0){ //ne
                for (int i = 0; i < len1; i++) {
                    sb.append('E');
                }
                for (int i = 0; i < len2; i++) {
                    sb.append('N');
                }
            }else{ //nw
                for (int i = 0; i < len1; i++) {
                    sb.append('N');
                }
                for (int i = 0; i < len2; i++) {
                    sb.append('W');
                }
            }
        }else {
            if(dir[1]>0){ //se
                for (int i = 0; i < len1; i++) {
                    sb.append('E');
                }
                for (int i = 0; i < len2; i++) {
                    sb.append('S');
                }
            }else{ //sw
                for (int i = 0; i < len1; i++) {
                    sb.append('S');
                }
                for (int i = 0; i < len2; i++) {
                    sb.append('W');
                }
            }
        }
        return sb.toString();

    }
    public static void main(String[] args) {
        System.out.println(optimize("NENENNWWWWWS"
        ));
        System.out.println(optimize("NNEESSWW"
        ));
        System.out.println(optimize("NEWSNWESWESSEWSENSEWSEWESEWWEWEEWESSSWWWWWW"
        ));
        System.out.println(optimize("NENENE"
        ));
    }
}
