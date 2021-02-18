package cgb.designPattern.abstractFactory;

/**
 * @Description:
 * @Author: guxiao
 * @Date:Create：2021/2/18 17:43
 */
public interface IDepartment {
    void insert(Department department);
    Department getDepartment(int id);
}
