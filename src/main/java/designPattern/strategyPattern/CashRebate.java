package designPattern.strategyPattern;

/**
 * @Description: 打折收费子类
 * @Author: guxiao
 * @Date:Create：2020/9/5 13:52
 */
public class CashRebate extends CashSuper {
    private double moneyRebate = 1d;

    public CashRebate(String moneyRebate) {
        this.moneyRebate = Double.parseDouble(moneyRebate);
    }

    @Override
    public double acceptCash(double money) {
        return money * moneyRebate;
    }
}
