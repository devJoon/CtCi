package chapter4;

import java.util.ArrayList;
import java.util.Iterator;

public class BSTSequences {

    public static void getSequences(ArrayList<BinarySearchTree.Node> chosenList, ArrayList<BinarySearchTree.Node> selectList) {

        if (selectList.isEmpty()) {

            System.out.print("{");

            for (BinarySearchTree.Node n : chosenList) {
                System.out.print(n.value);
                if (n != chosenList.get(chosenList.size() - 1))
                    System.out.print(", ");
            }

            System.out.println("}");

            return;
        }

        // With this approach, we have to copy ArrayList over and over.
        for (BinarySearchTree.Node n : selectList) {

            ArrayList<BinarySearchTree.Node> s = new ArrayList<>(selectList);
            ArrayList<BinarySearchTree.Node> c = new ArrayList<>(chosenList);

            c.add(n);
            s.remove(n);

            if (n.left != null)
                s.add(n.left);
            if (n.right != null)
                s.add(n.right);

            getSequences(c, s);

        }

        return;
    }

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();

        bst.build(6, 10);
        System.out.println();

        // chosenList
        ArrayList<BinarySearchTree.Node> c = new ArrayList<>();
        // selectList
        ArrayList<BinarySearchTree.Node> s = new ArrayList<>();
        s.add(bst.getRoot());

        BSTSequences.getSequences(c, s);
    }

}
