package TimeComplexity;

public class ArrayEquilibrium {
	public static int equilibrium(int[] arr)
	{
		int RightSum=0;
		int leftSum=0;
		for(int i=0;i<arr.length;i++)
		{
			RightSum+=arr[i];
		}
		for(int i=0;i<arr.length;i++)
		{
			RightSum-=arr[i];
			if(RightSum==leftSum)
			{
				return i;
			}
			leftSum+=arr[i];
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] arr= {2,3,10,-10,4,2,9};
		System.out.println(equilibrium(arr));

	}

}
