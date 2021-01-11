package cgb.designPattern.decoratePattern;

/**
 * @Description:
 * @Author: guxiao
 * @Date:Create：2020/9/10 11:03
 */
public class Tie extends Finery {
    @Override
    public void show() {
        System.out.print("领带 ");
        super.show();
    }
}
