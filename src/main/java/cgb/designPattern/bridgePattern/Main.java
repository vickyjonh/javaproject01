package cgb.designPattern.bridgePattern;

/**
 * @Description:
 * @Author: guxiao
 * @Date:Create：2021/2/24 17:08
 */
public class Main {
    public static void main(String[] args) {
        HandsetBrand ab;
        ab = new HandsetBrandN();

        ab.setSoft(new HandsetGame());
        ab.run();

        ab = new HandsetBrandM();
        ab.setSoft(new HandsetGame());
        ab.run();

        ab.setSoft(new HandsetAddressList());
        ab.run();

        ab = new HandsetBrandS();
        ab.setSoft(new HandsetMP3());
        ab.run();

    }
}
