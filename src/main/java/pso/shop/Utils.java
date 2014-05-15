package pso.shop;

import java.util.ArrayList;
import java.util.List;

public class Utils {
	public static <T> List<T> iterablesToList(Iterable<T> iterable) {
		List<T> list = new ArrayList<T>();
		for (T t: iterable) {
			list.add(t);
		}
		return list;
	}

}
