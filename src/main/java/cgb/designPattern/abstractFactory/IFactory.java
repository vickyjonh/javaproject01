package cgb.designPattern.abstractFactory;

/**
 * @Description:
 * @Author: guxiao
 * @Date:Create：2021/2/8 14:49
 */
public interface IFactory {
    IUser createUser();
    IDepartment createDepartment();
}
