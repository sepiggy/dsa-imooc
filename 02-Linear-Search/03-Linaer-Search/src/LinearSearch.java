public class LinearSearch {

    private LinearSearch() {
    }

    /**
     * 线性查找
     * <p>
     * 输入：数组和目标元素
     * 输出：目标元素所在的索引；若不存在，返回 -1
     */
    public static int search(int[] data, int target) {

        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) {
                return i;
            }
        }

        return -1;
    }
}