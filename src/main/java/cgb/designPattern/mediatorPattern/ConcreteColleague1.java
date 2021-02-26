package cgb.designPattern.mediatorPattern;

/**
 * @Description:
 * @Author: guxiao
 * @Date:Create：2021/2/25 17:31
 */
public class ConcreteColleague1 extends Colleague {
    public ConcreteColleague1(Mediator mediator) {
        super(mediator);
    }

    public void send(String message) {
        mediator.send(message,this);
    }

    public void notifyMessage(String message) {
        System.out.println("同事1得到消息："+message);
    }
}
