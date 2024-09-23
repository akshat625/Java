package array;

import basicProblems.ReverseArray;

import java.util.Arrays;

public class RotateArray extends ReverseArray {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7};
        int k = 4;
        rotateRight(arr,k);
//        rotateLeft(arr,k);
        System.out.println(Arrays.toString(arr));
    }

    private static void rotateLeft(int[] arr, int k) {
        rotateRight(arr,arr.length-k);
//        reverse(arr,0,arr.length-1);
//        reverse(arr,0,arr.length-k-1);
//        reverse(arr,arr.length-k,arr.length-1);
    }

    public static void rotateRight(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }
}
