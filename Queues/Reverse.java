package Queues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class Reverse {
    public static void main(String[] args) {

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        System.out.println(Arrays.toString(reverse(queue)));
//        System.out.println(queue);
//        queue.remove();
//        System.out.println(queue);
//
//        queue.size();
//        queue.contains(1);
//        queue.isEmpty();
    }

    // can only use add, remove, isEmpty
    public static Object[] reverse(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        return queue.toArray();

    }
}