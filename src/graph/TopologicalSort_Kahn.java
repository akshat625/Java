package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort_Kahn extends Graph{
    public TopologicalSort_Kahn(int vertices){
        super(vertices);
    }

    public ArrayList<Integer> topologicalSort(){
        int[] indegree = new int[vertices];

        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>(vertices);

        //Calculate indegrees of all vertices
        for(int i=0;i<vertices;i++){
            for(int neighbor : list.get(i))
                indegree[neighbor]++;
        }

        //Add 0 indegree vertices to the queue
        for(int i=0;i<vertices;i++){
            if(indegree[i]==0)
                queue.add(i);
        }

        //Process vertices in topological order
        while (!queue.isEmpty()){
            int currentVertex = queue.poll();
            result.add(currentVertex);

            // Decrease the in-degree of each neighbor and add them to the queue if in-degree becomes 0
            for (int neighbor : list.get(currentVertex)){
                indegree[neighbor]--;
                if(indegree[neighbor]==0)
                    queue.add(neighbor);
            }
        }

        if(result.size() != vertices){
            System.out.println("The graph contains a cycle.Topological sort is not possible");
            return new ArrayList<>();
        }

        return result;
    }

    public static void main(String[] args) {
        TopologicalSort_Kahn sort = new TopologicalSort_Kahn(4);

        sort.addEdge(0, 1);
        sort.addEdge(1, 2);
        sort.addEdge(2, 3);
        sort.addEdge(1, 3);
//        sort.addEdge(4, 5);
//        sort.addEdge(5, 3);

        System.out.println(sort.topologicalSort());
        sort.print();
    }
}
