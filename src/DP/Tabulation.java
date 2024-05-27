package DP;

public class Tabulation {

    public static int fib(int n){
        if(n==0)
            return 0;
        int[] fib = new int[n+1];
        fib[0]=0;
        fib[1]=1;

        for(int i=2;i<fib.length;i++)
            fib[i] = fib[i-1] + fib[i-2];

        return fib[n];
    }

    public static void main(String[] args) {
        System.out.println(fib(10));

    }
}
