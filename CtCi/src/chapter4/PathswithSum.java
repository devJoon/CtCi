package chapter4;
import chapter4.BinarySearchTree.*;

import java.util.LinkedList;
import java.util.Queue;

public class PathswithSum {

    public static int countPath(Node node, int sum) {

        if (node == null)
            return 0;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        int pathCnt = 0;

        while(!queue.isEmpty()) {
            Node curNode = queue.poll();
            pathCnt += countPathFrom(curNode, sum);

            if (curNode.left != null)
                queue.offer(curNode.left);

            if (curNode.right != null)
                queue.offer(curNode.right);
        }

        return pathCnt;
    }


    private static int countPathFrom(Node node, int sum) {

        if (node == null)
            return 0;

        if (node.value == sum) {
            System.out.println("Matched! curNode : " + node.value + " sum : " + sum);
        }

        int cnt = ((node.value == sum)?1:0) +
                countPathFrom(node.left, sum - node.value) +
                countPathFrom(node.right, sum - node.value);

        return cnt;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        /*bst.insert(-10);
        bst.insert(15);
        bst.insert(2);
        bst.insert(-2);*/

        bst.build(10, 10);
        System.out.println();

        int cnt = PathswithSum.countPath(bst.getRoot(), 16);
        System.out.println(cnt);

    }
}
