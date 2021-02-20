package cgb.designPattern.statePattern;

/**
 * @Description: 晚间工作状态
 * @Author: guxiao
 * @Date:Create：2021/2/19 17:41
 */
public class EveningState extends State {
    @Override
    public void writeProgram(Work w) {
        if(w.isWorkFinished()) {
            w.setState(new RestState());
            w.writeProgram();
        } else {
            if(w.getHour() <21) {
                System.out.println("当前时间: "+w.getHour()+"点，加班哦，疲惫至极");
            } else {
                w.setState(new SleepingState());
                w.writeProgram();
            }
        }
    }
}
