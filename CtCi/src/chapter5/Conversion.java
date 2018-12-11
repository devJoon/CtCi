package chapter5;

public class Conversion {

    public static int count(int a, int b) {
        int cnt = 0;
        while (a!= 0 || b!= 0) {
            if ((a&1) != (b&1)) {
                cnt++;
            }
            a >>>= 1;
            b >>>= 1;
        }

        return cnt;
    }

    /* We can use XOR */
    public static int bitSwapRequired(int a, int b) {
        int count = 0;
        for (int c = a^b; c!=0; c=c>>>1) {
            count += c & 1;
        }
        return count;
    }

    /* Simplified version */
    public static int bitSwapRequired2(int a, int b) {
        int count = 0;
        for (int c = a^b; c!=0; c=c&(c-1)) { // c&(c-1) clears rightmost 1
            count++;
        }
        return count;
    }

    public static void main(String[] args){

        int a = -1354524342;
        int b = 254;

        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));

        System.out.println(count(a, b));
        System.out.println(bitSwapRequired(a, b));
        System.out.println(bitSwapRequired2(a, b));


/*        int c = Integer.MIN_VALUE;
        System.out.println(Integer.toBinaryString(c));
        System.out.println(Integer.toBinaryString(c-1));
        System.out.println(c);
        System.out.println(c-1);
        System.out.println(Integer.toBinaryString(c&(c-1)));*/
    }
}