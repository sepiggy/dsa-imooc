// 实现链表
public class LinkedList<E> {

    // 链表中的节点
    // 设计为内部类, 为外部用户屏蔽底层实现细节
    private class Node {
        // 外部类 LinkedList 可以直接访问内部类的 public 域
        public E e;          // 实际存储元素
        public Node next;    // 指向链表的下一个位置

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
}
