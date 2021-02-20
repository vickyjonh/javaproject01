package cgb.designPattern.adapterPattern;

/**
 * @Description:
 * @Author: guxiao
 * @Date:Create：2021/2/20 17:25
 */
public class Translator extends Player {
    private ForeignCenter fc = new ForeignCenter();
    public Translator(String name) {
        super(name);
        fc.setName(name);
    }
    @Override
    public void attack() {
        fc.attack();
    }

    @Override
    public void defense() {
        fc.defense();
    }
}
