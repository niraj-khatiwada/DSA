package HashMaps;

public class Main {
    public static void main(String[] args) {
        HashMap map = new HashMap(10);
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");
        map.remove(8);
        System.out.println(map.get(3));
    }
}