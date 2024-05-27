package backtracking;

import java.util.Arrays;

public class BackMaze{

static void printPath(String p,int r, int c, boolean[][] visited, int[][] path, int step){

    if(r == visited.length-1 && c == visited[0].length - 1){
        path[r][c] = step;
        for(int[] arr : path)
            System.out.println(Arrays.toString(arr));

        System.out.println(p);
        System.out.println();

        return;
    }

    //obstacle
    if(!visited[r][c])
        return;

    //bt
    visited[r][c]=false;
    path[r][c]=step;

    if(r<visited.length-1)
        printPath(p+"D",r+1,c,visited,path,step+1);

    if(c<visited[0].length-1)
        printPath(p+"R",r,c+1,visited,path,step+1);

    if(r>0)
        printPath(p+"U",r-1,c,visited,path,step+1);

    if(c>0)
        printPath(p+"L",r,c-1,visited,path,step+1);


    //bt
    visited[r][c]=true;
    path[r][c]=0;

}

    public static void main(String[] args) {

    boolean[][] visited = {{true,true,true},
                            {true,false,true},
                             {true,true,true},
                            {true,true,true}
    };



    int[][] path = new int[visited.length][visited[0].length];


    printPath("",0,0,visited,path,1);

    }
}
