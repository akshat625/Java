package string;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class FrequencyCount {



    public static void main(String[] args) {
        String input = "programming";
        getCharacterFrequency(input);

    }

    private static void getCharacterFrequency(String input) {
        LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();

        for(char ch : input.toCharArray())
            map.put(ch,map.getOrDefault(ch,0)+1);

        map.forEach((key,value) -> System.out.println(key + "->"+ value));
    }
}
