package array;

import java.util.HashMap;
import java.util.Map;

public class SortArrayByFrequency {

    static void sort(int[] arr){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : arr){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue()==1)
                System.out.println(entry.getKey());

        }
//        System.out.println(map.size());
    }

    public static void main(String[] args) {
        int[] arr = {20,50,30,20,40,70,40,10};
        sort(arr);

    }
}
