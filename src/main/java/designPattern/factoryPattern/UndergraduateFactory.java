package designPattern.factoryPattern;

/**
 * @Description:
 * @Author: guxiao
 * @Date:Create：2020/9/19 13:06
 */
public class UndergraduateFactory implements IFactory {
    @Override
    public LeiFeng createLeiFeng() {
        return new Undergraduate();
    }
}
