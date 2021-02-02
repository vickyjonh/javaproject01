package cgb.designPattern.builderPattern;

/**
 * @Description:
 * @Author: guxiao
 * @Date:Create：2021/2/2 9:05
 */
abstract class Builder {
    abstract void buildPartA();
    abstract void buildPartB();
    abstract Product getResult();
}
