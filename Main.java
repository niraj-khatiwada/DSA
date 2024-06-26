import Hashmap.CountUniquePairsWithDiffK;

class Main {
    public static void main(String[] args) {
        var map = new CountUniquePairsWithDiffK();
        int[] array = { 1, 7, 5, 9, 2, 12, 3 };
        System.out.println(map.count(array, 2));
    }
}
