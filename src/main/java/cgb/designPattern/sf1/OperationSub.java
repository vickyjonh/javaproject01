package cgb.designPattern.sf1;

/**
 * @Description:
 * @Author: guxiao
 * @Date:Create：2020/9/5 16:15
 */
public class OperationSub extends Operation {
    @Override
    public double getResult() {
        double result = 0d;
        result = numberA - numberB;
        return result;
    }
}
