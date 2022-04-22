package binaryTrees;

public class BST {
	private BinaryTreeNode<Integer> root;
	private int size;
	//Time Complexity is O(n);
	public boolean isPresent(int x) {

		return isPresentHelper(root, x);
	}

	private static boolean isPresentHelper(BinaryTreeNode<Integer> root, int x) {
		if (root == null) {
			return false;
		}
		if (root.data == x) {
			return true;
		}
		if (x < root.data) {
			return isPresentHelper(root.left, x);
		} else {
			return isPresentHelper(root.right, x);
		}
	}

	public void insert(int x) {
		insert(root, x);
		size++;
	}

	private static BinaryTreeNode<Integer> insert(BinaryTreeNode<Integer> root, int x) {
		if (root == null) {
			BinaryTreeNode<Integer> newRoot = new BinaryTreeNode<Integer>(x);
			return newRoot;
		}
		if (x >= root.data) {
			root.right = insert(root.right, x);
		} else {
			root.left = insert(root.left, x);
		}
		return root;
	}

	public boolean deleteData(int x) {
		BSTDeleteReturn output = deleteDataHelper(root, x);
		root = output.root;
		if(output.deleted)
		{
			size--;
		}
		return output.deleted;
	}
	private static int minimum(BinaryTreeNode<Integer> root)
	{
		if(root==null)
			return Integer.MAX_VALUE;
		
		int leftMin=minimum(root.left);
		int rightMin=minimum(root.right);
		
		return Math.min(root.data, Math.min(leftMin, rightMin));
	}
	private static BSTDeleteReturn deleteDataHelper(BinaryTreeNode<Integer> root, int x)
	{
		if( root == null)
		{
			return new BSTDeleteReturn(null, false);
		}
		if(root.data < x)
		{
			BSTDeleteReturn outputRight = deleteDataHelper(root.right, x);
			root.right = outputRight.root;
			outputRight.root = root;
			return outputRight;
		}
		
		if(root.data > x)
		{
			BSTDeleteReturn outputLeft = deleteDataHelper(root.left, x);
			root.left = outputLeft.root;
			outputLeft.root = root;
			return outputLeft;
		}
		//0 children
		if(root.left == null && root.right == null)
		{
			return new BSTDeleteReturn(null, true);
		}
		//Only left children
		if(root.left != null && root.right == null)
		{
			return new BSTDeleteReturn(root.left, true);
		}
		if(root.left == null && root.right != null)
		{
			return new BSTDeleteReturn(root.right, true);
		}
		int rightMin = minimum(root.right);
		root.data = rightMin;
		BSTDeleteReturn outputRight = deleteDataHelper(root.right, rightMin);
		root.right=outputRight.root;
		return new BSTDeleteReturn(root, true);
	}

	public int size() {
		return size;
		
	}

	public void printTree() {

		printTreehelper(root);
	}

	private static void printTreehelper(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + ":");
		if (root.left != null) {
			System.out.print("L-" + root.left.data + ", ");
		}
		if (root.right != null) {
			System.out.print("R-" + root.right.data + ", ");
		}
		System.out.println();
		printTreehelper(root.left);
		printTreehelper(root.right);
	}

}
