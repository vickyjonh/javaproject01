package cgb.designPattern.mementoPattern;

/**
 * @Description: 角色状态管理者
 * @Author: guxiao
 * @Date:Create：2021/2/20 18:34
 */
public class RoleStateCaretaker {
    private RoleStateMemento memento;

    public RoleStateMemento getMemento() {
        return memento;
    }

    public void setMemento(RoleStateMemento memento) {
        this.memento = memento;
    }
}
