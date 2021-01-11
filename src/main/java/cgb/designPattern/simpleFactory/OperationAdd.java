package cgb.designPattern.simpleFactory;

/**
 * @Description:
 * @Author: guxiao
 * @Date:Create：2020/9/5 11:21
 */
public class OperationAdd extends Operation {
    @Override
    public double getResult() {
        double result = 0;
        result = numberA + numberB;
        return result;
    }
}
