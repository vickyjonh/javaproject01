package designPattern.factoryPattern;

/**
 * @Description:
 * @Author: guxiao
 * @Date:Create：2020/9/18 17:09
 */
public class Main {
    public static void main(String[] args) {
        /*LeiFeng xueleifeng = new Undergraduate();
        xueleifeng.buyRice();
        xueleifeng.sweep();
        xueleifeng.wash();*/

        // 简单工厂模式
        /*LeiFeng studentA = new Undergraduate();
        studentA.wash();
        LeiFeng studentB = new Undergraduate();
        studentB.sweep();
        LeiFeng studentC = new Undergraduate();
        studentC.buyRice();*/

        IFactory factory = new UndergraduateFactory();// 要换成“社区志愿者”，改这里就可以
        LeiFeng stu = factory.createLeiFeng();
        stu.buyRice();
        stu.wash();
        stu.sweep();
    }
}
