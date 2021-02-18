package cgb.designPattern.abstractFactory;

/**
 * @Description:
 * @Author: guxiao
 * @Date:Create：2021/2/8 14:11
 */
public class SqlServerUser implements IUser {
    public void insertUser(User user) {
        System.out.println("在SQL Server中给User增加一条记录");
    }

    public User getUser(int id) {
        System.out.println("在SQL Server中根据id得到User表的一条记录");
        return null;
    }
}
