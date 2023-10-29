import java.util.Arrays;

public class Array {
    private int originalLength = 0;
    public int length = 0;
    private int index = 0;
    private int[] array;

    public Array(int length){
        this.length = length;
        this.originalLength = length;
        this.array = new int[length];
    }

    public int[] insert(int newValue){
        if(this.index < this.originalLength){
            this.array[this.index] = newValue;
            this.index++;
            return this.array;
        }else {
            this.length = this.originalLength;
        }
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
        int[] newArray = new int[(this.length) > this.originalLength ? (this.length - 1): this.originalLength ];
        System.out.println(newArray.length);
        for(int i=0; i < this.length; i++){
            if(i != index){
                newArray[i > index ? (i-1): i] = this.array[i];
            }
        }
        this.array = newArray;
        this.length--;
        if(this.length < (this.index + 1) && this.length > 0){
            this.index--;
        }
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

    public void printToConsole(){
      System.out.println(Arrays.toString(this.array));
    }
}
