public class Main{
    public static void main(String[] args){

        constantTimeComplexity(); // O(1)
        linearTimeComplexity(); // O(n)
        quadraticTimeComplexity(); // O(n^2)

    }

    public static void constantTimeComplexity(){
        String[] list  = {"Hello","Wold"};
        String val = list[0];
        String val2 = list[1];
    }

    // Linear Search has linear time complexity
    public static void linearTimeComplexity(){
        String[] list  = {"Hello","Wold"};
        for(String val: list){
            System.out.println(val);
        }
    }

    public static void quadraticTimeComplexity(){
        String[] list  = {"Hello","Wold"};
        for(String val: list){
            for(String val2: list){
                System.out.println(val);
                System.out.println(val2);
            }
        }
    }

    // Most performant one
    // Binary Search has logarithmic time complexity
    public static void logarithmicTimeComplexity(){
        // ...
    }

    // Worst performant one
    // Opposite of logarithmic growth
    public static void exponentialTimeComplexity(){
        // ...
    }

    public static void spaceTimeComplexity(String[] array){
        // Space complexity of newArray is O(n)
        String[] newArray = new String[array.length];
        // Space complexity of i is O(1)
        for(int i = 0; i < array.length ; i++){
            System.out.println(i);
        }
    }
}