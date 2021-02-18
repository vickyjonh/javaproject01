package cgb.designPattern.observerPattern;

/**
 * @Description:委托者接口
 * @Author: guxiao
 * @Date:Create：2021/2/6 10:53
 */
public interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void event(Subject s,Observer o,Object obj);
    void eventAll(Subject s,Object obj);
    String getName();
}
