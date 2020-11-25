package designPattern.decoratePattern;

/**
 * @Description:
 * @Author: guxiao
 * @Date:Create：2020/9/10 10:51
 */
public class Person {
    public Person() {}

    private String name;

    public Person(String name) {
        this.name = name;
    }

    /*public void wearTShirts() {
        System.out.print("大T恤 ");
    }

    public void wearBigTrousers() {
        System.out.print("垮裤 ");
    }

    public void wearSneakers() {
        System.out.print("破球鞋 ");
    }

    public void wearTie() {
        System.out.print("领带 ");
    }

    public void wearSuit() {
        System.out.print("西装 ");
    }

    public void wearLeatherShoes() {
        System.out.print("皮鞋 ");
    }*/

    public void show() {
        System.out.print("装扮的" + name);
    }


}
