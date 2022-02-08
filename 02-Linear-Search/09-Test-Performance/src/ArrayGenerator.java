public class ArrayGenerator {

    private ArrayGenerator() {
    }

    /**
     * 数组生成器
     */
    public static Integer[] generateOrderedArray(int n) {

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }
}
