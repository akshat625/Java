package Greedy;

import java.util.HashMap;

class Node implements Comparable<Node>{
    char data;
    int cost; //frequency
    Node left = null;
    Node right = null;

    @Override
    public int compareTo(Node node) {
        return this.cost - node.cost;
    }
}
public class HuffmanCoding {

    public static void huffmanEncoder(String feeder){
        HashMap<Character,String> encoder;
        HashMap<String,Character> decoder;
    }

}
