package Queue;

import java.util.Queue;
import java.util.Stack;

public class ReverseKthElements {

    // If you cannot use queue.size(), then this is the solution, you need to create
    // another queue.

    // public Queue<Integer> reverse(Queue<Integer> queue, int k) {
    // var stack = new Stack<Integer>();
    // var newQueue = new ArrayDeque<Integer>();

    // var i = 0;
    // while (i < k) {
    // stack.push(queue.remove());
    // i++;
    // }
    // while (!stack.isEmpty()) {
    // newQueue.add(stack.pop());
    // }
    // while (!queue.isEmpty()) {
    // newQueue.add(queue.remove());
    // }
    // return newQueue;
    // }

    // This is the solution if you can use queue.size().
    public Queue<Integer> reverse(Queue<Integer> queue, int k) {
        var stack = new Stack<Integer>();

        var i = 0;
        while (i < k) {
            stack.push(queue.remove());
            i++;
        }
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        var j = 0;
        while (j < (queue.size() - k)) {
            queue.add(queue.remove());
            j++;
        }
        return queue;

    }
}

// var queue = new ArrayDeque<Integer>();
// queue.add(10);
// queue.add(20);
// queue.add(30);
// queue.add(40);
// queue.add(50);
// var reverseAQueue = new ReverseKthElements();
// System.out.println(reverseAQueue.reverse(queue, 3));