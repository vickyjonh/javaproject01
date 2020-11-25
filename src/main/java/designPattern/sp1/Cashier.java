package designPattern.sp1;

import java.util.Scanner;

/**
 * @Description:
 * @Author: guxiao
 * @Date:Create：2020/9/7 17:18
 */
public class Cashier {
    public static void main(String[] args) {
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
        totalPrice = cc.getResult(Double.valueOf(amount)*Double.valueOf(price));
        total += totalPrice;
        System.out.println("结果是:"+total);
    }
}
