package cgb.designPattern.decoratePattern;

/**
 * @Description:
 * @Author: guxiao
 * @Date:Create：2020/9/10 11:04
 */
public class LeatherShoes extends Finery {
    @Override
    public void show() {
        System.out.print("皮鞋 ");
        super.show();
    }
}
