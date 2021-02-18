package cgb.designPattern.observerPattern;

/**
 * @Description:
 * @Author: guxiao
 * @Date:Create：2021/2/6 9:55
 */
public class Main {
    public static void main(String[] args) {
        // 委托者
        Delegation boss = new Delegation("老板");
        // 被委托者
        StockObserver tongshi1 = new StockObserver("小三");
        NBAObserver tongshi2 = new NBAObserver("小四");
        boss.attach(tongshi1);
        boss.attach(tongshi2);
        boss.event(boss,tongshi1,"NBA直播开始了");
        boss.eventAll(boss,"股票开始涨了");
    }
}
