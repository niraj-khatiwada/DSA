package Queue;

import java.util.Queue;
import java.util.Stack;

public class Reverse {
    public Queue<Integer> reverse(Queue<Integer> queue) {
        var stack = new Stack<Integer>();

        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
        return queue;
    }
}
