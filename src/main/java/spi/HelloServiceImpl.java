package spi;

public class HelloServiceImpl implements IService {

	@Override
	public void service() {
	  System.out.println("say hello");
	}
}
