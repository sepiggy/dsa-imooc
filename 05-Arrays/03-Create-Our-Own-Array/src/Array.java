// 使用Java原生的静态数组二次封装自己的动态数组
// 原则: 保证动态数组内没有空洞元素 -> 下标为 0 ~ size-1 的位置都有元素
public class Array {

    private int[] data; // 底层封装的Java数组
    private int size; // 数组实际存储元素的个数

    // 构造函数，传入数组的容量capacity构造Array
    public Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    // 无参数的构造函数，默认数组的容量capacity=10
    public Array() {
        this(10);
    }

    // 获取数组的容量
    public int getCapacity() {
        return data.length;
    }

    // 获取数组中的元素个数
    public int getSize() {
        return size;
    }

    // 返回数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }
}
