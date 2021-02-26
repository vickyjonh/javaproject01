package cgb.designPattern.mediatorPattern;

/**
 * @Description: 国家类
 * @Author: guxiao
 * @Date:Create：2021/2/26 17:16
 */
public abstract class Country {
    protected UnitedNations mediator;
    public Country(UnitedNations mediator) {
        this.mediator = mediator;
    }
}
