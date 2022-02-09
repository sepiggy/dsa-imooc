public class InsertionSort {

    private InsertionSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {

        for (int i = 0; i < arr.length; i++) {

            // 循环不变量: arr[0,i)已排好序; arr[i..n)未排序
            // 将 arr[i] 插入到合适的位置
            // 若arr[j]比它前面一个的元素arr[j-1]还要小, 则交换两个元素arr[j],arr[j-1]

            // 复杂写法
//            for(int j = i; j - 1 >= 0; j --){
//                if(arr[j].compareTo(arr[j - 1]) < 0)
//                    swap(arr, j - 1, j);
//                else break;
//            }

            // 简化写法
            for (int j = i; j - 1 >= 0 && arr[j].compareTo(arr[j - 1]) < 0; j--)
                swap(arr, j - 1, j);
        }
    }

    private static <E> void swap(E[] arr, int i, int j) {

        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    private static <E extends Comparable<E>> boolean isSorted(E[] arr) {

        for (int i = 1; i < arr.length; i++)
            if (arr[i - 1].compareTo(arr[i]) > 0)
                return false;
        return true;
    }

    public static void main(String[] args) {

        int[] dataSize = {10000, 100000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            SortingHelper.sortTest("InsertionSort", arr);
        }
    }
}
