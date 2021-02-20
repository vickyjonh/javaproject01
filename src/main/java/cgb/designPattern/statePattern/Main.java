package cgb.designPattern.statePattern;

/**
 * @Description:
 * @Author: guxiao
 * @Date:Create：2021/2/19 17:29
 */
public class Main {
    public static void main(String[] args) {
        Work work = new Work();
        work.setHour(9);
        work.writeProgram();
        work.setHour(11);
        work.writeProgram();
        work.setHour(12);
        work.writeProgram();
        work.setHour(13);
        work.writeProgram();
        work.setHour(15);
        work.writeProgram();
        work.setHour(17);
        work.writeProgram();
        work.setWorkFinished(true);
        work.setHour(19);
        work.writeProgram();
    }
}
