/**
 * 泛型版本的线性查找
 */
public class LinearSearch {

    private LinearSearch() {
    }

    /**
     * ! 泛型方法的类型参数写在返回值的前面
     */
    public static <E> int search(E[] data, E target) {

        for (int i = 0; i < data.length; i++) {
            //! 判断两个对象值相等需要使用 equals 方法
            if (data[i].equals(target)) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        Integer[] data = {24, 18, 12, 9, 16, 66, 32, 4};

        int res = LinearSearch.search(data, 16);
        System.out.println("res = " + res);

        int res2 = LinearSearch.search(data, 666);
        System.out.println("res2 = " + res2);
    }
}
