import Queues.StackUsingQueue;

class Main {
    public static void main(String[] args) {
        var stack = new StackUsingQueue();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        stack.push(40);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        stack.print();

    }
}
