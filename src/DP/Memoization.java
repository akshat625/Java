package DP;

import java.util.HashMap;
import java.util.Map;

public class Memoization {
    static HashMap<Integer,Integer> memo = new HashMap<>();

    public static int fib(int n){
        if(n<=1)
            return n;

        if(memo.containsKey(n))
            return memo.get(n);

        int res = fib(n-1) + fib(n-2);
        memo.put(n,res);

        return res;
    }
    public static void main(String[] args) {

        System.out.println(fib(50));


    }
}
