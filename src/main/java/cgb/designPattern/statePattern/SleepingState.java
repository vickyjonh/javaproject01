package cgb.designPattern.statePattern;

/**
 * @Description: 睡眠状态
 * @Author: guxiao
 * @Date:Create：2021/2/19 17:41
 */
public class SleepingState extends State {
    @Override
    public void writeProgram(Work w) {
        System.out.println("当前时间："+w.getHour() +"点，不行了，睡着了");
    }
}
