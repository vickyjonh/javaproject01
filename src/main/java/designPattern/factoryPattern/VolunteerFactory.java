package designPattern.factoryPattern;

/**
 * @Description:
 * @Author: guxiao
 * @Date:Create：2020/9/19 13:07
 */
public class VolunteerFactory implements IFactory {

    @Override
    public LeiFeng createLeiFeng() {
        return new Volunteer();
    }
}
