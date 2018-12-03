package chapter4;
import chapter4.BinarySearchTree.*;

import java.util.HashMap;
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

    /* Solution */
    public static int countPathsWithSum(Node root, int targetSum) {
        return countPathsWithSum(root, targetSum, 0, new HashMap<Integer,Integer>());
    }

    private static int countPathsWithSum(Node node, int targetSum, int runningSum, HashMap<Integer, Integer> pathCount) {

        if (node == null)
            return 0; // Base case

        /* Count paths with sum ending at the current node. */
        runningSum += node.value;
        int sum = runningSum - targetSum;
        int totalPaths = pathCount.getOrDefault(sum, 0);

        /* If runningSum equals targetSum, then one additional path starts at root.
         * Add in this path.
         */
        if (runningSum == targetSum) {
            totalPaths++;
        }

        /* Increment pathCount, recurse, then decrement pathCount. */
        incrementHashTable(pathCount, runningSum, 1); // Increment pathCount
        totalPaths += countPathsWithSum(node.left, targetSum, runningSum, pathCount);
        totalPaths += countPathsWithSum(node.right, targetSum, runningSum, pathCount);
        incrementHashTable(pathCount, runningSum, -1); // Decrement pathCount

        return totalPaths;
    }

    private static void incrementHashTable(HashMap<Integer, Integer> hashTable, int key, int delta) {
        int newCount = hashTable.getOrDefault(key, 0) + delta;
        if (newCount == 0) { // Remove when zero to reduce space usage
            hashTable.remove(key);
        } else {
            hashTable.put(key, newCount);
        }
    }


    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        /*bst.insert(-10);
        bst.insert(15);
        bst.insert(2);
        bst.insert(-2);*/

        bst.build(10, 10);
        System.out.println();

        /* Brute Force */
        int cnt = PathswithSum.countPath(bst.getRoot(), 16);
        System.out.println(cnt);

        /* Optimized */
        cnt = PathswithSum.countPathsWithSum(bst.getRoot(), 16);
        System.out.println(cnt);

    }
}
