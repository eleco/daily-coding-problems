object Main {


    var max = 0;


    @JvmStatic
    fun main(args: Array<String>) {
        //Given a binary tree of integers, find the maximum path sum between two nodes.
        // The path must go through at least one node, and does not need to go through the root.

        //Approach
        //recursively traverse the tree
        //for each node traversed, compute the maximum path of the right + left sub tree for the current node
        traverse(buildSampleTree())
        println("max path sum:" + max)
    }


    fun traverse(node: BinaryTree<Int>) {
        var tmp = node.data;


        val right = node.right;
        if (right != null) {
            tmp += maxSumToRoot(right);
        }
        val left = node.left;
        if (left != null) {
            tmp += maxSumToRoot(left);
        }

        if (tmp > max) max = tmp

        if (right != null) traverse(right);
        if (left != null) traverse(left);

    }

    fun maxSumToRoot(node: BinaryTree<Int>): Int {


        if (node.left == null && node.right == null) {
            return node.data;
        }

        val right = node.right;
        val left = node.left;

        return Math.max(
                if (right != null) node.data + maxSumToRoot(right) else 0,
                if (left != null) node.data + maxSumToRoot(left) else 0)


    }


    fun buildSampleTree(): BinaryTree<Int> {

        //          1
        //        /   \
        //      5      4
        //    / \       \
        //  3    2        6
        val b = BinaryTree(4)
        val c = BinaryTree(5)

        b.right = BinaryTree(6)

        c.right = BinaryTree(2)
        c.left = BinaryTree(3)

        val a = BinaryTree(1)
        a.right = b
        a.left = c

        return a
    }
}


class BinaryTree<T>(val data: T) {

    var left: BinaryTree<T>? = null
    var right: BinaryTree<T>? = null


}