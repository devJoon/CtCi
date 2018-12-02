package chapter4;
import chapter4.BinarySearchTree.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RandomNode {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.build(10, 20);
        System.out.println();

        Map<Node, Integer> map = new HashMap<>();

        for(int i=0; i<10000; i++) {
            Node n = bst.getRandomNode();
            Integer num = map.get(n);
            if (num == null) {
                num = 0;
            }
            map.put(n, ++num);
        }

        Set<Node> ns = map.keySet();
        for(Node rn:ns) {
            System.out.println("The node with value "
                    + rn.value + " was chosen "
                    + map.get(rn) + " times");
        }
    }

}
