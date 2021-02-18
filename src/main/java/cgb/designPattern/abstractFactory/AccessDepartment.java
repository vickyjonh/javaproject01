package cgb.designPattern.abstractFactory;

/**
 * @Description:
 * @Author: guxiao
 * @Date:Create：2021/2/8 14:11
 */
public class AccessDepartment implements IDepartment {
    @Override
    public void insert(Department department) {
        System.out.println("在Access中给Department增加一条记录");
    }

    @Override
    public Department getDepartment(int id) {
        System.out.println("在Access中根据id得到Department表的一条记录");
        return null;
    }
}
