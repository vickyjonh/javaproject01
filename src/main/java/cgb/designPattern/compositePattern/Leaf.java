package cgb.designPattern.compositePattern;

/**
 * @Description: 叶节点对象
 * @Author: guxiao
 * @Date:Create：2021/2/23 17:28
 */
public class Leaf extends Component{
    public Leaf(String name) {
        super(name);
    }

    @Override
    public void add(Component c) {
        System.out.println("can not add to a leaf");
    }

    @Override
    public void remove(Component c) {
        System.out.println("can not remove from a leaf");
    }

    @Override
    public void display(int depth) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<depth;i++) {
            sb.append("-");
        }
        sb.append(name);
        System.out.println(sb.toString());
    }
}
