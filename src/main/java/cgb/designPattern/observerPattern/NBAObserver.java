package cgb.designPattern.observerPattern;

/**
 * @Description:被委托的对象
 * @Author: guxiao
 * @Date:Create：2021/2/6 10:49
 */
public class NBAObserver implements Observer{
    protected String name;

    public NBAObserver(String name) {
        this.name = name;
    }

    @Override
    public void doEvent(Subject s, Object obj) {
        System.out.println(s.getName()+",我是"+name+","+obj);
    }
}
