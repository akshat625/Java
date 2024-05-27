package array;

import java.util.ArrayList;
import java.util.Arrays;

import static  java.util.Collections.swap;

public class RemoveZeroes {

    static ArrayList<Integer> removeZeroes(ArrayList<Integer> arr){
        var count=0;

        for (int i = 0; i < arr.size(); i++) {
            if(arr.get(i)!=0){
                swap(arr,i,count);
                count++;
            }

        }
    return arr;
    }

    public static void main(String[] args) {
        ArrayList arr = new ArrayList<>(Arrays.asList(10,8,0,0,5,3,0,1));
        System.out.println(removeZeroes(arr));

    }
}
