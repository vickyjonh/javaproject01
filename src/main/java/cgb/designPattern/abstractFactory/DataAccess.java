package cgb.designPattern.abstractFactory;

import java.lang.reflect.Constructor;

/**
 * @Description:
 * @Author: guxiao
 * @Date:Create：2021/2/18 17:59
 */
public class DataAccess {
    private static final String assemblyName = "cgb.designPattern.abstractFactory";
    private static final String db = "SqlServer";
    static Object newInstance01(Class<?> cls)
            throws Exception{
        //1.基于字节码对象(Class对象)获取构造方法对象
        Constructor<?> con=
                cls.getDeclaredConstructor();//无参构造
        //2.基于构造方法发对象构建类的对象
        //2.1设置构造方法可访问
        con.setAccessible(true);
        //2.2构建类的对象并返回
        return con.newInstance();
    }

    public static IUser createUser() throws Exception {
        /*IUser result = null;
        switch (db) {
            case "Sqlserver" :
                result = new SqlServerUser();
                break;
            case "Access" :
                result = new AccessUser();
                break;
        }
        return result;*/
        String className = assemblyName + "." + db + "User";
        Class<?> c1 = Class.forName(className);
        return (SqlServerUser)newInstance01(c1);
    }

    public static IDepartment createDepartment() throws Exception {
        /*IDepartment result = null;
        switch (db) {
            case "Sqlserver" :
                result = new SqlServerDepartment();
                break;
            case "Access" :
                result = new AccessDepartment();
                break;
        }
        return result;*/
        String className = assemblyName + "." + db + "Department";
        Class<?> c1 = Class.forName(className);
        return (SqlServerDepartment)newInstance01(c1);
    }
}
