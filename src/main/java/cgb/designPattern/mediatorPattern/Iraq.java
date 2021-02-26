package cgb.designPattern.mediatorPattern;

/**
 * @Description: 伊拉克
 * @Author: guxiao
 * @Date:Create：2021/2/26 17:19
 */
public class Iraq extends Country {
    public Iraq(UnitedNations mediator) {
        super(mediator);
    }

    public void declare(String message) {
        mediator.declare(message,this);
    }

    public void getMessage(String message) {
        System.out.println("伊拉克获得对方消息："+message);
    }
}
