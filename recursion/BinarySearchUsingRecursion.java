package recursion;

public class BinarySearchUsingRecursion {

	public static int search(int[] a, int startIndex, int endIndex, int x) {
		if (startIndex > endIndex) {
			return -1;
		}
		int mid = (startIndex + endIndex) / 2;
		if (a[mid] == x) {
			return mid;
		} else if (a[mid] < x) {
			return search(a, mid + 1, endIndex, x);
		} else {
			return search(a, startIndex, mid - 1, x);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,3,4,5,6,7,8};
		System.out.println(search(a, 0, a.length-1, 100));
	}

}
