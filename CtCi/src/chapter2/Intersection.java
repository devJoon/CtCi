package chapter2;

public class Intersection {

    /* print intersecting node based on reference, not value */
    public static void findIntersection(LinkedList l1, LinkedList l2) {

        if (l1.head == null || l2.head == null)
            return;

        int l1Length = 1, l2Length = 1;
        Node l1Last = l1.head, l2Last = l2.head;
        while (l1Last.next != null) {
            l1Last = l1Last.next;
            l1Length++;
        }
        while (l2Last.next != null) {
            l2Last = l2Last.next;
            l2Length++;
        }

        if (l1Last != l2Last)
            return;

        System.out.println("list1 length : " + l1Length);
        System.out.println("list2 length : " + l2Length);

        /* Chop down the longer list to make two lists of equal size . */

        if (l1Length > l2Length) {
            for (int i=0; i< l1Length - l2Length; i++) {
                l1.head = l1.head.next;
            }
        }
        else if (l1Length < l2Length) {
            for (int i=0; i< l2Length - l1Length; i++) {
                l2.head = l2.head.next;
            }
        }

        /* Now we have two lists of same size, compare two nodes one by one
         * Note that head of either list might have been changed.
         * We need to restore it back, if we want input lists to be unchanged. (Omitted in this code)
         */
        for(Node l1Node = l1.head, l2Node = l2.head; l1Node != null; l1Node = l1Node.next, l2Node = l2Node.next) {
            if (l1Node == l2Node) {
                System.out.print(l1Node.data + " ");
            }
        }

    }

    public static void main(String args[]) {

        LinkedList list1 = new LinkedList();
        list1.insertNodes(8);

        LinkedList list2 = new LinkedList();
        list2.insertNodes(3);
        list2.appendNodeToTail(list1.head.next.next);
        list2.insertNodes(4);

        System.out.println("List1 : ");
        list1.printList();

        System.out.println("List2 : ");
        list2.printList();

        System.out.println("Intersection : ");
        Intersection.findIntersection(list1, list2);
    }

}
