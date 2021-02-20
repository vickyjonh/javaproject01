package cgb.designPattern.statePattern;

/**
 * @Description: 上午工作状态
 * @Author: guxiao
 * @Date:Create：2021/2/19 17:41
 */
public class ForenoonState extends State {
    @Override
    public void writeProgram(Work w) {
        if(w.getHour() < 12) {
            System.out.println("当前时间: "+w.getHour()+"点，上午工作，精神百倍");
        } else {
            w.setState(new NoonState());
            w.writeProgram();
        }
    }
}
