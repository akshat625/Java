package Bit;
//check whether the kth bit is set or not
public class KthBitSet {
    public static void main(String[] args) {
        int x = 5;
        int k = 2;
        kthLeft(x,k);
        kthRight(x,k);
    }

    private static void kthRight(int x, int k) {
        if((x>>(k-1) & 1) == 1)
            System.out.println("yes");
        else
            System.out.println("no");
    }

    private static void kthLeft(int x, int k) {
        if((x & (1<<(k-1))) != 0)
            System.out.println("yes");
        else
            System.out.println("no");

    }
}
