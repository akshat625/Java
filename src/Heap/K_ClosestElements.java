package Heap;

import java.util.*;

class Items implements Comparable<Items>{
    int element;
    int index;

    public Items(int element, int index) {
        this.element = element;
        this.index = index;
    }

    @Override
    public int compareTo(Items o) {
        return Math.abs(this.element) - Math.abs(o.element);
    }
}


public class K_ClosestElements {

    public static void kClosest(int[] arr, int x ,int k){

        int[] diff = new int[arr.length];
        for(int i=0;i< arr.length;i++)
            arr[i] = Math.abs(arr[i]-x);


        PriorityQueue<Map<Integer,Integer>> pq = new PriorityQueue<>();

        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<diff.length;i++)
            map.put(diff[i],i);

        pq.add(map);

        for(int i=0;i<k;i++){
            Map<Integer, Integer> m = pq.poll();
            for (int ii = 0; ii < diff.length; ii++) {
                System.out.println("Value at index " + ii + ": " + m.get(diff[ii]));
            }
        }


    }


    public static void main(String[] args) {
        int[] arr = {10,15,7,3,4};
        kClosest(arr,8,2);

    }
}
