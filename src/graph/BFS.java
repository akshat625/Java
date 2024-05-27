package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS extends Graph{

    public BFS(int vertices) {
        super(vertices);
    }

    public void bfs(int source)
    {
        Queue<Integer> q =  new LinkedList<>();
        boolean[] visited = new boolean[vertices];
        visited[source] = true;
        q.add(source);

        while(!q.isEmpty())
        {
            int currentVertex= q.poll();
            System.out.print(currentVertex + " ");
            for(int neighbour : list.get(currentVertex))
            {
                if (!visited[neighbour])
                {
                    visited[neighbour]=true;
                    q.add(neighbour);

                }
            }
        }

    }

    public static void main(String[] args) {

        BFS Bfs= new BFS(5);

        Bfs.addEdge(0,1);
        Bfs.addEdge(0,2);
        Bfs.addEdge(1,2);
        Bfs.addEdge(1,3);
        Bfs.addEdge(2,3);
        Bfs.addEdge(3,4);

        Bfs.bfs(0);

        System.out.println();
        System.out.println();

        Bfs.print();
    }
}
