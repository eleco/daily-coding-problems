object Q104Palindrome {

    //Determine whether a doubly linked list is a palindrome. What if it’s singly linked?
    //For example, 1 -> 4 -> 3 -> 4 -> 1 returns true while 1 -> 4 returns false.


    @JvmStatic
    fun main(args: Array<String>) {

        val dblList = DblList()
        println(dblList.checkPalindrome("1,4,3,4,1"))
        println(dblList.checkPalindrome("1,4"))

        val list = SingleList()
        println(list.checkPalindrome("1,4,3,4,1"))
        println(list.checkPalindrome("1,4"))
    }

    internal class SingleList {

        var root: SingleNode? = null

        fun checkPalindrome(s: String): Boolean {
            val n = buildSingleList(s)
            root = n[0]
            return recurse(n[0])
        }

        fun recurse(head: SingleNode?): Boolean {

            if (head == null) return false

            var ret = recurse(head.next)

            if (ret) {
                return true
            } else {
                ret = root!!.value == head.value
                root = root!!.next
                return ret

            }
        }


        fun buildSingleList(s: String): Array<SingleNode?> {
            val a = s.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            val nodes = arrayOfNulls<SingleNode>(a.size)
            for (i in a.indices) {
                nodes[i] = SingleNode(a[i])
                if (i > 0) {
                    nodes[i - 1]?.next = nodes[i]
                }
            }
            return nodes
        }


    }

    internal class SingleNode(var value: String) {
        var next: SingleNode? = null
    }


    internal class DblList {

        fun checkPalindrome(s: String): Boolean {

            val n = buildDblList(s)
            val midPoint = n.size / 2
            var head: DblNode? = n[0]
            var tail: DblNode? = n[n.size - 1]
            for (i in 0 until midPoint) {
                if (head!!.value != tail!!.value) {
                    return false
                }
                head = head.next
                tail = tail.prev
            }
            return true
        }

        fun buildDblList(s: String): Array<DblNode?> {
            val a = s.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            val nodes = arrayOfNulls<DblNode>(a.size)
            for (i in a.indices) {
                nodes[i] = DblNode(a[i])
                if (i > 0) {
                    nodes[i]?.prev = nodes[i - 1]
                    nodes[i - 1]?.next = nodes[i]
                }
            }
            return nodes
        }
    }

    internal class DblNode(var value: String) {
        var next: DblNode? = null
        var prev: DblNode? = null
    }
}