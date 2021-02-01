package cgb.designPattern.facadePattern;

/**
 * @Description:
 * @Author: guxiao
 * @Date:Create：2021/2/1 10:10
 */
public class Main {
    public static void main(String[] args) {
        /*Stock1 gu1 = new Stock1();
        Stock2 gu2 = new Stock2();
        Stock3 gu3 = new Stock3();
        NationalDebt1 nd1 = new NationalDebt1();
        Realty1 rt1 = new Realty1();
        gu1.buy();
        gu2.buy();
        gu3.buy();
        nd1.buy();
        rt1.buy();

        gu1.sell();
        gu2.sell();
        gu3.sell();
        nd1.sell();
        rt1.sell();*/

        Fund fund = new Fund();
        fund.buyFund();
        fund.sellFund();
    }
}
