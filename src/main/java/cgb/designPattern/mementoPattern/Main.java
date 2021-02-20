package cgb.designPattern.mementoPattern;

/**
 * @Description:
 * @Author: guxiao
 * @Date:Create：2021/2/20 18:25
 */
public class Main {
    public static void main(String[] args) {
        /*GameRole role = new GameRole();
        // 大战Boss前
        role.getInitState();
        role.stateDisplay();

        // 保存进度
        GameRole backup = new GameRole();
        backup.setVit(role.getVit());
        backup.setAck(role.getAck());
        backup.setDef(role.getDef());

        // 大战Boss时，损耗严重
        role.fight();
        role.stateDisplay();

        // 恢复之前的状态
        role.setAck(backup.getAck());
        role.setVit(backup.getVit());
        role.setDef(backup.getDef());
        role.stateDisplay();*/

        GameRole role = new GameRole();
        // 大战Boss前
        role.getInitState();
        role.stateDisplay();

        // 保存进度
        RoleStateCaretaker stateAdmin = new RoleStateCaretaker();
        stateAdmin.setMemento(role.saveState());

        // 大战Boss时，损耗严重
        role.fight();
        role.stateDisplay();

        // 恢复之前的状态
        role.recoveryState(stateAdmin.getMemento());
        role.stateDisplay();
    }
}
