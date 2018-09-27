package chapter2;

public class Intersection {

    /* print intersecting node based on reference, not value */
    public static void findIntersection(LinkedList l1, LinkedList l2) {

        for(Node outerIter=l1.head; outerIter != null; outerIter=outerIter.next) {
            for(Node innerIter=l2.head; innerIter != null; innerIter=innerIter.next) {

                if (outerIter == innerIter) {

                    while (outerIter != null) {
                        System.out.print(outerIter.data + " ");
                        outerIter = outerIter.next;
                    }
                    return;
                }

            }
        }

        return;

    }


    public static void main(String args[]) {

        LinkedList list1 = new LinkedList();
        list1.insertNodes(8);
        list1.printList();

        LinkedList list2 = new LinkedList();
        list2.insertNodes(5);
        list2.appendNodeToTail(list1.head.next.next);
        list2.insertNodes(4);
        list2.printList();

        Intersection.findIntersection(list1, list2);
    }

}
