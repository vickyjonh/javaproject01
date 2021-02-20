package cgb.designPattern.adapterPattern;

/**
 * @Description:
 * @Author: guxiao
 * @Date:Create：2021/2/20 17:17
 */
public class Guards extends Player {
    public Guards(String name) {
        super(name);
    }
    @Override
    public void attack() {
        System.out.println("后卫"+name+"进攻");
    }

    @Override
    public void defense() {
        System.out.println("后卫"+name+"防守");
    }
}
