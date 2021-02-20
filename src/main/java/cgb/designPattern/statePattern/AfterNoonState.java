package cgb.designPattern.statePattern;

/**
 * @Description: 下午工作状态
 * @Author: guxiao
 * @Date:Create：2021/2/19 17:41
 */
public class AfterNoonState extends State {
    @Override
    public void writeProgram(Work w) {
        if(w.getHour() < 17) {
            System.out.println("当前时间: "+w.getHour()+"点，下午状态还不错，继续努力");
        } else {
            w.setState(new EveningState());
            w.writeProgram();
        }
    }
}
