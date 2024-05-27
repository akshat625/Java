package DisjointSet;

public class Optimization {
    private int parent[];
    private int rank[];

    public Optimization(int size){
        parent = new int[size];
        rank = new int[size];
        for(int i=0;i<size;i++){
            parent[i]=i;
            rank[i]=0;
        }
    }

    public int find(int x){
        if(parent[x]!=x)
            parent[x] = find(parent[x]);    //Path compression
        return parent[x];
    }

    public void union(int x,int y){         //Union by rank
        int rootX = find(x);
        int rootY = find(y);

        if(rootX!=rootY){
            if(rank[rootX]>rank[rootY])
                parent[rootY]=rootX;
            else if(rank[rootY]>rank[rootX])
                parent[rootX]=rootY;
            else{
                parent[rootY]=rootX;
                rank[rootX]++;
            }

        }
    }

    public boolean isSet(int x,int y){
        return find(x)==find(y);
    }

    public static void main(String[] args) {
        Optimization ds = new Optimization(10);
        ds.union(1,2);
        ds.union(3,6);
        ds.union(6,8);
        ds.union(2,3);

        System.out.println(ds.isSet(1,6));
        System.out.println(ds.isSet(1,7));
        System.out.println(ds.isSet(2,3));

        System.out.println(ds.find(7));
    }
}
