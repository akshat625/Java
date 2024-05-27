package DisjointSet;

public class Implementation {
    private int[] parent;

    public Implementation(int size){
        parent = new int[size];
        for(int i=0;i<size;i++)
            parent[i]=i;
    }

    public int find(int x){
        if(parent[x]==x)
            return x;
        else
            return find(parent[x]);
    }

    public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);

        if(rootX!=rootY)
            parent[rootY]=rootX;
    }

    public boolean isSet(int x,int y){
        return find(x)==find(y);
    }

    public static void main(String[] args) {
        Implementation ds = new Implementation(10);
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


