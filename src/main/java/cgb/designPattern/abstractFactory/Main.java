package cgb.designPattern.abstractFactory;

/**
 * @Description:
 * @Author: guxiao
 * @Date:Create：2021/2/8 14:13
 */
public class Main {
    public static void main(String[] args) throws Exception {
        User user = new User();
        Department department = new Department();
        /*SqlServerUser sqlServerUser = new SqlServerUser();
        sqlServerUser.insertUser(user);
        sqlServerUser.getUser(1);*/

        /*IFactory factory = new SqlServerFactory();
        IUser iu = factory.createUser();
        iu.insertUser(user);
        iu.getUser(1);
        IDepartment id = factory.createDepartment();
        id.insert(department);
        id.getDepartment(1);*/

        IUser iu = DataAccess.createUser();
        iu.insertUser(user);
        iu.getUser(1);
        IDepartment id = DataAccess.createDepartment();
        id.insert(department);
        id.getDepartment(1);
    }
}
