package cgb.designPattern.statePattern;

/**
 * @Description:
 * @Author: guxiao
 * @Date:Create：2021/2/19 17:16
 */
public class Work {
    private int hour;
    private boolean workFinished = false;
    private State current;

    public Work() {
        current = new ForenoonState();
    }

    public void setState(State s) {
        this.current = s;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public boolean isWorkFinished() {
        return workFinished;
    }

    public void setWorkFinished(boolean workFinished) {
        this.workFinished = workFinished;
    }

    public void writeProgram() {
        current.writeProgram(this);
    }

}
