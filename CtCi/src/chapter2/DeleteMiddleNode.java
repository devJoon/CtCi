package chapter2;

public class DeleteMiddleNode extends LinkedList {

    /*
     * Delete middle node in the list.
     * When the number of nodes is even, delete the one that appears first.
     */
    public void deleteMiddle() {

        Node runner = this.head;
        Node follower = this.head;

        Node prev = this.head;


        follower = follower.next;

        if (follower == null)
            return;

        runner = runner.next.next;

        if (runner == null)
            return;

        int runnerStep = 0;

        while (runner.next != null) {
            runner = runner.next;
            runnerStep++;

            if (runnerStep == 2) {
                prev = follower;
                follower = follower.next;
                runnerStep = 0;
            }
        }

        prev.next = follower.next;
    }

    public static void main(String args[]) {

        DeleteMiddleNode list = new DeleteMiddleNode();
        list.insertNodes(6);
        list.printList();

        list.deleteMiddle();
        list.printList();
    }

}
