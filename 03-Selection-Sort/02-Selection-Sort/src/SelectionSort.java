public class SelectionSort {

    private SelectionSort() {
    }

    /**
     * 说明：原地排序方式实现选择排序
     * 输入：原数组
     * 输出：原数组按从小到大排序后返回
     * 该函数没有返回值不代表该算法没有输出
     */
    public static void sort(int[] arr) {

        // 第1重循环维持循环不变量： arr[0...i) 是有序的; arr[i...n) 是无序的
        for (int i = 0; i < arr.length; i++) {

            // 第2重循环处理位置i，选择 arr[i...n) 中最小值的索引
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }

            swap(arr, i, minIndex);
        }
    }

    private static void swap(int[] arr, int i, int j) {

        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {

        int[] arr = {1, 4, 2, 3, 6, 5};
        SelectionSort.sort(arr);
        for (int e : arr)
            System.out.print(e + " ");
        System.out.println();
    }
}
