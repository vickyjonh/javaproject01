package cgb.designPattern.commandPattern;

/**
 * @Description:调用接收者相应的操作
 * @Author: guxiao
 * @Date:Create：2021/2/24 18:26
 */
public class BakeMuttonCommand extends Command {
    public BakeMuttonCommand(Barbecuer receiver) {
        super(receiver);
    }
    @Override
    public void excuteCommand() {
        receiver.bakeMutton();
    }
}
