package lb;

class Node {
    int key, val;
    Node pre, next;
    int cnt;

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public Node() {}
    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        cnt = 1;
    }
    public void addCnt() {
        cnt++;
    }
    public Node(int val, Node pre, Node next) {
        this.val = val;
        this.pre = pre;
        this.next = next;
    }
}
class DoublyList {
    private Node head, tail;
    public DoublyList() {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }
    public void insertHead(Node p) {
        Node t = head.next;
        p.next = t;t.pre = p;
        p.pre = head;
         head.next = p;
    }
    public void remove(Node p) {
        p.pre.next = p.next;
        p.next.pre = p.pre;
    }
    public Node removeLast() {
        if (head.next == tail) {
            return null;
        }
        Node p = tail.pre;
        p.pre.next = tail;
        tail.pre = p.pre;
        p.pre = p.next = null;
        return p;
    }
}
