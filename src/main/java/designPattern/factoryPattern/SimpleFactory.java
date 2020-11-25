package designPattern.factoryPattern;

/**
 * @Description:
 * @Author: guxiao
 * @Date:Create：2020/9/19 11:21
 */
public class SimpleFactory {
    public static LeiFeng createLeiFeng(String type) {
        LeiFeng result = null;
        switch (type) {
            case "学雷锋的大学生":
                result = new Undergraduate();
                break;
            case "社区志愿者":
                result = new Volunteer();
                break;
        }
        return result;
    }
}
