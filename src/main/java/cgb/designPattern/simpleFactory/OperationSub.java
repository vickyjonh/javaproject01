package cgb.designPattern.simpleFactory;

/**
 * @Description:
 * @Author: guxiao
 * @Date:Create：2020/9/5 11:24
 */
public class OperationSub extends Operation {
    @Override
    public double getResult() {
        double result = 0d;
        result = numberA - numberB;
        return result;
    }
}
