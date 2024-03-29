package cgb.designPattern.strategyPattern;

/**
 * @Description: 现金收费工厂
 * @Author: guxiao
 * @Date:Create：2020/9/5 14:02
 */
public class CashFactory {
    public static CashSuper createCashAccept(String type) {
        CashSuper cs = null;
        switch (type) {
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
        return cs;
    }
}
