package Heap;

public class Operations extends Heap{

    Operations(int capacity){
        super(capacity);
    }

    public void insert(int value){
        if(size==capacity) {
            System.out.println("Cannot insert into heap.Heap capacity reached.");
            return;
        }
        heap[size] = value;
        size++;
        int i=size-1;
        while(heap[parent(i)] > heap[i]   && i>0){
            swap(i,parent(i));
            i = parent(i);
        }
    }

    private void heapify(int key) {
        int minIndex = key;
        int left = left(key);
        int right = right(key);

        if (left < size && heap[left] < heap[minIndex]) {
            minIndex = left;
        }

        if (right < size && heap[right] < heap[minIndex]) {
            minIndex = right;
        }

        if (key != minIndex) {
            swap(key, minIndex);
            heapify(minIndex);
        }
    }

    public void extractMin() {
        if (size == 0) {
            System.out.println("Heap is Empty. Cannot extract minimum element.");
            return ;
        }

        swap(0, size - 1);
        size--;
        heapify(0);

    }

    public void decreaseKey(int key, int value){
        if (key < 0 || key >= size) {
            System.out.println("Invalid index for decreaseKey.");
            return;
        }

        heap[key] = value;
        while(heap[parent(key)] > heap[key]  && key>0){
            swap(key,parent(key));
            key=parent(key);
        }
    }

    public void delete(int key){
        if(key<0 || key>=size){
            System.out.println("Invalid index for delete.");
            return;
        }

        decreaseKey(key,Integer.MIN_VALUE);
        extractMin();
    }

    public void buildHeap(int[] arr) {
        this.heap=arr;
        this.size=arr.length;
        for (int i = (size / 2) - 1; i >= 0; i--) {
            heapify(i);
        }
    }




    public static void main(String[] args) {
        Operations op = new Operations(10);
//        op.insert(30);
//        op.insert(50);
//        op.insert(20);
//        op.insert(40);
//        op.insert(10);
//        op.insert(60);
//        op.insert(4);
//        op.insert(5);
//
//
//        op.printHeap();
//        op.extractMin();
//        op.printHeap();
//        op.decreaseKey(5,1);
//        op.printHeap();

        int[] arr = {9, 5, 2, 7, 1, 8};
        op.buildHeap(arr);
        op.printHeap();
    }
}
