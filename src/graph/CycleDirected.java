package graph;

public class CycleDirected extends Graph{
    public CycleDirected(int vertices){
        super(vertices);
    }

    public boolean hasCycle(){
        boolean[] visited = new boolean[vertices];
        boolean[] stackRec = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            if(!visited[i] && hasCycleDFS(i,visited,stackRec))
                return true;
        }
        return false;
    }

    private boolean hasCycleDFS(int currentVertex, boolean[] visited, boolean[] stackRec) {
        visited[currentVertex] = true;
        stackRec[currentVertex] = true;

        for(int neighbor : list.get(currentVertex)){
            if(!visited[neighbor])
            {
                if (hasCycleDFS(neighbor,visited,stackRec))
                    return true;
            } else if (stackRec[neighbor]) {
                    return true;
            }
        }
        stackRec[currentVertex]=false;
        return false;
    }

    public static void main(String[] args) {
        CycleDirected cycleDirected = new CycleDirected(6);

        cycleDirected.addEdge(0, 1);
        cycleDirected.addEdge(2, 1);
        cycleDirected.addEdge(2, 3);
        cycleDirected.addEdge(3, 4);
        cycleDirected.addEdge(4, 5);
        cycleDirected.addEdge(5, 3);

        if (cycleDirected.hasCycle()) {
            System.out.println("The directed graph contains a cycle.");
        } else {
            System.out.println("The directed graph does not contain a cycle.");
        }
    }
}
