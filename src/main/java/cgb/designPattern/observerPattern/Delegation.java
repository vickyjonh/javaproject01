package cgb.designPattern.observerPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:委托对象
 * @Author: guxiao
 * @Date:Create：2021/2/5 9:59
 */
public class Delegation implements Subject {
    // 同事列表
    private List<Observer> observers = new ArrayList<>();
    private String name;

    public Delegation(String name) {
        this.name = name;
    }

    // 有几个同事请前台帮忙，就给集合增加几个对象
    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void event(Subject s, Observer o, Object obj) {
        o.doEvent(s,obj);
    }

    @Override
    public void eventAll(Subject s, Object obj) {
        for(Observer o : observers) {
            o.doEvent(s,obj);
        }
    }

    @Override
    public String getName() {
        return name;
    }

}
