// 栈的实现接口
public interface Stack<E> {

    // 获取当前栈的元素个数
    int getSize();

    // 判断栈是否为空
    boolean isEmpty();

    // 入栈
    void push(E e);

    // 出栈
    E pop();

    // 查看栈顶元素
    E peek();
}
