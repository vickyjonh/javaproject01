package cgb.designPattern.compositePattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 具体公司类，树枝节点
 * @Author: guxiao
 * @Date:Create：2021/2/23 17:49
 */
public class ConcreteCompany extends Company {
    private List<Company> children = new ArrayList<>();

    public ConcreteCompany(String name) {
        super(name);
    }

    @Override
    public void add(Company c) {
        children.add(c);
    }

    @Override
    public void remove(Company c) {
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
        for(Company c : children) {
            c.display(depth + 2);
        }
    }

    @Override
    public void lineOfDuty() {
        for(Company c : children) {
            c.lineOfDuty();
        }
    }
}
