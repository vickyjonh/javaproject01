package designPattern.strategyPattern;

import java.util.Scanner;

/**
 * @Description:
 * @Author: guxiao
 * @Date:Create：2020/9/5 13:37
 */
public class Cashier {
    public static void main(String[] args) {
        /*double total = 0.0d;
        System.out.println("请输入单价：");
        Scanner scanner = new Scanner(System.in);
        String price = scanner.nextLine();
        System.out.println("请输入数量：");
        String amount = scanner.nextLine();
        double tatalPrice = Double.valueOf(Double.valueOf(price) * Double.valueOf(amount));
        total += tatalPrice;
        System.out.println("总价是：" + total);*/

        /*double totalPrice = 0.0d;
        double total = 0.0d;
        String[] arr = new String[]{"正常收费","打七折","打八折","打五折"};
        String option = arr[1];
        System.out.println("请输入单价：");
        Scanner scanner = new Scanner(System.in);
        String price = scanner.nextLine();
        System.out.println("请输入数量：");
        String amount = scanner.nextLine();
        switch (option) {
            case "正常收费":
                totalPrice = Double.valueOf(Double.valueOf(price) * Double.valueOf(amount));
                break;
            case "打七折":
                totalPrice = Double.valueOf(Double.valueOf(price) * Double.valueOf(amount)*0.7);
                break;
            case "打八折":
                totalPrice = Double.valueOf(Double.valueOf(price) * Double.valueOf(amount)*0.8);
                break;
            case "打五折":
                totalPrice = Double.valueOf(Double.valueOf(price) * Double.valueOf(amount)*0.5);
                break;
        }
        total += totalPrice;
        System.out.println("总价是：" + total);*/

        /*double total = 0.0d;
        double totalPrice = 0.0d;
        CashSuper cs = CashFactory.createCashAccept("打八折");
        System.out.println("请输入单价：");
        Scanner scanner = new Scanner(System.in);
        String price = scanner.nextLine();
        System.out.println("请输入数量：");
        String amount = scanner.nextLine();
        totalPrice = cs.acceptCash(Double.valueOf(Double.valueOf(price) * Double.valueOf(amount)));
        total += totalPrice;
        System.out.println("总价是：" + total);*/

        CashContext cc = null;
        System.out.println("请输入单价：");
        Scanner scanner = new Scanner(System.in);
        String price = scanner.nextLine();
        System.out.println("请输入数量：");
        String amount = scanner.nextLine();
        System.out.println("请输入计费方式：");
        String option = scanner.nextLine();
        double totalPrice = 0d;
        cc = new CashContext(option);
        double total = 0d;
        totalPrice = cc.getResult(Double.valueOf(Double.valueOf(price) * Double.valueOf(amount)));
        total += totalPrice;
        System.out.println("总价是：" + total);

    }
}
