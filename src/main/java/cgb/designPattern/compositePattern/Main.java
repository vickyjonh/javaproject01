package cgb.designPattern.compositePattern;

/**
 * @Description:
 * @Author: guxiao
 * @Date:Create：2021/2/23 17:36
 */
public class Main {
    public static void main(String[] args) {
        Composite root = new Composite("root");
        root.add(new Leaf("Leaf A"));
        root.add(new Leaf("Leaf B"));
        Composite comp = new Composite("Composite X");
        comp.add(new Leaf("Leaf XA"));
        comp.add(new Leaf("Leaf XB"));

        root.add(comp);
        Composite comp2 = new Composite("Composite X");
        comp2.add(new Leaf("Leaf XYA"));
        comp2.add(new Leaf("Leaf XYB"));
        comp.add(comp2);

        root.add(new Leaf("C"));
        Leaf leaf = new Leaf("D");
        root.add(leaf);
        root.remove(leaf);
        root.display(1);

    }
}
