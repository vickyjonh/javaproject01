package cgb.designPattern.abstractFactory;

/**
 * @Description:
 * @Author: guxiao
 * @Date:Create：2021/2/8 14:50
 */
public class SqlServerFactory implements IFactory {
    @Override
    public IUser createUser() {
        return new SqlServerUser();
    }

    @Override
    public IDepartment createDepartment() {
        return new SqlServerDepartment();
    }
}
