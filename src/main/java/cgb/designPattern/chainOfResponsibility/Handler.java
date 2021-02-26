package cgb.designPattern.chainOfResponsibility;

/**
 * @Description: 处理请求的接口
 * @Author: guxiao
 * @Date:Create：2021/2/25 15:53
 */
public abstract class Handler {
    protected Handler successor;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public abstract void handleRequest(int request);
}
