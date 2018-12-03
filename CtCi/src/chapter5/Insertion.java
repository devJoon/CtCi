package chapter5;

public class Insertion {

    public static int insert(int N, int M, int i, int j) {

        System.out.println("N : " + Integer.toBinaryString(N));
        System.out.println("M : " + Integer.toBinaryString(M));
        System.out.println("i : " + i + " , j : " + j);

        int mask1 = -1 << j+1;
        int mask2 = ~(-1 << i);
        int mask3 = mask1 | mask2;

        /*System.out.println(Integer.toBinaryString(mask1));
        System.out.println(Integer.toBinaryString(mask2));
        System.out.println(Integer.toBinaryString(mask3));*/

        int result = (N & mask3) | (M << i);
        System.out.println("Result : " + Integer.toBinaryString(result));

        return result;
    }

    public static void main(String[] args) {

        Insertion.insert(1024, 19, 2, 6);
    }

}
