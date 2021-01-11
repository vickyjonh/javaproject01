package cgb.designPattern.strategyPattern;

/**
 * @Description: 策略与简单工厂结合
 * @Author: guxiao
 * @Date:Create：2020/9/5 14:18
 */
public class CashContext {
    private CashSuper cs;
    public CashContext(String type) {
        switch (type){
            case "正常收费":
                cs = new CashNormal();
                break;
            case "满300返100":
                cs = new CashReturn("300","100");
                break;
            case "打八折":
                cs = new CashRebate("0.8");
                break;
        }
    }

    public double getResult(double money) {
        return cs.acceptCash(money);
    }
}
