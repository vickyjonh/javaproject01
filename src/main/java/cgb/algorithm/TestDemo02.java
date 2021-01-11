package cgb.algorithm;

public class TestDemo02 {
    public static void main(String[] args) {
        // 斐波那契数列
        int fibonacciIndex = 7;
        int fibonacciResult = fibonacci(fibonacciIndex);
        System.out.println("下标(从0开始)" + fibonacciIndex + "的值为：" + fibonacciResult);
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
