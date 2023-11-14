package bruteforce;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Lucas Su
 * @create 2023-08-13-16:46
 */
public class MyStack {
    Queue<Integer> queue = new LinkedList<>();

    public MyStack() {

    }

    public void push(int x) {
        queue.add(x);
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.add(queue.poll());
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());

    }
}
