package cgb.designPattern.compositePattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 枝节点行为，用来存储子部件
 * @Author: guxiao
 * @Date:Create：2021/2/23 17:32
 */
public class Composite extends Component {
    private List<Component> children = new ArrayList<Component>();

    public Composite(String name) {
        super(name);
    }

    @Override
    public void add(Component c) {
        children.add(c);
    }

    @Override
    public void remove(Component c) {
        children.remove(c);
    }

    @Override
    public void display(int depth) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<depth;i++) {
            sb.append("-");
        }
        sb.append(name);
        System.out.println(sb.toString());
        for(Component component : children) {
            component.display(depth + 2);
        }
    }
}
