package chapter4;

import java.util.LinkedList;

public class ListofDepths {
    private BinarySearchTree bst;
    private LinkedList<BinarySearchTree.Node>[] depthList;

    public ListofDepths() {
        bst = new BinarySearchTree();
    }

    public void setup() {
        depthList = new LinkedList[bst.getHeight()];
        for(int i=0; i<bst.getHeight(); i++)
            depthList[i] = new LinkedList<>();
    }

    public void createLists(BinarySearchTree.Node node, int h) {
        if (node != null){
            depthList[h].add(node);
            createLists(node.left, h+1);
            createLists(node.right, h+1);
        }
    }

    public void printLists() {
        for (int i=0; i<bst.getHeight(); i++) {
            System.out.print("element in level " + (i+1) + " : ");
            for(BinarySearchTree.Node n: depthList[i]) {
                System.out.print(n.value + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        ListofDepths ld = new ListofDepths();

        /* used MinimalTree class to build complete binary tree. */
        MinimalTree mt = new MinimalTree();
        mt.fill(127);
        mt.buildTree(0, 126);

        ld.bst = mt.getBst();
        ld.setup();
        ld.createLists(ld.bst.getRoot(), 0);
        ld.printLists();
    }
}
