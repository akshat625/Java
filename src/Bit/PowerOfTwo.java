package Bit;

public class PowerOfTwo {
    public static void main(String[] args) {
        int x = 8;
        System.out.println(power(x));
    }


    private static boolean power(int x) {
        if(x==0)
            return false;
        return ((x & (x-1)) == 0);
        //one line expression
        // return (x!=0) && (x & (x-1) == 0);
    }
}
