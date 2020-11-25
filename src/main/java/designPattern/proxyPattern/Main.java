package designPattern.proxyPattern;

/**
 * @Description:
 * @Author: guxiao
 * @Date:Create：2020/9/11 9:44
 */
public class Main {
    public static void main(String[] args) {
        SchoolGirl jiaojiao = new SchoolGirl();
        jiaojiao.setName("李娇娇");
        /*Pursuit zhuojiayi = new Pursuit(jiaojiao);
        zhuojiayi.giveDolls();
        zhuojiayi.giveFlowers();
        zhuojiayi.giveChocolate();*/

        Proxy daili = new Proxy(jiaojiao);
        daili.giveDolls();
        daili.giveFlowers();
        daili.giveChocolate();



    }
}
