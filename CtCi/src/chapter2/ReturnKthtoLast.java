package chapter2;

public class ReturnKthtoLast extends LinkedList {

    /* return kth node to last
     * when length of the list is less than k, return null
     */
    private Node getKthNodetoLast(int k) {
        Node leaderNode = this.head;
        Node followerNode = this.head;

        // move leaderNode k-1 times
        for (int i=1; i<k; i++) {
            leaderNode = leaderNode.next;

            if (leaderNode == null)
                return null;
        }

        /*  at this point, leaderNode and followerNode are k-1 steps away.
         *  Now we move two nodes by one step until leaderNode gets last node.
         */

        while (leaderNode.next != null) {
            leaderNode = leaderNode.next;
            followerNode = followerNode.next;
        }

        return followerNode;

    }

    public static void main(String args[]) {

        ReturnKthtoLast list = new ReturnKthtoLast();
        list.insertNodes(8);
        list.printList();

        Node kth = list.getKthNodetoLast(4);

        if (kth!= null)
            System.out.println(kth.data);
        else
            System.out.println("Node is null.");
    }
}