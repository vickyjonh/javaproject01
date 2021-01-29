package cgb.designPattern.templateMethodPattern;

/**
 * @Description:
 * @Author: guxiao
 * @Date:Create：2021/1/29 13:07
 */
abstract class abstractClass {
    public abstract void primitiveOperation1();
    public abstract void primitiveOperation2();
    public abstract void primitiveOperation3();
    public void templateMethod() {
        primitiveOperation1();
        primitiveOperation2();
        primitiveOperation3();
        System.out.println();
    }
}
