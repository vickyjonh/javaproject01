package cgb.designPattern.compositePattern;

/**
 * @Description: 财务部，树叶节点
 * @Author: guxiao
 * @Date:Create：2021/2/23 17:49
 */
public class FinanceDepartment extends Company {
    public FinanceDepartment(String name) {
        super(name);
    }

    @Override
    public void add(Company c) {
    }

    @Override
    public void remove(Company c) {
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

    @Override
    public void lineOfDuty() {
        System.out.println(name + "公司财务收支管理");
    }
}
