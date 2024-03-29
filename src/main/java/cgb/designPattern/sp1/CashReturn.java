package cgb.designPattern.sp1;

/**
 * @Description:
 * @Author: guxiao
 * @Date:Create：2020/9/7 17:09
 */
public class CashReturn extends CashSuper {
    private double moneyCondition = 0.0d;
    private double moneyReturn = 0.0d;
    public CashReturn(String moneyCondition, String moneyReturn) {
        this.moneyCondition = Double.valueOf(moneyCondition);
        this.moneyReturn = Double.valueOf(moneyReturn);
    }

    @Override
    public double acceptCash(double money) {
        double result = money;
        if(money>=moneyCondition) {
            result = money - Math.floor(money / moneyCondition)*moneyReturn;
        }
        return result;
    }
}
