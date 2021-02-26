package cgb.designPattern.mediatorPattern;

/**
 * @Description:
 * @Author: guxiao
 * @Date:Create：2021/2/26 17:37
 */
public class Main1 {
    public static void main(String[] args) {
        UnitedNationSecurityCouncil unsc = new UnitedNationSecurityCouncil();
        USA c1 = new USA(unsc);
        Iraq c2 = new Iraq(unsc);

        unsc.setColleague1(c1);
        unsc.setColleague2(c2);

        c1.declare("不准研制核武器，否则发动战争");
        c2.declare("我们不怕核武器，也不怕侵略");
    }
}
