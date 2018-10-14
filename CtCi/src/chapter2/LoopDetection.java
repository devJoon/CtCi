package chapter2;
import java.util.*;

public class LoopDetection {

    public static Node getBeginning(LinkedList list) {
        Set<Node> Nodeset = new HashSet<Node>();

        for (Node iter = list.head; iter != null; iter = iter.next) {
            if (Nodeset.contains(iter)) {
                System.out.println("Beginning of the loop : " + iter.data);
                return iter;
            }
            else {
                Nodeset.add(iter);
            }
        }
        return null;
    }

    /* There is a solution using two pointer.
     * One moving at a rate of 2, while the other one at a rate of 1. */

    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        list.insertNodes(10);
        list.printList();

        /* Create loop */
        list.getLastNode().next = list.head.next;

        LoopDetection.getBeginning(list);

    }

}
