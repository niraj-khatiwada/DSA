import java.util.Queue;
import java.util.ArrayDeque;
import Queues.Reverse;

class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        var reverse = new Reverse();
        System.out.println(queue.peek());
        System.out.println(reverse.reverse(queue));
        System.out.println(queue.peek());

    }
}
