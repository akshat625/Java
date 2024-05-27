package Heap;

import java.util.*;

public class K_LargestElements {

    public static void kLargest(int[] arr,int k){

        //Approach 1 : Naive approach(Using Sorting)

//        Arrays.sort(arr);
//        for(int i= arr.length-1;i>= arr.length-k;i--)
//            System.out.print(arr[i] + " ");






        //Approach 2 : MaxHeap
//        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
//        for (int i=0;i<arr.length;i++)
//            pq.add(arr[i]);
//
//        while(k!=0){
//            System.out.print(pq.poll()+" ");
//            k--;
//        }






        //Approach 3 : Using MinHeap(Better approach)
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for(int i = 0;i<k;i++)
            pq.add(arr[i]);

        for(int i = k; i< arr.length;i++){
            if(arr[i] > pq.peek()){
                pq.poll();
                pq.add(arr[i]);
            }
        }

        while (!pq.isEmpty()){
            System.out.print(pq.poll()+ " ");
        }


    }

    public static void main(String[] args) {
        int[] arr = {5,15,10,20,8,25,18};
        kLargest(arr,4);
    }
}
