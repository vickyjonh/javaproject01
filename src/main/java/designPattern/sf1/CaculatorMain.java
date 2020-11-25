package designPattern.sf1;

/**
 * @Description:
 * @Author: guxiao
 * @Date:Create：2020/9/5 16:22
 */
public class CaculatorMain {
    public static void main(String[] args) {
        Operation oper = null;
        oper = OperationFactory.createOperate("+");
        oper.numberA = 1;
        oper.numberB = 2;
        double result = oper.getResult();
        System.out.println("结果是：" + result);
    }
}
