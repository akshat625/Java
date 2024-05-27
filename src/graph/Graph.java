package graph;

import java.util.ArrayList;

public class Graph{
    protected static ArrayList<ArrayList<Integer>> list;
    protected int vertices;
    Graph(int vertices){
        this.vertices=vertices;
        list = new ArrayList<>(vertices);

        for(int i=0;i<vertices;i++)
            list.add(new ArrayList<>());
    }

    public void addEdge(int source, int destination)
    {
        list.get(source).add(destination);
//        list.get(destination).add(source);
    }

    public void print()
    {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}






