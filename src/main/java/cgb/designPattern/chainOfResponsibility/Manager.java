package cgb.designPattern.chainOfResponsibility;

/**
 * @Description:
 * @Author: guxiao
 * @Date:Create：2021/2/25 16:05
 */
public abstract class Manager {
    protected String name;
    // 管理者的上级
    protected Manager superior;
    public Manager(String name) {
        this.name = name;
    }

    // 设置管理者的上级，这是一个关键方法
    public void setSuperior(Manager superior) {
        this.superior = superior;
    }

    public abstract void requestApplications(Request request);
}
