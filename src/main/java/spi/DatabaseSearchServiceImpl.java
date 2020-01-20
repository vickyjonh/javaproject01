package spi;

import java.util.List;

public class DatabaseSearchServiceImpl implements SearchService {

	@Override
	public List<Object> search(String keyword) {
	    System.out.println("database:search:"+keyword);
		return null;
	}

}
