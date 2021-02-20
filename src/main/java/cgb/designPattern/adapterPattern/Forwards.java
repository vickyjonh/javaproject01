package cgb.designPattern.adapterPattern;

/**
 * @Description:
 * @Author: guxiao
 * @Date:Create：2021/2/20 17:17
 */
public class Forwards extends Player {
    public Forwards(String name) {
        super(name);
    }
    @Override
    public void attack() {
        System.out.println("前锋"+name+"进攻");
    }

    @Override
    public void defense() {
        System.out.println("前锋"+name+"防守");
    }
}
