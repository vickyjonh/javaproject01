package designPattern.prototypePattern;

/**
 * @Description:
 * @Author: guxiao
 * @Date:Create：2020/9/24 8:31
 */
public class WorkExperience implements Cloneable {
    private String workDate;
    private String company;

    public String getWorkDate() {
        return workDate;
    }

    public void setWorkDate(String workDate) {
        this.workDate = workDate;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
