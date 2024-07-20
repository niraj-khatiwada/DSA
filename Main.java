import Search.LinearSearch;

class Main {

    public static void main(String[] args) {
        var search = new LinearSearch();

        System.out.println(search.find(new int[] { 1, 2, 3 }, -3));
    }

}
