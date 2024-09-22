package basicProblems;



public class CountSteps {
    public static void main(String[] args) {
        int n = 8;
        System.out.println(countSteps(n));
    }

    private static int countSteps(int n) {
        return helper1(n,0);
    }

    private static int helper1(int n, int c) {
        if(n==0)
            return c;

        if(n%2==0)
            return helper1(n/2,c+1);
        return helper1(n-1,c+1);

    }
}
