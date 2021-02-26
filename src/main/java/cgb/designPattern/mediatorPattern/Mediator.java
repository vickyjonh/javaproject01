package cgb.designPattern.mediatorPattern;

/**
 * @Description: 抽象中介者类
 * @Author: guxiao
 * @Date:Create：2021/2/25 17:28
 */
public abstract class Mediator {
    public abstract void send(String message,Colleague colleague);
}
