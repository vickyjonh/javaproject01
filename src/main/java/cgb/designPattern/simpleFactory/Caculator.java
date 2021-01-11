package cgb.designPattern.simpleFactory;

/**
 * @Description:
 * @Author: guxiao
 * @Date:Create：2020/9/5 10:27
 */
public class Caculator {
    public static void main(String[] args) {
        /*try {
            System.out.println("请输入数字A：");
            Scanner scanner = new Scanner(System.in);
            String strNumberA = scanner.nextLine();
            System.out.println("请选择符号：");
            String strOperate = scanner.nextLine();
            System.out.println("请输入数字B：");
            String strNumberB = scanner.nextLine();
            String strResult = "";
            switch (strOperate) {
                case "+":
                    strResult = String.valueOf(Double.valueOf(strNumberA) + Double.valueOf(strNumberB));
                    break;
                case "-":
                    strResult = String.valueOf(Double.valueOf(strNumberA) - Double.valueOf(strNumberB));
                    break;
                case "*":
                    strResult = String.valueOf(Double.valueOf(strNumberA) * Double.valueOf(strNumberB));
                    break;
                case "/":
                    strResult = String.valueOf(Double.valueOf(strNumberA) / Double.valueOf(strNumberB));
                    break;
            }
            System.out.println("结果是：" + strResult);
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        /*try {
            System.out.println("请输入数字A：");
            Scanner scanner = new Scanner(System.in);
            String strNumberA = scanner.nextLine();
            System.out.println("请选择符号：");
            String strOperate = scanner.nextLine();
            System.out.println("请输入数字B：");
            String strNumberB = scanner.nextLine();
            String strResult = String.valueOf(Operation.GetResult(Double.valueOf(strNumberA),Double.valueOf(strNumberB),
                    strOperate));
            System.out.println("结果是：" + strResult);
        } catch (Exception e) {
            System.out.println("您的输入有错：" + e.getMessage());
        }*/

        Operation oper;
        oper = OperationFactory.createOperate("+");
        oper.numberA = 1;
        oper.numberB = 2;
        double result = oper.getResult();
        System.out.println("结果是：" + result);

    }
}
