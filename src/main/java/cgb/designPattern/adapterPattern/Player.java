package cgb.designPattern.adapterPattern;

/**
 * @Description:
 * @Author: guxiao
 * @Date:Create：2021/2/20 17:16
 */
public abstract class Player {
    protected String name;
    public Player(String name) {
        this.name = name;
    }

    public abstract void attack();
    public abstract void defense();
}
