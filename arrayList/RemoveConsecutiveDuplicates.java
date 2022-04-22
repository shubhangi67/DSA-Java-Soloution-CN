package arrayList;

import java.util.ArrayList;

public class RemoveConsecutiveDuplicates {
	public static ArrayList<Integer> removeConsecutiveDupliactes(int[] arr)
	{
		ArrayList<Integer> res = new ArrayList<Integer>();
		res.add(arr[0]);
		for(int i=1;i<arr.length;i++)
		{
			if(arr[i]!=arr[i-1])
			{
				res.add(arr[i]);
			}
		}
		return res;
	}
	public static void main(String[] args) {
		int arr[]= {10,10,20,20,20,30,40,10};
		ArrayList<Integer> result=removeConsecutiveDupliactes(arr);
		for(int i=0;i<result.size();i++)
		{
			System.out.print(result.get(i)+ " ");
		}
		
	}

}
