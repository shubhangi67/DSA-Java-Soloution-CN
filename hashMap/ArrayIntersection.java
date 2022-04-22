package hashMap;

import java.util.HashMap;

public class ArrayIntersection {
	public static void intersection(int[] arr1, int[] arr2) {
//		for (int i = 0; i < arr1.length; i++) {
//			for (int j = 0; j < arr2.length; j++) {
//				if (arr1[i] == arr2[j]) {
//					System.out.print(arr1[i]+" ");
//					arr2[j] = Integer.MAX_VALUE;
//					break;
//				}
//
//			}
//		}
		
		// Its time complexity is O(m+n)
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr1.length; i++) {
			if(map.containsKey(arr1[i]))
			{
				int value =map.get(arr1[i]);
				map.put(arr1[i], value+1);
			}
			else
			{
				map.put(arr1[i], 1);
			}
		}
		for(int i=0;i<arr2.length;i++)
		{
			if(map.containsKey(arr2[i]))
			{
				int freq = map.get(arr2[i]);
				if(freq>0)
				{
					System.out.print(arr2[i]+" ");
					map.put(arr2[i], freq-1);
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] arr1 = { 1, 3, 2, 2, 3, 6, 2, 5 };
		int[] arr2 = { 2, 4, 2, 3, 5, 6, 6 };
		intersection(arr1, arr2);
		//3 2 2 6 5 
		//2 2 3 5 6 

	}

}
