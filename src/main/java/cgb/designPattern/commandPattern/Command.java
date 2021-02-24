package cgb.designPattern.commandPattern;

/**
 * @Description:声明执行操作的接口
 * @Author: guxiao
 * @Date:Create：2021/2/24 18:05
 */
public abstract class Command {
    protected Barbecuer receiver;
    public Command(Barbecuer receiver) {
        this.receiver = receiver;
    }
    public abstract void excuteCommand();
}
