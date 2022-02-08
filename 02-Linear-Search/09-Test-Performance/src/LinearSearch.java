public class LinearSearch {

    private LinearSearch() {
    }

    /**
     * ! what 循环不变量？
     * ! 循环不变量 --> data[0..i-1] 中没有找到目标
     * ! 循环体的作用就是维护循环不变量
     * ! 循环不变量可以用来“证明”算法的正确性（数学归纳法）
     * ! 理解循环不变量的概念有助于我们写出正确的代码
     */
    public static <E> int search(E[] data, E target) {

        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(target)) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

//        int n = 10000;
//        Integer[] data = ArrayGenerator.generateOrderedArray(n);
//
//        long start = System.currentTimeMillis();
//        for (int k = 0; k < 100; k++)
//            LinearSearch.search(data, n);
//        long time = System.currentTimeMillis() - start;
//        System.out.println("n = " + n + " , 100 runs : " + time + "ms");

        int[] dataSize = {1000000, 10000000};
        for (int n : dataSize) {
            Integer[] data = ArrayGenerator.generateOrderedArray(n);

            long startTime = System.nanoTime();
            for (int k = 0; k < 100; k++) { // 运行 100 次
                LinearSearch.search(data, n);
            }
            long endTime = System.nanoTime();

            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("n = " + n + ", 100 runs : " + time + "s");
        }
    }
}
