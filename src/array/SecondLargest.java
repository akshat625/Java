package array;

import java.util.Arrays;

public class SecondLargest {

    static int secLargest(int[] arr){
        int max = Integer.MIN_VALUE;
        int secMax = Integer.MIN_VALUE;

        for(int num : arr){
            if(num > max){
                secMax = max;
                max = num;
            }
            else{
                if(num > secMax || num == max)
                    secMax = num;
            }
        }
        return secMax;
    }


    public static void main(String[] args) {
    int[] arr = {32,12,51,3,67,21};
        System.out.println(secLargest(arr));
//        System.out.println(Arrays.toString(arr));
    }
}
