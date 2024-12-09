package array;

public class RemoveDuplicates {

    static int removeDuplicates(int[] arr){
        int j=0;
        for(int i =0;i<arr.length;i++){
            if(arr[j] != arr[i]){
                arr[++j] = arr[i];
            }
        }
        return j + 1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,2,2,3,3,4,5,6,6,7,7};
        System.out.println(removeDuplicates(arr));
        for(int i=0; i<7;i++)
            System.out.print(arr[i]+" ");
    }
}
