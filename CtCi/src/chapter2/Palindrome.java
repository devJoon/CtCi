package chapter2;

public class Palindrome extends LinkedList {

    /* convert list into string and compare its two endpoint until they meet in the middle. */
    public boolean isPalindrome() {

        String strList = "";

        for(Node iter=this.head; iter != null; iter=iter.next) {
            strList = strList + iter.data;
        }

        System.out.println(strList);

        for (int f = 0, b = strList.length() - 1; f < b; f++, b--) {
            if (strList.charAt(f) != strList.charAt(b))
                return false;
        }
        return true;
    }

    public static void main(String args[]) {
        Palindrome list = new Palindrome();
        // list.insertNodes(8);

        list.appendToTail(1);
        list.appendToTail(2);
        list.appendToTail(3);
        list.appendToTail(4);
        list.appendToTail(1);
        list.appendToTail(2);
        list.appendToTail(1);

        list.printList();

        System.out.println(list.isPalindrome());

    }
}
