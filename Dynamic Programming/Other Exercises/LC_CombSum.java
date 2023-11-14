package DP;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lucas Su
 * @create 2023-09-09-18:41
 * https://leetcode.com/problems/combination-sum/
 * <p>
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 * <p>
 * <p>
 * Input: candidates = [2,3,5], target = 8
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
 */
public class LC_CombSum {


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        recur(res, candidates, target, 0, 0, curr);
        return res;
    }

    private void recur(List<List<Integer>> res, int[] candidates, int target, int i, int currSum, List<Integer> curr) {
        if (currSum == target) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if (currSum > target || i >= candidates.length) return;
        curr.add(candidates[i]);
        recur(res, candidates, target, i, currSum + candidates[i], curr);
        curr.remove(curr.size()-1);
        recur(res, candidates, target, i + 1, currSum, curr);
    }

    public static void main(String[] args) {
        List<List<Integer>> res = new LC_CombSum().combinationSum(new int[]{2, 3, 6, 7}, 7);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
