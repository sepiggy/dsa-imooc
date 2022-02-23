
public class Array {

    private int[] data;
    private int size; // size就是data数组中第一个没有元素的位置下标

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

    // 向所有元素后添加一个新元素
    public void addLast(int e) {
//        if(size == data.length)
//            throw new IllegalArgumentException("AddLast failed. Array is full.");
//        data[size] = e;
//        size ++;
        add(size, e);
    }

    // 在所有元素前添加一个新元素
    public void addFirst(int e) {
        add(0, e);
    }

    // 向指定位置添加元素
    // 在index索引的位置插入一个新元素e
    public void add(int index, int e) {

        if (size == data.length)
            throw new IllegalArgumentException("Add failed. Array is full.");

        if (index < 0 || index > size) // 保证数组元素紧密排列 -> index < size
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");

        // 从后往前挪
        for (int i = size - 1; i >= index; i--)
            data[i + 1] = data[i];

        data[index] = e;

        size++;
    }

}
