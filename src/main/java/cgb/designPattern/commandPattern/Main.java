package cgb.designPattern.commandPattern;

/**
 * @Description:
 * @Author: guxiao
 * @Date:Create：2021/2/24 18:00
 */
public class Main {
    public static void main(String[] args) {
        Barbecuer boy = new Barbecuer();
        Command bakeMuttonCommand1 = new BakeMuttonCommand(boy);
        Command bakeMuttonCommand2 = new BakeMuttonCommand(boy);
        Command bakeChickenWingCommand1 = new BakeChickenWingCommand(boy);

        Waiter girl = new Waiter();
        girl.setOrder(bakeMuttonCommand1);
        girl.setOrder(bakeMuttonCommand2);
        girl.setOrder(bakeChickenWingCommand1);
        girl.notifyExcute();
    }
}
