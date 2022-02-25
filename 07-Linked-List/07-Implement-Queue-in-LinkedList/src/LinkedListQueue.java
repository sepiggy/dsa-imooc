// p064. 使用带有尾指针的链表实现队列
// 增加尾指针tail
// 在head处添加, 删除时间复杂度都是O(1)
// 在tail处添加时间复杂度是O(1), 删除时间复杂度是O(n)
// 因此head适合作队首(出队), tail适合作队尾(入队)
public class LinkedListQueue<E> implements Queue<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }
    // 相对于普通链表, 增加tail尾指针
    // head: 头指针, 指向链表第一个节点
    // tail: 尾指针, 指向链表最后一个节点
    private Node head, tail;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // 在tail处进行入队操作
    @Override
    public void enqueue(E e) {
        if (tail == null) { // 当前链表是空链表, head和tail都是null
            tail = new Node(e);
            head = tail;
        } else { // 当前链表有元素, 在tail处添加新元素
            tail.next = new Node(e);
            tail = tail.next; // 维护尾指针
        }
        size++;
    }

    // 在head处进行出队操作
    @Override
    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");

        Node retNode = head;
        head = head.next; // 维护头指针
        retNode.next = null;
        if (head == null) // 链表中只有一个元素的情况, 在head处进行出队操作会影响尾指针tail
            tail = null;
        size--;
        return retNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("Queue is empty.");
        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: front ");

        Node cur = head;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL tail");
        return res.toString();
    }

    public static void main(String[] args) {

        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
