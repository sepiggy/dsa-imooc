public class SelectionSort {

    private SelectionSort() {
    }

    public static <E extends Comparable> void sort(E[] arr) {

        for (int i = 0; i < arr.length; i++) {

            // 选择 arr[i...n) 中的最小值
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0)
                    minIndex = j;
            }

            swap(arr, i, minIndex);
        }
    }

    private static <E> void swap(E[] arr, int i, int j) {

        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {

        // 1万规模测试用例 --> 用时 0.051745 s
        // 10万规模测试用例 --> 用时 7.117795 s
        // 数据规模增加10倍，用时增加100倍
        // 因此，可以验证选择排序的时间复杂度是 O(n^2)
        int[] dataSize = {10000, 100000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            SortingHelper.sortTest("SelectionSort", arr);
        }
    }
}
