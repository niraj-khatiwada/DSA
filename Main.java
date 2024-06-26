import Hashmap.HashMap;

class Main {
    public static void main(String[] args) {
        var map = new HashMap(5);

        map.put(1, "a");
        map.put(2, "b");
        map.put(6, "f");
        System.out.println(map.size());
        System.out.println(map.containsKey(1));
        System.out.println(map.get(1));
        map.put(1, "A");
        System.out.println(map.get(1));
        map.remove(1);
        map.remove(6);
        map.remove(100);
        System.out.println(map.size());
        System.out.println(map.containsKey(1));
        System.out.println(map.get(1));

        System.out.println(map);
    }
}
