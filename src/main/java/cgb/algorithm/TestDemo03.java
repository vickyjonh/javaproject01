package cgb.algorithm;

public class TestDemo03 {
    public static void main(String[] args) {
        // 兔子的总对数
        int rabbitNumber = fibonacci(12);
        System.out.println("第 12 个月兔子的总对数是：" + rabbitNumber);
    }
    /**
     * 斐波那契数列
     * @param index 斐波那契数列的下标（从0开始）
     * @return int
     */
    private static int fibonacci(int index) {
        if (index == 0 || index == 1) {
            return index;
        } else {
            return fibonacci(index - 1) + fibonacci(index - 2);
        }
    }
}
