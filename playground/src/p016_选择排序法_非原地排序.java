import java.util.Arrays;

public class p016_选择排序法_非原地排序 {

    /**
     * 说明：非原地排序方式实现选择排序
     * 输入：原数组
     * 输出：元素从小到大排序后的数组
     */
    public static int[] sort(final int[] array) {

        int[] sortedPart = new int[array.length];
        int[] unsortedPart = Arrays.copyOf(array, array.length);

        for (int i = 0; i < array.length; i++) {
            int minElement = findMinElement(unsortedPart);
            sortedPart[i] = minElement;
            unsortedPart = Arrays.stream(unsortedPart).filter(it -> it != minElement).toArray();
        }

        return sortedPart;
    }

    /**
     * 说明：找出一个数组中的最小值
     * 输入：数组
     * 输出：数组中的最小元素
     */
    private static int findMinElement(final int[] array) {

        if (array == null) {
            throw new RuntimeException("不能为null");
        }

        if (array.length == 0) {
            throw new RuntimeException("数组中必须有元素");
        }

        int ret = Integer.MAX_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < ret) {
                ret = array[i];
            }
        }

        return ret;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{4, 6, 5, 2, 1, 3};
        arr = sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
