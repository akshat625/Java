package array;

import java.util.*;

public class SymmetricPairs {

    public static void findSymmetricPairs(int[][] arr) {
        // Create a HashMap to store pairs as key-value
        Map<Integer, Integer> map = new HashMap<>();

        System.out.println("Symmetric Pairs:");

        // Traverse the array
        for (int[] pair : arr) {
            int first = pair[0];
            int second = pair[1];

            // Check if the symmetric pair (second, first) exists in the map
            if (map.containsKey(second) && map.get(second) == first) {
                // Print the symmetric pair
                System.out.println("(" + first + ", " + second + ")");
            } else {
                // Otherwise, store the current pair in the map
                map.put(first, second);
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = {
                {10, 20},
                {30, 40},
                {50, 60},
                {20, 10},
                {40, 30}
        };

        findSymmetricPairs(arr);
    }
}
