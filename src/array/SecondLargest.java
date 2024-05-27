package array;

import java.util.Arrays;

public class SecondLargest {

    static int secLargest(int[] arr){
        int res=-1;
        int largest = 0;
        for(int i =1;i< arr.length;i++){
            if(arr[i]>arr[largest]){
                res=largest;
                largest=i;
            } else if (arr[i]!=arr[largest]) {
                if(res==-1 || arr[i]>arr[res])
                    res=i;
            }
        }
        return res;
    }


    public static void main(String[] args) {
    int[] arr = {32,12,51,3,67,21};
//        System.out.println(secLargest(arr));
        System.out.println(Arrays.toString(arr));
    }
}
