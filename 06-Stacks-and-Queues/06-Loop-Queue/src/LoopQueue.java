// 循环队列
// 引入front和tail下标
// front: 队首索引
// tail: 队尾索引的下一个位置 (也就是待插入下一个元素的位置)
// front == tail -> 队列为空
// (tail + 1) % data.length == front -> 队列为满
// 因此在循环队列中, 有意浪费一个位置来区分空和满两种状态
public class LoopQueue<E> implements Queue<E> {

    private E[] data; // 底层实际存放元素的数组

    private int front, tail; // front: 队首位置; tail: 队尾位置+1

    // 有兴趣的同学，在完成这一章后，可以思考一下：
    // LoopQueue中不声明size，如何完成所有的逻辑？
    // 这个问题可能会比大家想象的要难一点点：）
    private int size; // 队列中实际元素个数

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1]; // 用户期望的容量 + 1 = 实际底层数组需要的容量
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public int getSize() {
        return size;
    }

    // 下一小节再做具体实现
    @Override
    public void enqueue(E e) {

    }

    // 下一小节再做具体实现
    @Override
    public E dequeue() {
        return null;
    }

    // 下一小节再做具体实现
    @Override
    public E getFront() {
        return null;
    }
}
