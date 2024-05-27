package sort;

public class QuickSort {

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int length = arr.length;
        quickSort(arr, 0, length - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high);

            // Recursively sort elements before and after partition
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;

                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i+1] and arr[high] (pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {        int[] arr = {10, 7, 8, 9, 1, 5};
        System.out.println("Original array:");
        printArray(arr);

        quickSort(arr);

        System.out.println("Sorted array:");
        printArray(arr);
    }
}
