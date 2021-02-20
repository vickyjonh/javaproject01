package cgb.designPattern.adapterPattern;

/**
 * @Description:
 * @Author: guxiao
 * @Date:Create：2021/2/20 17:20
 */
public class Main {
    public static void main(String[] args) {
        Player b = new Forwards("巴蒂尔");
        b.attack();
        Player m = new Guards("麦格");
        m.attack();
        Player ym = new Translator("姚明");
        ym.attack();
        ym.defense();
    }
}
