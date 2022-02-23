// 基于自己实现的动态数组来实现栈结构
public class ArrayStack<E> implements Stack<E> {

    // 这种栈的实现方式底层数据结构是动态数组
    private Array<E> array;

    // 因为基于动态数组实现的栈, 底层动态数组的构造需要容积这个参数
    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayStack() {
        array = new Array<>();
    }

    // O(1)
    @Override
    public int getSize() {
        return array.getSize();
    }

    // O(1)
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    // 底层动态数组的末尾作为栈顶位置
    // O(1) 均摊时间复杂度 (可能触发resize)
    @Override
    public void push(E e) {
        array.addLast(e);
    }

    // O(1) 均摊时间复杂度 (可能触发resize)
    @Override
    public E pop() {
        return array.removeLast();
    }

    // O(1)
    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append('[');
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1)
                res.append(", ");
        }
        res.append("] top"); // 标识栈顶元素
        return res.toString();
    }
}
