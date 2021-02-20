package cgb.designPattern.mementoPattern;

/**
 * @Description:
 * @Author: guxiao
 * @Date:Create：2021/2/20 18:20
 */
public class GameRole {
    private int vit;// 生命力
    private int ack;// 攻击力
    private int def;// 防御力

    public int getVit() {
        return vit;
    }

    public void setVit(int vit) {
        this.vit = vit;
    }

    public int getAck() {
        return ack;
    }

    public void setAck(int ack) {
        this.ack = ack;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    // 保存角色状态
    public RoleStateMemento saveState() {
        return new RoleStateMemento(this.getVit(),this.getAck(),this.getDef());
    }

    public void recoveryState(RoleStateMemento memento) {
        this.setAck(memento.getAck());
        this.setVit(memento.getVit());
        this.setDef(memento.getDef());
    }

    // 状态显示
    public void stateDisplay() {
        System.out.println("角色当前状态：");
        System.out.println("体力："+this.getVit());
        System.out.println("攻击力："+this.getAck());
        System.out.println("防御力："+this.getDef());
    }

    // 获得初始状态
    public void getInitState() {
        this.setAck(100);
        this.setVit(100);
        this.setDef(100);
    }

    // 战斗
    public void fight() {
        this.setAck(0);
        this.setVit(0);
        this.setDef(0);
    }

}
