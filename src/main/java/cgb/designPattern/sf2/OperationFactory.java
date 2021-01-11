package cgb.designPattern.sf2;

/**
 * @Description:
 * @Author: guxiao
 * @Date:Create：2020/9/5 16:30
 */
public class OperationFactory {
    public static Operation crateOperate(String operate) {
        Operation oper = null;
        switch (operate) {
            case "+":
                oper = new OperationAdd();
                break;
            case "-":
                oper = new OperationSub();
                break;
            case "*":
                oper = new OperationMul();
                break;
            case "/":
                oper = new OperationDiv();
                break;
        }
        return oper;
    }
}
