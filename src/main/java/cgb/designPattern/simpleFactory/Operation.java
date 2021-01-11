package cgb.designPattern.simpleFactory;

/**
 * @Description:
 * @Author: guxiao
 * @Date:Create：2020/9/5 10:54
 */
public class Operation {
    public double numberA;
    public double numberB;

    public double getNumberA() {
        return numberA;
    }

    public void setNumberA(double numberA) {
        this.numberA = numberA;
    }

    public double getNumberB() {
        return numberB;
    }

    public void setNumberB(double numberB) {
        this.numberB = numberB;
    }

    public double getResult() {
        double result = 0;
        return result;
    }
}
