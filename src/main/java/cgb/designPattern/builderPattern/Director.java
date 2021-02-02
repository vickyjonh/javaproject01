package cgb.designPattern.builderPattern;

/**
 * @Description:
 * @Author: guxiao
 * @Date:Create：2021/2/2 11:11
 */
public class Director {
    public void construct(Builder builder) {
        builder.buildPartA();
        builder.buildPartB();
    }
}
