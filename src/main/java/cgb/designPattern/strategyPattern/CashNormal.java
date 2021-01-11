package cgb.designPattern.strategyPattern;

/**
 * @Description: 正常收费子类
 * @Author: guxiao
 * @Date:Create：2020/9/5 13:51
 */
public class CashNormal extends CashSuper {
    @Override
    public double acceptCash(double money) {
        return money;
    }
}
