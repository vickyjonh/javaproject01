package cgb.designPattern.abstractFactory;

/**
 * @Description:
 * @Author: guxiao
 * @Date:Create：2021/2/8 14:44
 */
public interface IUser {
    void insertUser(User user);
    User getUser(int id);
}
