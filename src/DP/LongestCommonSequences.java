package DP;

import java.util.HashMap;

public class LongestCommonSequences {
    //Memoization
    static HashMap<String,Integer> memo = new HashMap<>();
    public static int lcsMemoization(String s1,String s2){
        int m = s1.length();
        int n = s2.length();

        String key = m + " | " + n;

        if(memo.containsKey(key))
            return memo.get(key);

        if(m==0 || n==0)
            return 0;

        if(s1.charAt(m-1) == s2.charAt(n-1)) {
            int result =  1 + lcsMemoization(s1.substring(0, m - 1), s2.substring(0, n - 1));
            memo.put(key,result);
            return result;
        }
        else {
            int result = Math.max(lcsMemoization(s1,s2.substring(0,n-1)),lcsMemoization(s1.substring(0,m-1),s2));
            memo.put(key,result);
            return result;
        }
    }

    public static int lcsTabulation(String s1,String s2){
        int m = s1.length();
        int n = s2.length();

        int dp[][] = new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
            }
        }
        return dp[m][n];
    }


    public static void main(String[] args) {

        String text1 = "AGGTAB";
        String text2 = "GXTXAYB";

        System.out.println("Length of LCS: " + lcsMemoization(text1, text2));
        System.out.println("Length of LCS: " + lcsTabulation(text1, text2));



    }
}
