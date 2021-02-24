package cgb.designPattern.commandPattern;

/**
 * @Description:调用接收者相应的操作
 * @Author: guxiao
 * @Date:Create：2021/2/24 18:26
 */
public class BakeChickenWingCommand extends Command {
    public BakeChickenWingCommand(Barbecuer receiver) {
        super(receiver);
    }
    @Override
    public void excuteCommand() {
        receiver.bakeChickenWing();
    }
}
