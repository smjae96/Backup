package codewars_0308.sol;

import java.util.List;
import java.util.stream.Collectors;

public class ListFiltering {
	public static List<Object> filterList(final List<Object> list) {
//		List<Object> result = new ArrayList();
//		for(int i=0; i<list.size(); i++) {
//			if(list.get(i) instanceof Integer) {
//				result.add(list.get(i));
//			}
//		}
//		return result;
		System.out.println(list.stream().filter(null));
		return list.stream()
			      .filter(e -> e instanceof Integer)
			      .collect(Collectors.toList());
		
	}
}
