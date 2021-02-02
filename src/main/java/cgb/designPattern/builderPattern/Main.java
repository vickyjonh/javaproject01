package cgb.designPattern.builderPattern;

/**
 * @Description:
 * @Author: guxiao
 * @Date:Create：2021/2/2 11:12
 */
public class Main {
    public static void main(String[] args) {
        Director director = new Director();
        Builder b1 = new ConcreteBuilder1();
        Builder b2 = new ConcreteBuilder2();
        director.construct(b1);
        Product p1 = b1.getResult();
        p1.show();

        director.construct(b2);
        Product p2 = b2.getResult();
        p2.show();
    }
}
