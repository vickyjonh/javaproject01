package designPattern.sf1;

/**
 * @Description:
 * @Author: guxiao
 * @Date:Create：2020/9/5 16:17
 */
public class OperationDiv extends Operation {
    @Override
    public double getResult() {
        double result = 0d;
        result = numberA / numberB;
        return result;
    }
}
