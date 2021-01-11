package cgb.designPattern.sp1;

/**
 * @Description:
 * @Author: guxiao
 * @Date:Create：2020/9/7 17:06
 */
public class CashNormal extends CashSuper {
    @Override
    public double acceptCash(double money) {
        return money;
    }
}
