package basicProblems;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7};
        reverse(arr,0,3);
        System.out.println(Arrays.toString(arr));
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void reverse(int[] nums,int start,int end){
        for(int i=start;i<=(start+end)/2;i++){
            swap(nums,i,start+end-i);
        }
    }

}
