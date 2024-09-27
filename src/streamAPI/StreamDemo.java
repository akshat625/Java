package streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        List<Integer> even = list.stream()
                                .filter(i -> i%2==0)
                                .toList();

        System.out.println(even);


        int[] arr = {1,2,3,4,5};
        IntStream intStream = Arrays.stream(arr);
        System.out.println(intStream.sum());


    }
}
