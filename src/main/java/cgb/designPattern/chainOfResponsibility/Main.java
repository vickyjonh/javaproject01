package cgb.designPattern.chainOfResponsibility;

/**
 * @Description:
 * @Author: guxiao
 * @Date:Create：2021/2/25 16:02
 */
public class Main {
    public static void main(String[] args) {
        ConcreteHandler1 h1 = new ConcreteHandler1();
        ConcreteHandler2 h2 = new ConcreteHandler2();
        ConcreteHandler3 h3 = new ConcreteHandler3();
        h1.setSuccessor(h2);
        h2.setSuccessor(h3);

        int[] requests = {2,5,14,20,24,30};
        for(int request : requests) {
            h1.handleRequest(request);
        }
    }
}
