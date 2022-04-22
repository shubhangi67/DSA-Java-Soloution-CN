package hashMap;

import java.util.HashMap;
import java.util.Set;

public class InbuildMapUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//O(1);
		HashMap<String, Integer> map = new HashMap<>();
		map.put("abc", 1);
		map.put("def", 2);
		map.put("bvc", 4);
		//presence
		map.put("abc", 3);
		System.out.println(map.size());
		if(map.containsKey("abc"))
		{
			System.out.println("map has abc");
		}
		if(map.containsKey("abc1"))
		{
			System.out.println("map has abc1");
		}
		//getting a value
		//O(n)
		int v = map.get("abc");
		System.out.println(v);
		
		
		int v1=0;
		if(map.containsKey("abc1"))//O(1)
		{
			v1 = map.get("abc1");
		}
	
		System.out.println(v1);
		
		//remove
//		map.remove("abc");
//		if(map.containsKey("abc1"))
//		{
//			System.out.println("map has abc1");
//		}
		
		//iterate in the hashmap
		Set<String> keys=map.keySet();
		for(String s:keys)
		{
			System.out.println(s);
		}
		map.containsValue(keys);
	}

}
