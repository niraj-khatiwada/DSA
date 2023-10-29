import java.util.Arrays;

public class Array {

    public int length = 0;
    private int index = 0;
    private int[] array;

    public Array(){
        this.array = new int[0];
    }

    public int[] insert(int newValue){
        int[] newArray = new int[this.length+1];
        if(this.length > 0){
            for(int i = 0; i < this.length ; i++){
                newArray[i] = this.array[i];
            }
        }
        newArray[this.length] = newValue;
        this.length++;
        this.array = newArray;
        return newArray;
    }

    public int[] removeAt(int index){
        if(index > (this.length -1)){
            throw new Error("Index out of range");
        }
        int[] newArray = new int[this.length - 1];
        for(int i=0; i < this.length; i++){
            if(i != index){
                newArray[i > index ? (i-1): i] = this.array[i];
            }
        }
        this.array = newArray;
        this.length--;
        return  newArray;

    }

    public int indexOf(int value){
        int index = -1;
        for(int i = 0; i < this.length ; i++){
            if(this.array[i] == value){
                index = i;
            }
        }
        return index;
    }

    public int[] reverse(){
        int[] newArray = new int[this.length];
        for(int i = 0; i < this.length ; i++){
            newArray[this.length - 1 - i] = this.array[i];
        }
        return newArray;
    }

    // [1, 2, 3]
    // 0 -> [-1, 1, 2, 3]
    // 1 -> [1, -1, 2, 3]
    // 2-> [1, 2, -1,  3]
    // 3-> [1, 2, 3, -1]
    // It's simple. If the insert index >= current index shift the value else keep the same. That's it.
    public int[] insertAt(int index, int value){
        if(index > this.length){
            throw new Error("Index out of bound");
        }
        int[] newArray = new int[this.length + 1];
        for(int i = 0; i < this.length; i++){
            if(i < index){
                newArray[i] = this.array[i];
            } else {
                newArray[i + 1] = this.array[i];
            }
        }
        newArray[index] = value;
        this.length++;
        this.array = newArray;
        return newArray;
    }

    public void printToConsole(){
      System.out.println(Arrays.toString(this.array));
    }
}
