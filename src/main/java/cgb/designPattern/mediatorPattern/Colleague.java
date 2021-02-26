package cgb.designPattern.mediatorPattern;

/**
 * @Description: 抽象同事类
 * @Author: guxiao
 * @Date:Create：2021/2/25 17:29
 */
public abstract class Colleague {
    protected Mediator mediator;
    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }


}
