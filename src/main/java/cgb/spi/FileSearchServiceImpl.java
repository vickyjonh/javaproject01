package cgb.spi;

import java.util.List;

public class FileSearchServiceImpl implements SearchService {

	@Override
	public List<Object> search(String keyword) {
		System.out.println("file:search:"+keyword);
		return null;
	}

}
