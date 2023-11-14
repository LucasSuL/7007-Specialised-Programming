package basic;

import java.util.Stack;

/**
 * @author Lucas Su
 * @create 2023-07-26-14:36
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int[]array = new int[60001];

        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i] + 30000;
            array[curr]++;
        }

        for (int i = 0; i < array.length; i++) {
            if(array[i]==1) return i-30000;
        }
        return -1;
    }
    public boolean isValid(String s) {
        if (s.length() % 2 == 1)
            return false;
        if (s.charAt(0) == ')' || s.charAt(0) == ']' || s.charAt(0) == '}')
            return false;


        Stack<Character> stack = new Stack<>();
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c=='('||c=='['||c=='{'){
                stack.push(c);
            } else {
                if(stack.isEmpty()){
                    return false;
                }
                char popped = stack.pop();
                char target;
                if (popped == '(')  target = ')';
                else if (popped == '[')  target = ']';
                else  target = '}';

                if (c!= target){
                    flag = false;
                }
            }
        }
        if (!stack.isEmpty()){
            return false;
        }
        return flag;
    }

    public static void main(String[] args) {
        SingleNumber s = new SingleNumber();
        System.out.println(s.isValid("(){}}{"));
    }

    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    int[] arr = {i, j};
                    return arr;
                }
            }
        }
        int[] arr1 = {0};
        return arr1;
    }
}
