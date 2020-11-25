package designPattern.decoratePattern;

/**
 * @Description:服饰类
 * @Author: guxiao
 * @Date:Create：2020/9/10 11:00
 */
public abstract class Finery extends Person {
    protected Person component;

    public void decorate(Person component) {
        this.component = component;
    }
    @Override
    public void show() {
        if(component != null) {
            component.show();
        }
    }
}
