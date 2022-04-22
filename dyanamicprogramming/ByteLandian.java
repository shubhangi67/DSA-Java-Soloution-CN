package dyanamicprogramming;

import java.util.HashMap;
import java.util.Scanner;

/*Byteland has a very strange monetary system.
Each Bytelandian gold coin has an integer number written on it. A coin n can be exchanged in a bank into three coins: n/2, n/3 and n/4. But these numbers are all rounded down (the banks have to make a profit).
You can also sell Bytelandian coins for American dollars. The exchange rate is 1:1. But you can not buy Bytelandian coins.
You have one gold coin. What is the maximum amount of American dollars you can get for it?
 Input format :

The first and the only line of input contains a the integer value of 'n'. It is the number written on your coin.

Output format :

Print the the maximum amount of American dollars you can make.

Constraints :

0 <= n <= 10 ^ 9

Time Limit: 1 sec

*/
public class ByteLandian {
//	public static long bytelandian(long n, HashMap<Long, Long> memo) {
//		// Write your code here
//		if (n < 12) {
//			memo.put(n, n);
//			return n;
//		}
//
//		if (!memo.containsKey(n)) {
//			long ans1 = bytelandian(n / 2, memo);
//			long ans2 = bytelandian(n / 3, memo);
//			long ans3 = bytelandian(n / 4, memo);
//
//			long currVal = ans1 + ans2 + ans3;
//			if (currVal > n)
//				memo.put(n, currVal);
//			else
//				memo.put(n, n);
//
//		}
//
//		return memo.get(n);
//		
//	}
	public static long bytelandian(long n, HashMap<Long, Long> memo) {
		// Write your code here
		if (n <= 1) {
			return n;
		}
		if (memo.get(n) != null) {
			return memo.get(n);
		}
		long breakDownValue = bytelandian(n / 2, memo) + bytelandian(n / 3, memo) + bytelandian(n / 4, memo);
		memo.put(n, Math.max(n, breakDownValue));
		return memo.get(n);
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		long n = s.nextLong();
		HashMap<Long, Long> memo = new HashMap<Long, Long>();
		System.out.println(bytelandian(n, memo));

	}

}
