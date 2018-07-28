//Determine whether a tree is a valid binary search tree.
//
//A binary search tree is a tree with two children, left and right,
// and satisfies the constraint that the key in the left child must be less than or equal to the root
// and the key in the right child must be greater than or equal to the root.


object Q89ValidBinaryTree {
    @JvmStatic
    fun main(args: Array<String>) {
        println(isBst(buildSampleTree(), Int.MIN_VALUE, Int.MAX_VALUE))

    }

    fun isBst(node: BinaryTree<Int>?, min: Int, max: Int): Boolean {
        if (node == null) {
            return true;
        }

        return isBst(node.left, min, node.data)
                && isBst(node.right, node.data, max)
                && node.data > min
                && node.data < max
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

