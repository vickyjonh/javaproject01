package cgb.designPattern.sp1;

/**
 * @Description:
 * @Author: guxiao
 * @Date:Create：2020/9/7 17:07
 */
public class CashRebate extends CashSuper {
    private double moneyRebate = 1d;
    public CashRebate(String moneyRebate) {
        this.moneyRebate = Double.valueOf(moneyRebate);
    }
    @Override
    public double acceptCash(double money) {
        return money*moneyRebate;
    }
}
