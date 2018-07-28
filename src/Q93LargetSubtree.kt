object Q93LargetSubtree {

    @JvmStatic
    fun main(args: Array<String>) {
        // Given a tree, find the largest tree/subtree that is a BST.
        // Given a tree, return the size of the largest tree/subtree that is a BST.

        // A binary search tree (BST), also known as an ordered binary tree, is a node-based data structure in which each node has no more than two child nodes. ...
        // The left sub-tree contains only nodes with keys less than the parent node; the right sub-tree contains only nodes with keys greater than the parent node.

        //Approach
        // traverse the tree left to right, for each node: if bst print the size
        // or else return the largest children subtrees.

        println(sizeLargestSubtree(buildSampleTree()))

    }


    fun sizeLargestSubtree(node: BinaryTree<Int>?): Int {
        if (isBst(node, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            return sizeTree(node)
        } else {
            return Math.max(sizeLargestSubtree(node?.left), sizeLargestSubtree(node?.right))
        }

    }

    fun sizeTree(node: BinaryTree<Int>?): Int {
        if (node == null) return 0
        else return sizeTree(node.right) + 1 + sizeTree(node.left)
    }


    fun isBst(tree: BinaryTree<Int>?, low: Int, high: Int): Boolean {
        if (tree == null) {
            return true;
        }

        return isBst(tree.right, tree.data, high)
                && isBst(tree.left, low, tree.data)
                && tree.data > low
                && tree.data < high

    }


    fun buildSampleTree(): BinaryTree<Int> {

        //          5
        //        /   \
        //      3      6
        //    / \       \
        //  2    4        7
        val b = BinaryTree(6)
        val c = BinaryTree(3)

        b.right = BinaryTree(7)

        c.right = BinaryTree(4)
        c.left = BinaryTree(2)

        val a = BinaryTree(5)
        a.right = b
        a.left = c

        return a
    }

    class BinaryTree<T>(val data: T) {
        var left: BinaryTree<T>? = null
        var right: BinaryTree<T>? = null
    }
}


