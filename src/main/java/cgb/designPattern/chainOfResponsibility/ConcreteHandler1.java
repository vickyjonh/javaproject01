package cgb.designPattern.chainOfResponsibility;

/**
 * @Description: 具体处理者类
 * @Author: guxiao
 * @Date:Create：2021/2/25 15:58
 */
public class ConcreteHandler1 extends Handler {

    @Override
    public void handleRequest(int request) {
        if(request >= 0 && request <= 10) {
            System.out.println("ConcreteHandler1处理请求"+request);
        } else if(successor !=  null) {
            successor.handleRequest(request);
        }
    }
}
