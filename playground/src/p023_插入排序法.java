public class p023_插入排序法 {

    public static void insertSort(int[] arr) {

        // [1st loop] 维持循环不变量: arr[0,i) 已排序，arr[i,n) 未排序
        for (int i = 0; i < arr.length; i++) {

            // [2st loop] 处理元素 i，把 arr[i] 放到合适的位置

        }
    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void main(String[] args) {

    }
}
