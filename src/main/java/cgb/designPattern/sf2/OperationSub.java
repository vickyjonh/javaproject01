package cgb.designPattern.sf2;

/**
 * @Description:
 * @Author: guxiao
 * @Date:Create：2020/9/5 16:28
 */
public class OperationSub extends Operation {
    @Override
    public double getResult() {
        double result = 0d;
        result = numberA - numberB;
        return result;
    }
}
