package Heap;
import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQ {
    public static void main(String[] args) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(15);
        minHeap.add(5);
        minHeap.add(8);
        minHeap.offer(4);       //same as minHeap.add(4);
        minHeap.offer(1);
        minHeap.add(13);

        System.out.println("Peek - "+minHeap.peek());

        while(!minHeap.isEmpty())
            System.out.print(minHeap.poll() + " ");
        System.out.println("\n");




        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(5);
        maxHeap.add(8);
        maxHeap.offer(4);       //same as maxHeap.add(4);
        maxHeap.offer(1);
        maxHeap.add(13);

        System.out.println(maxHeap.peek());

    }



}
