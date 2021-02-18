package cgb.designPattern.observerPattern;

/**
 * @Description:被委托的对象
 * @Author: guxiao
 * @Date:Create：2021/2/5 10:00
 */
public class StockObserver implements Observer{
    protected String name;

    public StockObserver(String name) {
        this.name = name;
    }

    @Override
    public void doEvent(Subject s, Object obj) {
        System.out.println(s.getName()+",我是"+name+","+obj);
    }
}
