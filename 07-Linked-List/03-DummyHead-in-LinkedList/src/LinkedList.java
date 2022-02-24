// p060. 使用链表的虚拟头节点
// 技巧: 使用虚拟头节点创建链表可以统一链表的相关操作
// 编写相关逻辑会更加方便, 这个实现细节对用户是透明的
public class LinkedList<E> {

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

    private Node dummyHead; // 虚拟头节点, 其存储的元素是null, dummyHead.next是真正存储元素的第一个节点
    private int size;

    public LinkedList() {
        // 链表初始化的时候就存在一个头节点, 这个头节点不存储任何元素
        // 一个空链表本身就存在一个唯一的虚拟头节点, 这个节点存储的元素是null, 指向的下一个元素也是null
        dummyHead = new Node();
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

    // 在链表的index(0-based)位置添加新的元素e
    // 在链表中不是一个常用的操作，练习用：）
    public void add(int index, E e) {

        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");

        Node prev = dummyHead; // dummyHead对应0位置这个元素前一个位置的节点
        for (int i = 0; i < index; i++) // 找到索引index前一个位置的节点，需要遍历index次
            prev = prev.next;

        prev.next = new Node(e, prev.next);
        size++;
    }

    // 在链表头添加新的元素e
    public void addFirst(E e) {
        add(0, e);
    }

    // 在链表末尾添加新的元素e
    public void addLast(E e) {
        add(size, e);
    }
}
