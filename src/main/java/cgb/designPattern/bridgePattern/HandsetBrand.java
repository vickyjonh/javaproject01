package cgb.designPattern.bridgePattern;

/**
 * @Description: 手机品牌类
 * @Author: guxiao
 * @Date:Create：2021/2/24 17:10
 */
public abstract class HandsetBrand {
    // 品牌需要关注软件，所以可以在机器中安装软件
    protected HandsetSoft soft;

    public void setSoft(HandsetSoft soft) {
        this.soft = soft;
    }

    public abstract void run();
}
