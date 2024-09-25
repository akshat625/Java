package hashing;

import java.util.HashSet;
import java.util.Set;

public class UnionOfUnsortedArray {
    public static void main(String[] args) {
        int arr1[] = {1,2,3,4,5};
        int arr2[] = {1,2,3,8,4,44,1,1,3};
        System.out.println(unionUnsorted(arr1,arr2));//5
    }

    private static int unionUnsorted(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        for(int i:arr1){
            set.add(i);
        }
        for(int i:arr2){
                set.add(i);
        }
        return set.size();
    }
}
