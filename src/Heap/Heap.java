package Heap;

public class Heap {
    protected int size;
    protected int capacity;
    protected int[] heap;


    public Heap(int capacity){
        this.capacity=capacity;
        this.size=0;
        this.heap = new int[capacity];
    }

    protected int left(int i){
        return 2*i + 1;
    }

    protected int right(int i){
        return 2*i + 2;
    }

    protected int parent(int i){
        return (i-1)/2;
    }

    protected void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    protected void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }


}
