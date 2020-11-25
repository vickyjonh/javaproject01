package designPattern.prototypePattern;

import jdk.nashorn.internal.runtime.PrototypeObject;

/**
 * @Description:
 * @Author: guxiao
 * @Date:Create：2020/9/22 8:41
 */
public class Resume implements Cloneable {
    private String name;
    private String sex;
    private String age;
    //    private String timeArea;
//    private String company;
    private WorkExperience work;


    public Resume(String name) {
        this.name = name;
        this.work = new WorkExperience();
    }

    private Resume(WorkExperience work) throws CloneNotSupportedException {
        this.work = (WorkExperience)work.clone();
    }

    // 设置个人信息
    public void setPersonalInfo(String sex, String age) {
        this.sex = sex;
        this.age = age;
    }

    public void setWorkExperience(String workDate, String company) {
        work.setWorkDate(workDate);
        work.setCompany(company);
    }

    public void display() {
        System.out.println(name + " " + sex + " " + age);
        System.out.println("工作经历：" + work.getWorkDate() + " " + work.getCompany());
    }


    public Object clone() throws CloneNotSupportedException {
        // 浅复制
//        return super.clone();
        // 深复制
        Resume obj = new Resume(this.work);
        obj.name = this.name;
        obj.sex = this.sex;
        obj.age = this.age;
        return obj;
    }
}
