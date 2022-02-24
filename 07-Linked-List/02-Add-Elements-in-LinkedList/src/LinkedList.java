// p059. 在链表中添加元素
public class LinkedList<E> {

    // Node作为LinkedList的内部类, 来作为实际存储元素的地方
    private class Node {
        public E e;
        public Node next;

        // 新创建的Node节点存储的元素是e, 指向的下一个节点是next
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

    private Node head; // 链表头节点
    private int size;  // 链表实际存储的元素个数

    // 链表构造方法, 初始化头节点为空, size=0
    public LinkedList() {
        head = null;
        size = 0;
    }

    // 获取链表中的元素个数
    public int getSize() {
        return size;
    }

    // 返回链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 在链表头添加新的元素e
    public void addFirst(E e) {
//        Node node = new Node(e);
//        node.next = head;
//        head = node;

        head = new Node(e, head);
        size++;
    }

    // 在链表的index(0-based)位置添加新的元素e
    // 在链表中不是一个常用的操作，练习用：）
    // 在链表中间添加元素
    // 其关键是找到要添加的节点的前一个节点
    public void add(int index, E e) {

        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");

        if (index == 0) // 链表头没有前一个节点, 所以需要特殊处理, 调用addFirst方法
            addFirst(e);
        else {
            // prev表示待插入节点的前一个节点
            Node prev = head;
            // 找到要添加的节点(index)的前一个节点(index-1), 需要遍历index-1次
            for (int i = 0; i < index - 1; i++)
                prev = prev.next;

//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;

            prev.next = new Node(e, prev.next);
            size++;
        }
    }

    // 在链表末尾添加新的元素e
    public void addLast(E e) {
        add(size, e);
    }
}
