package DivideConquer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Lucas Su
 * @create 2023-10-10-19:25
 * https://leetcode.com/problems/non-overlapping-intervals/
 */
public class NonOverlappingInterval {
    /**
     * other solution from leetcode: exchange space for time:
     *
     * public int eraseOverlapIntervals(int[][] intervals) {
     *         Arrays.sort(intervals,(a,b)->Integer.compare(a[1],b[1]));
     *         int count=1;
     *         int end = intervals[0][1];
     *         for(int i=1;i<intervals.length;i++){
     *             if(end<=intervals[i][0]){
     *                 count++;
     *                 end = intervals[i][1];
     *             }
     *         }
     *         return intervals.length-count;
     *     }
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                int compareBySecondElement = a[0] - b[0];
//                if (compareBySecondElement == 0) return a[1] - b[1];
                return compareBySecondElement;
            }
        });

        int count = 0, l = 0, r = 1;

        while (r < intervals.length) {
            // case0: no overlapping
            if (intervals[r][0] >= intervals[l][1]) {
                l = r;
                r++;
            }
            // case1: normal overlapping, del r.
            else if (intervals[r][1] > intervals[l][1]) {
                r++;
                count++;
            }
            // case2: fully covered, del l.
            else {
                l = r;
                r++;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NonOverlappingInterval n = new NonOverlappingInterval();
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        int[][] intervals1 = {{1, 2}, {1, 2}, {1, 2}};
        System.out.println(n.eraseOverlapIntervals(intervals));
        System.out.println(n.eraseOverlapIntervals(intervals1));
    }
}
