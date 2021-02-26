package cgb.designPattern.mediatorPattern;

/**
 * @Description: 美国
 * @Author: guxiao
 * @Date:Create：2021/2/26 17:19
 */
public class USA extends Country {
    public USA(UnitedNations mediator) {
        super(mediator);
    }

    public void declare(String message) {
        mediator.declare(message,this);
    }

    public void getMessage(String message) {
        System.out.println("美国获得对方消息："+message);
    }
}
