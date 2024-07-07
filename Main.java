import Heaps.Heap;

class Main {
    public static void main(String[] args) {
        var heap = new Heap(5);
        heap.insert(20);
        heap.insert(10);
        heap.insert(16);
        heap.insert(15);
        heap.insert(5);
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        // System.out.println(heap.remove());
    }
}
