// p068. 使用递归方式进行求和
public class Sum {

    // 对数组arr各个元素进行求和
    public static int sum(int[] arr) {
        return sum(arr, 0);
    }

    // 递归函数sum的宏观语意: 计算arr[l...n)这个区间内所有数字的和
    // arr: 数组
    // l: 左边界索引
    private static int sum(int[] arr, int l) {
        // 1) 求解最基本问题
        // 计算数组arr[n..n)所有数字之和
        if (l == arr.length)
            return 0;
        return arr[l] + sum(arr, l + 1); // 2) 把原问题转化成更小的问题
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(sum(nums));
    }
}
