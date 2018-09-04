import java.util.LinkedList
import java.util.Queue
import java.util.stream.IntStream

object Q107PrintBinaryTree {

    /*Print the nodes in a binary tree level-wise. For example, the following should print 1, 2, 3, 4, 5.
             1
            / \
           2   3
              / \
             4   5


   Approach:
   breadth-first traverse of the tree
   */


    @JvmStatic
    fun main(args: Array<String>) {

        val nodes = Array(5) { Node(0) }
        IntStream.range(0, 5).forEach { i -> nodes[i] = Node(i + 1) }

        nodes[0].right = nodes[2]
        nodes[0].left = nodes[1]
        nodes[2].right = nodes[4]
        nodes[2].left = nodes[3]

        val q = LinkedList<Node>()
        q.add(nodes[0])

        printNodes(q)
    }


    internal fun printNodes(q: Queue<Node>) {
        while (!q.isEmpty()) {
            val n = q.poll()
            print(n.value.toString() + " ")
            if (n.left != null) q.add(n.left)
            if (n.right != null) q.add(n.right)
        }
    }

    internal class Node(var value: Int) {
        var right: Node? = null
        var left: Node? = null
    }

}

