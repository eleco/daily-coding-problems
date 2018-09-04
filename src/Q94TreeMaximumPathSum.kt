object Q94TreeMaximumPathSum {


    var max = 0;


    @JvmStatic
    fun main(args: Array<String>) {
        //Given a binary tree of integers, find the maximum path sum between two nodes.
        // The path must go through at least one node, and does not need to go through the root.

        //Approach

        //v1 traverse() + maxSumToRoot()
        //recursively traverse the tree
        //for each node traversed, compute the maximum path of the right + left sub tree for the current node

        //v2 maxSumToRootV2
        //recursively traverse the tree
        //for each node: calculate max path of left and right sub trees
        //update global max sum path if either left subtree, or right subtree, or left+root+right subtree exceed current max
        //depending on wether max sum path goes through the root or not



        traverse(buildSampleTree())
        println("max path sum:" + max)

        max=0;
        maxSumToRootv2(buildSampleTree())
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


    fun maxSumToRootv2(node: BinaryTree<Int>): Int {
        if (node.left == null && node.right == null) {
            return node.data;
        }

        val right = node.right;
        val left = node.left;

        val leftSum = if (left!=null)  maxSumToRootv2(left) else 0
        val rightSum = if (right!=null)  maxSumToRootv2(right) else 0

        val tmpMax = Math.max(Math.max(leftSum,rightSum), leftSum+rightSum+node.data)

        if (tmpMax>max) max=tmpMax

        return Math.max(
                leftSum+ node.data,
                rightSum + node.data)

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