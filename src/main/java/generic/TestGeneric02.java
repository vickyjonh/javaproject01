package generic;

import java.util.ArrayList;
import java.util.List;

public class TestGeneric02 {
	
	static void doPrint01(
		List<? extends Object> list){
		list.remove(0);
		System.out.println(list);
	}
	static void doPrint02(
			List<? super Integer> list){
		list.remove(0);
		System.out.println(list);
	}
	

	public static void main(String[] args) {
		List<Integer> list1=
		new ArrayList<Integer>();
		list1.add(10);
		list1.add(100);
		doPrint01(list1);
		
		doPrint02(list1);
		
		List<Number> list2=new ArrayList<>();
		list2.add(200);
		list2.add(500);
		doPrint02(list2);
		
		
		
		
		
		
	}
}
