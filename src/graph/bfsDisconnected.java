package graph;


import java.util.LinkedList;
import java.util.Queue;

public class bfsDisconnected extends Graph{
    bfsDisconnected(int vertices) {
        super(vertices);
    }

    public void bfs(){
        boolean[] visited = new boolean[vertices];
        for(int i=0;i<vertices;i++)
        {
            if(!visited[i]){
               bfs(i,visited);
            }
        }
    }

    private void bfs(int source, boolean[] visited) {
        Queue<Integer> q = new LinkedList<Integer>();
        visited[source]=true;
        q.add(source);

        while(!q.isEmpty()){
            int currentVertex= q.poll();
            System.out.print(currentVertex + " ");
            for(int neighbour : list.get(currentVertex))
            {
                if(!visited[neighbour]){
                    visited[neighbour]=true;
                    q.add(neighbour);
                }
            }

        }

    }

    public static void main(String[] args){
        bfsDisconnected Bfs = new bfsDisconnected(7);

        Bfs.addEdge(0, 1);
        Bfs.addEdge(0, 2);
        Bfs.addEdge(1, 2);


        Bfs.addEdge(3, 4);
        Bfs.addEdge(5, 6);



        Bfs.bfs();
        System.out.println();
        System.out.println();
        Bfs.print();
    }
}
