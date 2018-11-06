package chapter4;


import chapter4.BinarySearchTree.Node;

public class ValidateBST {

    public ValidateBST() {

    }

    /* Test whether bst is really binary search tree. */
    public static Boolean isBST(Node node, int lowerBound, int upperBound) {
        if (node == null) {
            return true;
        }
        else {
            System.out.println(lowerBound + " " + node.value + " " + upperBound);

            if (node.value >= lowerBound && node.value < upperBound) {
                return isBST(node.left, lowerBound, node.value) && isBST(node.right, node.value, upperBound);
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args){
        BinarySearchTree bst = new BinarySearchTree();
        bst.build(100, 100);

        System.out.println(ValidateBST.isBST(bst.getRoot(), Integer.MIN_VALUE, Integer.MAX_VALUE));

    }
}
