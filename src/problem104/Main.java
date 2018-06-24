package problem104;

public class Main {

    //Determine whether a doubly linked list is a palindrome. What if it’s singly linked?
    //For example, 1 -> 4 -> 3 -> 4 -> 1 returns true while 1 -> 4 returns false.


    public static void main(String[] args) {

        DblList dblList = new DblList();
        System.out.println(dblList.checkPalindrome("1,4,3,4,1"));
        System.out.println(dblList.checkPalindrome("1,4"));

        SingleList list = new SingleList();
        System.out.println(list.checkPalindrome("1,4,3,4,1"));
        System.out.println(list.checkPalindrome("1,4"));

    }
}


class SingleList {

    SingleNode root;

    boolean checkPalindrome(String s) {
        SingleNode[] n = buildSingleList(s);
        root = n[0];
        return recurse(n[0]);
    }

    boolean recurse(SingleNode head) {

        if (head == null) return false;

        boolean ret = recurse(head.next);

        if (ret) {
            return true;
        } else {
            ret = root.value.equals(head.value);
            root = root.next;
            return ret;

        }
    }


    SingleNode[] buildSingleList(String s) {
        String[] a = s.split(",");
        SingleNode[] nodes = new SingleNode[a.length];
        for (int i = 0; i < a.length; i++) {
            nodes[i] = new SingleNode(a[i]);
            if (i > 0) {
                nodes[i - 1].next = nodes[i];
            }
        }
        return nodes;
    }


}

class SingleNode {
    String value;
    SingleNode next;

    SingleNode(String v) {
        this.value = v;
    }
}


class DblList {

    boolean checkPalindrome(String s) {

        DblNode[] n = buildDblList(s);
        int midPoint = n.length / 2;
        DblNode head = n[0];
        DblNode tail = n[n.length - 1];
        for (int i = 0; i < midPoint; i++) {
            if (!head.value.equals(tail.value)) {
                return false;
            }
            head = head.next;
            tail = tail.prev;
        }
        return true;
    }

    DblNode[] buildDblList(String s) {
        String[] a = s.split(",");
        DblNode[] nodes = new DblNode[a.length];
        for (int i = 0; i < a.length; i++) {
            nodes[i] = new DblNode(a[i]);
            if (i > 0) {
                nodes[i].prev = nodes[i - 1];
                nodes[i - 1].next = nodes[i];
            }
        }
        return nodes;
    }
}

class DblNode {
    String value;
    DblNode next;
    DblNode prev;

    DblNode(String v) {
        this.value = v;
    }
}