package basic;

import java.util.*;

/**
 * @author Lucas Su
 * @create 2023-07-25-12:54
 */
public class FriendlySequences {
    public int count(int[] array) {

        // Mingyu's solution
        int count = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int[]subarray = Arrays.copyOfRange(array,i,j);

                // check whether subarray
            }
        }


        return -1;

//      // mine solution
//        List<Set> setList = new ArrayList<>();
//        for (int i = 0; i < array.length; i++) {
//            char[] arr = Integer.toString(array[i]).toCharArray();
//            Set<Character> set = new HashSet<Character>();
//            for (int i1 = 0; i1 < arr.length; i1++) {
//                set.add(arr[i1]);
//            }
//            setList.add(set);
//        }
//
//        int sum = 0;
//        int start = 0;
//
//        while (start != setList.size() - 1) {
//            int count = 1;
//            for (int i = start; i < setList.size() - 1; i++) {
////                System.out.println(setList.get(i));
//                Set curr_set = setList.get(i);
//                Set next_set = setList.get(i + 1);
//
//                if (curr_set.equals(next_set)) {
//                    start = i+1;
//                    count++;
//                    if(i== setList.size()-2){
//                        for (int i1 = 0; i1 < count; i1++) {
//                            sum+=i1;
//                        }
//                        return sum;
//                    }
//                } else {
//                    start = i+1;
//                    for (int i1 = 0; i1 < count; i1++) {
//                        sum+=i1;
//                    }
//                    break;
//                }
//            }
//        }
//        return sum;
    }

    public static void main(String[] args) {
        FriendlySequences friendlySequences = new FriendlySequences();
        int[] arr =
                {9};
        int res = friendlySequences.count(arr);
        System.out.println(res);
    }
}
