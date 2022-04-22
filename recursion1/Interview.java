package recursion1;

import java.util.Scanner;

public class Interview {

	public static void main(String[] args) {
		// n=5
		// output would be
		// 1 2 3 4 5
		// 1 2 3 4
		// 1 2 3
		// 1 2
		// 1
		Scanner s = new Scanner(System.in);
		int rows = s.nextInt();
//		int i=1;
//		while(i>=n)
//		{
//			int j =1;
//			while(j<= i)
//			{
//				System.out.print(i+ " ");
//				j++;
//			}
//			
//		System.out.println();
//		i--;
//		}

		  for (int i = 1; i <= rows; i++) 
	        {
	            //Printing i spaces at the beginning of each row
	             
	            for (int j = 1; j < i; j++) 
	            {
	                System.out.print(" ");
	            }
	             
	            //Printing i to rows value at the end of each row
	             
	            for (int j = 1; j <= rows; j++) 
	            { 
	                System.out.print(j); 
	            } 
	             
	            System.out.println(); 
	        } 

	}

}
