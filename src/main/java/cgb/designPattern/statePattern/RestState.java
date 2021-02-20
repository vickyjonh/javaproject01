package cgb.designPattern.statePattern;

/**
 * @Description: 下班休息状态
 * @Author: guxiao
 * @Date:Create：2021/2/19 17:41
 */
public class RestState extends State {
    @Override
    public void writeProgram(Work w) {
        System.out.println("当前时间："+w.getHour() +"点，下班回家了");
    }
}
