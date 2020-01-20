package pkg;

/**
 * @ClassName Search
 * @Description  这个类是用来测试自定义类加载器的
 * @Author: guxiao
 * @Date: 2019/9/2 17:29
 */
public class Search {
    static {
        System.out.println("search static02");
    }
    public Search() {
        System.out.println("search constructor02");
    }
}
