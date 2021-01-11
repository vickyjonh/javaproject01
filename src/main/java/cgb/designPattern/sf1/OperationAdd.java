package cgb.designPattern.sf1;

/**
 * @Description:
 * @Author: guxiao
 * @Date:Create：2020/9/5 16:14
 */
public class OperationAdd extends Operation{
    @Override
    public double getResult() {
        double result = 0;
        result = numberA + numberB;
        return result;
    }
}
