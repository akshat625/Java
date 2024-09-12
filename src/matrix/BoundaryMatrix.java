package matrix;

public class BoundaryMatrix {
    public static void main(String[] args) {
//        int arr[][] = {{1, 2, 3, 4},
//                {5, 6, 7, 8},
//                {9, 10, 11, 12},
//                {13, 14, 15, 16}};

//        int arr[][] = {{1},{2},{3},{4}};
        int arr[][] = {{1,2,3,4}};

                printBoundaryMatrix(arr);
    }

    private static void printBoundaryMatrix(int[][] arr) {

        int l = arr.length-1;

        for(int j=0;j<arr[0].length;j++){
            System.out.print(arr[0][j]+" ");
        }
        for(int i=1;i<arr.length;i++){
            System.out.print(arr[i][arr[i].length-1] +" ");
        }

        for(int i = arr[l].length-2;i>=0;i--){
            System.out.print(arr[l][i]+" ");
        }

        for(int i=l-1;i>=1;i--){
            System.out.print(arr[i][0] +" ");
        }

    }
}
