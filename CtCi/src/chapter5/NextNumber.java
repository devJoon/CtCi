package chapter5;

public class NextNumber {


    public static int getNext(int n) {

        int c=n;
        /* c0 and c1 denotes the number of 0s and 1s placed right side of the first non-trailing 0 */
        int c0=0;
        int c1=0;

        while (((c&1)==0) && (c!=0)) {
            c0++;
            c >>= 1;
        }

        while ((c & 1) == 1) {
            c1++;
            c >>= 1;
        }

        if (c0 + c1 == 31 || c0 + c1 == 0) {
            return -1;
        }

        int p = c0 + c1; // position of rightmost non-trailing zero

        n |= 1<<p;
        n &= ~((1<<p)-1);
        n |= (1<<(c1-1))-1;

        return n;
    }


    public static int getPrev(int n) {
        int c = n;
        int c0 = 0;
        int c1 = 0;

        while((c&1)==1) {
            c1++;
            c >>= 1;
        }

        if (c==0)
            return -1;

        while((c&1)==0 && c!=0) {
            c0++;
            c >>= 1;
        }


        int p = c0 + c1; // position of rightmost non-trailing one

        n &= -1<<(p+1); // clears from bit p onwards
        int mask = (1<<(c1+1)) - 1; // sequence of (c1+1) ones
        n |= mask << (c0-1); // trailing c0-1 0s

        return n;
    }

    public static void main(String[] args) {
        int n = 13948;
        System.out.println(Integer.toBinaryString(n));

        System.out.println(Integer.toBinaryString(getNext(n)));
        System.out.println(Integer.toBinaryString(getPrev(n)));

    }
}
