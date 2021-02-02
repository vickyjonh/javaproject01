package cgb.designPattern.builderPattern;

/**
 * @Description:
 * @Author: guxiao
 * @Date:Create：2021/2/2 10:55
 */
public class ConcreteBuilder1 extends Builder {
    private Product product = new Product();
    @Override
    void buildPartA() {
        product.add("部件A");
    }

    @Override
    void buildPartB() {
        product.add("部件B");
    }

    @Override
    public Product getResult() {
        return product;
    }
}
