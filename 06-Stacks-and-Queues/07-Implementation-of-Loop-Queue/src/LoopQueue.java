public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front, tail;
    // 有兴趣的同学，在完成这一章后，可以思考一下：
    // LoopQueue中不声明size，如何完成所有的逻辑？
    // 这个问题可能会比大家想象的要难一点点：）
    private int size;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    // 返回队列的容积
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

    // 入队
    @Override
    public void enqueue(E e) {

        if ((tail + 1) % data.length == front) // 队列是否已满
            resize(getCapacity() * 2);

        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    // 出队
    // 循环队列中出队操作的复杂度是 O(1) 均摊
    @Override
    public E dequeue() {

        if (isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");

        E ret = data[front];
        data[front] = null; // for GC
        front = (front + 1) % data.length;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) // 缩容操作 (防止复杂度震荡)
            resize(getCapacity() / 2);
        return ret;
    }

    // 查看队首元素
    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("Queue is empty.");
        return data[front];
    }

    // 扩缩容操作
    // newCapacity: 新容积
    private void resize(int newCapacity) {

        // new一个新的底层数组
        E[] newData = (E[]) new Object[newCapacity + 1];

        // 将原数组中的元素移动到新数组
        // 原数组相对于新数组有一个front大小的偏移
        for (int i = 0; i < size; i++)
            newData[i] = data[(i + front) % data.length];

        data = newData; // 维护底层数组
        front = 0; // 维护front下标
        tail = size; // 维护tail下标
        // 没有入列和出队操作, 因此size不需要改变
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        res.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) { // 与81行的遍历方式是等价的
            res.append(data[i]);
            if ((i + 1) % data.length != tail)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {

        LoopQueue<Integer> queue = new LoopQueue<>();
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
