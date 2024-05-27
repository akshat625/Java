package sort;

import java.util.Arrays;

public class HeapSort {

    private void buildHeap(int[] arr, int n){
        for (int i = (n-2)/2; i >=0 ; i--) {
            maxHeapify(arr,n,i);
        }
    }

    private void maxHeapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);
            maxHeapify(arr, n, largest);
        }
    }




    private void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public void heapSort(int[] arr, int n){
        buildHeap(arr,n);
        for(int i=n-1;i>0;i--){
            swap(arr, 0,i);
            maxHeapify(arr,i,0);
        }
    }

    public static void main(String[] args) {
        int[] arr={5,3,6,85,31,2};
        HeapSort sort = new HeapSort();
        System.out.println(Arrays.toString(arr));

        sort.heapSort(arr,6);

        System.out.println(Arrays.toString(arr));


    }
}
