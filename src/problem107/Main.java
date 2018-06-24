package problem107;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class Main {

   /*Print the nodes in a binary tree level-wise. For example, the following should print 1, 2, 3, 4, 5.
             1
            / \
           2   3
              / \
             4   5


   Approach:
   breadth-first traverse of the tree
   */


   public static void main(String args[]) {

       Node[] nodes = new Node[5];
       IntStream.range(0, 5).forEach(i-> nodes[i] = new Node(i+1));

       nodes[0].right = nodes[2];
       nodes[0].left = nodes[1];
       nodes[2].right = nodes[4];
       nodes[2].left = nodes[3];

       Queue<Node> q = new LinkedList<>();
       q.add(nodes[0]);

       printNodes(q);
   }


   static void printNodes(Queue<Node> q) {
        while (!q.isEmpty()) {
            Node n = q.poll();
            System.out.print(n.value+" ");
            if (n.left!=null)  q.add(n.left);
            if (n.right!=null) q.add(n.right);
        }
   }
}

class Node {
    int value;
    Node right;
    Node left;

    Node(int value){
        this.value = value;
    }
}
