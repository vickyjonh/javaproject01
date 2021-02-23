package cgb.designPattern.compositePattern;

/**
 * @Description: 组合中的对象声明接口，实现所有共有接口的默认行为
 * @Author: guxiao
 * @Date:Create：2021/2/23 17:26
 */
public abstract class Component {
    protected String name;
    public Component(String name) {
        this.name = name;
    }

    public abstract void add(Component c);
    public abstract void remove(Component c);
    public abstract void display(int depth);
}
