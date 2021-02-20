package cgb.designPattern.mementoPattern;

/**
 * @Description: 角色状态存储箱
 * @Author: guxiao
 * @Date:Create：2021/2/20 18:32
 */
public class RoleStateMemento {
    private int vit;// 生命力
    private int ack;// 攻击力
    private int def;// 防御力

    public RoleStateMemento(int vit, int ack, int def) {
        this.vit = vit;
        this.ack = ack;
        this.def = def;
    }

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


}
