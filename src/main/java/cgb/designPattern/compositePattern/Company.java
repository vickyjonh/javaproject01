package cgb.designPattern.compositePattern;

/**
 * @Description: 公司类
 * @Author: guxiao
 * @Date:Create：2021/2/23 17:47
 */
public abstract class Company {
    protected String name;
    public Company(String name) {
        this.name = name;
    }

    public abstract void add(Company c);// 增加
    public abstract void remove(Company c);// 移除
    public abstract void display(int depth);// 显示
    public abstract void lineOfDuty();// 履行职责
}
