package graph;


class CycleUndirected extends Graph {

    public CycleUndirected(int vertices) {
        super(vertices);
    }

    public boolean hasCycle() {
        boolean[] visited = new boolean[vertices];

        for (int i = 0; i < vertices ; i++) {
            if (!visited[i] && hasCycleDFS(i,-1,visited));
                return true;
        }
        return false;
    }

    private boolean hasCycleDFS(int currentVertex, int parent, boolean[] visited) {
        visited[currentVertex]=true;

        for(int neighbor: list.get(currentVertex))
        {
            if(!visited[neighbor]){
                if(hasCycleDFS(neighbor,currentVertex,visited))
                    return true;
            }
            else if (parent!=neighbor) {
                return true;
            }
        }


        return false;
    }

    public static void main(String[] args) {
        int vertices = 6;

        CycleUndirected cycleGraph = new CycleUndirected(vertices);

        // Adding edges to create a cycle
        cycleGraph.addEdge(0, 1);
        cycleGraph.addEdge(1, 2);
        cycleGraph.addEdge(2, 0);
        cycleGraph.addEdge(1, 3);
        cycleGraph.addEdge(3, 4);
        cycleGraph.addEdge(4, 5);
        cycleGraph.addEdge(5, 3);

        // Checking for cycles
        if (cycleGraph.hasCycle()) {
            System.out.println("The graph contains a cycle.");
        } else {
            System.out.println("The graph does not contain a cycle.");
        }
    }


}



