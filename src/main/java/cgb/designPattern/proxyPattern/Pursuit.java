package cgb.designPattern.proxyPattern;

/**
 * @Description:
 * @Author: guxiao
 * @Date:Create：2020/9/11 9:41
 */
public class Pursuit implements GiveGift{
    SchoolGirl mm;
    public Pursuit(SchoolGirl mm) {
        this.mm = mm;
    }

    public void giveDolls() {
        System.out.println(mm.getName() + "送你洋娃娃");
    }

    public void giveFlowers() {
        System.out.println(mm.getName() + "送你鲜花");
    }

    public void giveChocolate() {
        System.out.println(mm.getName() + "送你巧克力");
    }


}
