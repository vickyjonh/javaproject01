package cgb.designPattern.templateMethodPattern;

/**
 * @Description:
 * @Author: guxiao
 * @Date:Create：2021/1/29 11:22
 */
public class Main {
    public static void main(String[] args) {
        /*System.out.println("学生甲抄的试卷:");
        TestPaper1 testPaper1 = new TestPaper1();
        testPaper1.testQuestion1();
        testPaper1.testQuestion2();
        testPaper1.testQuestion3();
        System.out.println("学生乙抄的试卷:");
        TestPaper2 testPaper2 = new TestPaper2();
        testPaper2.testQuestion1();
        testPaper2.testQuestion2();
        testPaper2.testQuestion3();*/

        abstractClass c;
        c = new concreteClassA();
        c.templateMethod();

        c = new concreteClassB();
        c.templateMethod();
    }
}
