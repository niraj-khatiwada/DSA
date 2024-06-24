import Queues.StackQueue;

class Main {
    public static void main(String[] args) {
        var queueUsingStack = new StackQueue();
        queueUsingStack.add(1);
        queueUsingStack.add(2);
        queueUsingStack.add(3);
        queueUsingStack.remove();
        queueUsingStack.remove();
        queueUsingStack.print();
    }
}
