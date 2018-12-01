package chapter4;

import java.util.LinkedList;
import java.util.Queue;
import chapter4.BinarySearchTree.*;

public class CheckSubtree {


    /* Check if t2 is a subtree of t1 */
    public static boolean isSubtreeOf(Node t1, Node t2) {

        if (t2 == null)
            return true;
        if (t1 == null)
            return false;

        Queue<BinarySearchTree.Node> queue = new LinkedList<>();

        queue.offer(t1);

        while (!queue.isEmpty()) {
            Node n = queue.poll();
            if (n.value == t2.value) {
                if (isIdentical(n, t2))
                    return true;
            }

            if (t1.left != null)
                queue.offer(t1.left);

            if (t1.right != null)
                queue.offer(t1.right);

        }

        return false;
    }

    /* Check if t1 and t2 are identical */
    private static boolean isIdentical(BinarySearchTree.Node t1, BinarySearchTree.Node t2) {

        /* Both t1 and t2 are null */
        if (t1 == null && t2 == null)
            return true;

        /* either of t1 or t2 is null */
        if (t1 == null || t2 == null)
            return false;

        if (t1.value != t2.value)
            return false;
        else {
            return isIdentical(t1.left, t2.left) && isIdentical(t1.right, t2.right);
        }

    }

    public static void main(String[] args){

        /*BinarySearchTree bst = new BinarySearchTree();
        bst.build(10,20);
        System.out.println();
        System.out.println(CheckSubtree.isSubtreeOf(bst.getRoot(), bst.getRoot().left));*/

        BinarySearchTree t1 = new BinarySearchTree();
        t1.insert(5);
        t1.insert(3);
        t1.insert(7);
        t1.insert(1);
        t1.insert(4);
        t1.insert(6);
        t1.insert(8);

        System.out.println();

        BinarySearchTree t2 = new BinarySearchTree();
        t2.insert(7);
        t2.insert(6);
        t2.insert(8);

        System.out.println();

        System.out.println(CheckSubtree.isSubtreeOf(t1.getRoot(), t2.getRoot()));
    }

}
