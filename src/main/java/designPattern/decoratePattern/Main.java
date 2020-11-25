package designPattern.decoratePattern;

import com.sun.istack.internal.FinalArrayList;

/**
 * @Description:
 * @Author: guxiao
 * @Date:Create：2020/9/10 10:54
 */
public class Main {
    public static void main(String[] args) {
        Person xc = new Person("小蔡");
        System.out.println("第一种装扮：");
        /*xc.wearTShirts();
        xc.wearBigTrousers();
        xc.wearSneakers();*/

        /*Finery ts = new TShits();
        Finery bt = new BigTrouser();
        Finery sk = new Sneakers();
        ts.show();
        bt.show();
        sk.show();
        xc.show();*/

        Sneakers sk = new Sneakers();
        BigTrouser bt = new BigTrouser();
        TShits tt = new TShits();
        sk.decorate(xc);
        bt.decorate(sk);
        tt.decorate(bt);
        tt.show();

        System.out.println("\n第二种装扮：");
        /*xc.wearSuit();
        xc.wearTie();
        xc.wearLeatherShoes();*/

        /*Finery st = new Suit();
        Finery te = new Tie();
        Finery ls = new LeatherShoes();
        st.show();
        te.show();
        ls.show();
        xc.show();*/

        Suit st = new Suit();
        Tie ti = new Tie();
        LeatherShoes ls = new LeatherShoes();
        st.decorate(xc);
        ti.decorate(st);
        ls.decorate(ti);
        ls.show();
    }
}
