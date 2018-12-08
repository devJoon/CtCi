package chapter5;

import java.util.ArrayList;
import java.util.List;

public class FlipBittoWin {

    public static int getLongest1s(int n) {

        int carry = 0;
        List<Integer> list = new ArrayList<>();
        //list.add(0);

        // Take absolute value so that we can also treat negative integer.
        n=Math.abs(n);

        while(n!=0) {
            if (n%2==1) {
                carry++;
            } else { // 0
                if (carry > 0) {
                    list.add(carry);
                    carry = 0;
                }
                list.add(0);
            }
            n = n >> 1; // divide by 2
        }

        if (carry > 0)
            list.add(carry);

        //list.add(0);

        System.out.println("list : " + list);

        if (list.isEmpty()) // n = 0
            return 1;

        if (list.size()==1) // list does not contain 0's
            return list.get(0);


        // put 0 at the both end of list for convenience
        list.add(0, 0);
        list.add(0);

        int longest = 0;

        for (int i=1; i<list.size()-1; i++) {
            if (list.get(i) == 0) {
                longest = Math.max(longest, list.get(i-1) + 1 + list.get(i+1));
            }
        }

        return longest;
    }


    /* Solution from the book. */
    public static int flipBit(int a) {
        if (~a == 0) return Integer.BYTES * 8;

        int currentLength = 0;
        int previousLength = 0;
        int maxLength = 1;

        while (a != 0) {
            if ((a&1) == 1) {
                currentLength++;
            } else if ((a&1) == 0) {
                previousLength = (a&2) == 0 ? 0 : currentLength;
                currentLength = 0;
            }
            maxLength = Math.max(previousLength + currentLength + 1, maxLength);
            a >>>= 1; // logical right shift (including sign bit)
        }
        return maxLength;
    }

    public static void main(String[] args){

        System.out.println(getLongest1s(0));
        System.out.println(getLongest1s(15));
        System.out.println(getLongest1s(1775));
        System.out.println(getLongest1s(31));
        System.out.println(getLongest1s(23487283));


        System.out.println(flipBit(0));
        System.out.println(flipBit(15));
        System.out.println(flipBit(1775));
        System.out.println(flipBit(31));
        System.out.println(flipBit(23487283));
    }

}
