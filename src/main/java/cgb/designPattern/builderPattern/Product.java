package cgb.designPattern.builderPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: guxiao
 * @Date:Create：2021/2/2 8:54
 */
public class Product {
    List<String> parts = new ArrayList<>();
    public void add(String part) {
        parts.add(part);
    }

    public void show() {
        System.out.println("产品 创建----");
        for (String part : parts) {
            System.out.println(part);
        }
    }
}
