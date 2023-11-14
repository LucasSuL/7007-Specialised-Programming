package bruteforce;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Lucas Su
 * @create 2023-08-13-17:19
 */
public class StudentsUnableToEat {
    public int countStudents(int[] students, int[] sandwiches) {
        StringBuilder stu = new StringBuilder();
        StringBuilder sand = new StringBuilder();
        for (int i = 0; i < students.length; i++) {
            stu.append(students[i]);
            sand.append(sandwiches[i]);
        }

        int index = 1;
        boolean flag = false;
        loop : while (index == 1) {
            for (int i = 0; i < stu.length(); i++) {
                if (stu.charAt(i) == sand.charAt(0)) {
                    stu.deleteCharAt(i);
                    sand.deleteCharAt(0);
                    continue loop;
                }
            }
            index = -1;
        }
        return stu.length();

//        Queue<Integer> queue = new LinkedList<>();
//        Stack<Integer> stack = new Stack<>();
//
//        for (int i = 0; i < sandwiches.length; i++) {
//            queue.add(students[i]);
//        }
//        for (int i = sandwiches.length-1; i>=0;  i--) {
//            stack.add(sandwiches[i]);
//        }
//        int count = 1;
//        while (stack.size() !=0 &&count <= students.length) {
//            if (stack.peek() == queue.peek()) {
//                stack.pop();
//                queue.poll();
//                count = 0;
//            }else{
//                queue.add(queue.poll());
//            }
//            count++;
//        }
//        return stack.size();
    }

    public static void main(String[] args) {
        System.out.println(new StudentsUnableToEat().countStudents(new int[]{1, 1, 0, 0}, new int[]{0, 1, 0, 1}));
    }
}
