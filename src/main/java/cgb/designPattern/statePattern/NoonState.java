package cgb.designPattern.statePattern;

/**
 * @Description: 中午工作状态
 * @Author: guxiao
 * @Date:Create：2021/2/19 17:41
 */
public class NoonState extends State {
    @Override
    public void writeProgram(Work w) {
        if(w.getHour() < 13) {
            System.out.println("当前时间: "+w.getHour()+"点，饿了，午休");
        } else {
            w.setState(new AfterNoonState());
            w.writeProgram();
        }
    }
}
