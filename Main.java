import Queues.ArrayQueue;

class Main {
    public static void main(String[] args) {
        var queue = new ArrayQueue(5);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        System.out.println(queue.isEmpty());
        System.out.println(queue.peek());
        System.out.println(queue.remove());
        System.out.println(queue.peek());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.isEmpty());
        queue.print();
    }
}
