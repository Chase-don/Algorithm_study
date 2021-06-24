public class ninetytwo_ReverseLinkedList {

    public class Node {
        int val;
        Node next;
        Node() {}
        Node(int val) { this.val = val; }
        Node(int val, Node next) { this.val = val; this.next = next; }
        @Override
        public String toString() {
            StringBuilder res = new StringBuilder();
            res.append("[");
            res.append(val);
            return res.toString();
        }
    }


    public Node reverseBetween(Node head, int left, int right) {
        //定义虚拟头结点
        Node dummy = new Node(-1, head);
        Node pre = dummy;
        for (int i = 1; i < left; i++) {
            pre = pre.next;
        }
        //pre是left的前一个节点
        Node tailNode = pre.next;
        Node cur = tailNode;
        for(int i = left; i < right; i++){
            Node nextNode = cur.next;
            cur.next = tailNode;
            pre.next = cur;

            tailNode.next = nextNode;
        }

        return dummy.next;
    }
}
