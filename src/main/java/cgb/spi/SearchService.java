package cgb.spi;

import java.util.List;

/**
 * 有两个实现类：
 * FileSearchServiceImpl
 * DatabaseSearchServiceImpl
 * 怎么加载这两个类：在项目src目录下创建META-INF文件夹，必须符合这个规范
 */
public interface SearchService {
	List<Object> search(String keyword);  
}
