package Greedy;

import java.util.Comparator;

class Nodes implements Comparator<Node>{

    int data;

    @Override
    public int compare(Node o1, Node o2) {
        return o1.data-o2.data;
    }
}
public class OptimalMergePattern {
}
