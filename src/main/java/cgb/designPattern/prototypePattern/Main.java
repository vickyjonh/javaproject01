package cgb.designPattern.prototypePattern;

/**
 * @Description:
 * @Author: guxiao
 * @Date:Create：2020/9/22 9:04
 */
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Resume a = new Resume("大鸟");
        a.setPersonalInfo("男","20");
        a.setWorkExperience("1998-2000","XX公司");


        /*Resume b = new Resume("大鸟");
        b.setPersonalInfo("男","20");
        b.setWorkExperience("1998-2000","XX公司");


        Resume c = new Resume("大鸟");
        c.setPersonalInfo("男","20");
        c.setWorkExperience("1998-2000","XX公司");
        */

        Resume b = (Resume)a.clone();
        b.setWorkExperience("1998-2006","yy企业");

        Resume c = (Resume)a.clone();
        c.setPersonalInfo("女","30");
        c.setWorkExperience("2009-2010","zz企业");

        a.display();
        b.display();
        c.display();
    }
}
