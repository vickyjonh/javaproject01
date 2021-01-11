package cgb.designPattern.decoratePattern;

/**
 * @Description:
 * @Author: guxiao
 * @Date:Create：2020/9/10 11:03
 */
public class Sneakers extends Finery {
    @Override
    public void show() {
        System.out.print("破球鞋 ");
        super.show();
    }
}
