package cgb.designPattern.mediatorPattern;

/**
 * @Description:
 * @Author: guxiao
 * @Date:Create：2021/2/25 17:35
 */
public class Main {
    public static void main(String[] args) {
        ConcreteMediator  m = new ConcreteMediator();
        ConcreteColleague1 c1 = new ConcreteColleague1(m);
        ConcreteColleague2 c2 = new ConcreteColleague2(m);

        m.setConcreteColleague1(c1);
        m.setConcreteColleague2(c2);

        c1.notifyMessage("吃过饭了吗？");
        c2.notifyMessage("没有呢，你打算请客？");
    }
}
