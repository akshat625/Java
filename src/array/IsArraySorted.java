package array;

public class IsArraySorted {

    static boolean isSorted(int arr[]){
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]<=arr[i+1]){
                continue;
            }
            return false;
        }

        return true;
    }

    public static void main(String[] args) {

        int[] arr = {1,3,3,3,3,3,3};
        System.out.println(isSorted(arr));

    }
}
