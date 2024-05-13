package lectures;

import java.util.Arrays;

public class Lecture6 {
    // sorting and binary search
    public static void main(String[] args){
        // selection
        int[] myArray = {2, 3, 7, 5, 3, 9, 7, 3};

        // insertion sort:
        /*
        create secondary array
        take one item
        if there are x smaller items, insert into the x place in new
         */
        int [] newArray = new int[myArray.length];
        int counter;
        for (int value : myArray) {
            counter = 0;
            for (int k : myArray) {
                if (value > k) {
                    counter++;
                }
            }
            newArray[counter] = value;
        }
        System.out.println(Arrays.toString(newArray));
        /*
        fix the zeroes, they should be the same as the last index that isn't zero
         */
        int a, b, c;
        for(int i=0; i<newArray.length; i++){
            a = newArray[i]; b=1;
            while(i+b<newArray.length && newArray[i+b]==0){
                c = i+b;
                newArray[c]=a;
                b++;
            }
        }
        System.out.println(Arrays.toString(newArray));

        // bubble sort
        myArray = new int[]{2, 3, 7, 5, 0, 3, 9, 7, 3};
        int t;
        for(int i=myArray.length-1; i>0; i--){
            for(int j=0; j<i; j++){
                if(myArray[j]>myArray[j+1]){
                    t = myArray[j];
                    myArray[j] = myArray[j+1];
                    myArray[j+1] = t;
                }
            }
        }
        System.out.println(Arrays.toString(myArray));

        /*
        if length==0 || 1
        sorted
        else:
        split into 2
        sort each half
        merge.
        recursive.
         */

        // quicksort:

        // merge sort:

    }
}
