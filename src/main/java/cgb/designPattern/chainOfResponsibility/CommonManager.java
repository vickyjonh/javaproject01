package cgb.designPattern.chainOfResponsibility;

/**
 * @Description: 总经理类
 * @Author: guxiao
 * @Date:Create：2021/2/25 16:10
 */
public class CommonManager extends Manager{
    public CommonManager(String name) {
        super(name);
    }

    @Override
    public void requestApplications(Request request) {
        if("请假".equals(request.getRequestType()) && request.getNumber() <= 2) {
            System.out.println(name +":" + request.getRequestContent()+"数量"+request.getNumber()+"被批准");
        } else {
            if(superior != null) {
                superior.requestApplications(request);
            }
        }
    }
}
