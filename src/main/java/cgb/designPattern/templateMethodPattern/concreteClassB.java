package cgb.designPattern.templateMethodPattern;

/**
 * @Description:
 * @Author: guxiao
 * @Date:Create：2021/1/29 13:43
 */
public class concreteClassB extends abstractClass {
    @Override
    public void primitiveOperation1() {
        System.out.println("地球有多大？[]a.500平方 b.1000平方 c.很大");
        System.out.println("答案：a");
    }

    @Override
    public void primitiveOperation2() {
        System.out.println("小鸟能飞多高？[]a.10米 b.1000米 c.很高");
        System.out.println("答案：b");
    }

    @Override
    public void primitiveOperation3() {
        System.out.println("你聪明吗？[]a.聪明 b.不聪明 c.不知道");
        System.out.println("答案：a");
    }
}
