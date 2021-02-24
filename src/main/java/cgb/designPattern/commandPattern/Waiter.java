package cgb.designPattern.commandPattern;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description: 执行请求
 * @Author: guxiao
 * @Date:Create：2021/2/24 18:30
 */
public class Waiter {
    private List<Command> orders = new ArrayList<>();
    // 设置订单
    public void setOrder(Command command) {
        orders.add(command);
        System.out.println("增加订单时间："+new Date());
    }

    public void cancelOrder(Command command) {
        orders.remove(command);
        System.out.println("取消订单时间："+new Date());
    }

    // 通知执行
    public void notifyExcute() {
        for (Command command : orders) {
            command.excuteCommand();
        }
    }
}
