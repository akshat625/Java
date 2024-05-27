package graph;

public class DFS extends Graph{

    public DFS(int vertices){
        super(vertices);
    }

    public void dfs(int source){
        boolean[] visited = new boolean[vertices];
        dfsRec(source,visited);
    }

    private void dfsRec(int currentVertex, boolean[] visited) {
        visited[currentVertex]= true;
        System.out.print(currentVertex + " ");
        for(int neighbour: list.get(currentVertex))
        {
            if(!visited[neighbour])
                dfsRec(neighbour,visited);
        }
    }

    public static void main(String[] args) {

        DFS Dfs = new DFS(7);

        Dfs.addEdge(0, 1);
        Dfs.addEdge(1, 2);
        Dfs.addEdge(1, 3);
        Dfs.addEdge(2, 6);
        Dfs.addEdge(3, 4);
        Dfs.addEdge(4, 5);

        Dfs.dfs(0);
        System.out.println();
        System.out.println();
        Dfs.print();

    }
}
