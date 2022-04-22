package binaryTrees;

import java.util.Scanner;

public class BinaryTreeUse {
	public static int numNodes(BinaryTreeNode<Integer> root)
	{
		if(root == null)
		{
			return 0;
		}
		int leftNodeCount = numNodes(root.left);
		int rightNodeCount = numNodes(root.right);
		return 1+ leftNodeCount+rightNodeCount;
	}
	public static int largest(BinaryTreeNode<Integer> root)
	{
		if(root == null)
		{
			return -1;
		}
		int largestLeft = largest(root.left);
		int largestRight = largest(root.right);
		return Math.max(root.data, Math.max(largestLeft, largestRight));
	}
	public static BinaryTreeNode<Integer> takeTreeInputBetter(boolean isRoot, int parentData, boolean isLeft) {
		if (isRoot) {
			System.out.println("Enter root data");
		} else {
			if (isLeft) {
				System.out.println("Enter the Left Child " + parentData);
			} else {
				System.out.println("Enter the Right Child " + parentData);
			}
		}
		
		Scanner s = new Scanner(System.in);
		int rootData = s.nextInt();

		if (rootData == -1) {
			return null;
		}

		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		BinaryTreeNode<Integer> leftChild = takeTreeInputBetter(false, rootData, true);
		BinaryTreeNode<Integer> rightChild = takeTreeInputBetter(false, rootData, false);
		root.left = leftChild;
		root.right = rightChild;
		return root;

	}

	public static BinaryTreeNode<Integer> takeTreeInput() {
		System.out.println("Enter root data");
		Scanner s = new Scanner(System.in);
		int rootData = s.nextInt();

		if (rootData == -1) {
			return null;
		}

		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		BinaryTreeNode<Integer> leftChild = takeTreeInput();
		BinaryTreeNode<Integer> rightChild = takeTreeInput();
		root.left = leftChild;
		root.right = rightChild;
		return root;

	}

	public static void printTreeDetailed(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		// System.out.println(root.data + ":L " + root.left.data + ", R " +
		// root.right.data);
		System.out.print(root.data + ":");
		if (root.left != null) {
			System.out.print("L-" + root.left.data + ", ");
		}
		if (root.right != null) {
			System.out.print("R-" + root.right.data + ", ");
		}
		System.out.println();
		printTreeDetailed(root.left);
		printTreeDetailed(root.right);
	}

	public static void printTree(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		System.out.println(root.data);
		printTree(root.left);
		printTree(root.right);

//		System.out.println(root.data);
//		if( root.left != null)
//		{
//			printTree(root.left);
//		}
//		if( root.right != null)
//		{
//			printTree(root.right);
//		}

	}
	
	public static BinaryTreeNode<Integer> removeLeaves(BinaryTreeNode<Integer> root)
	{
		if(root == null)
		{
			return null;
		}
		if(root.left == null && root.right == null)
		{
			return null;
		}
		root.left = removeLeaves(root.left);
		root.right = removeLeaves(root.right);
		return root;
	}
	
		public static void main(String[] args) {
//		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
//		BinaryTreeNode<Integer> rootLeft = new BinaryTreeNode<>(2);
//		BinaryTreeNode<Integer> rootRight = new BinaryTreeNode<>(3);
//		root.left = rootLeft;
//		root.right = rootRight;
//		BinaryTreeNode<Integer> twoRight = new BinaryTreeNode<>(4);
//		BinaryTreeNode<Integer> ThreeLeft = new BinaryTreeNode<>(5);
//		
//		rootLeft.right = twoRight;
//		rootRight.left = ThreeLeft;
//		printTree(root);
		BinaryTreeNode<Integer> root = takeTreeInputBetter(true,0,true);
		
		printTreeDetailed(root);
		System.out.println("Number of nodes "+numNodes(root));
		System.out.println("largest "+largest(root));
		BinaryTreeNode<Integer> newRoot =removeLeaves(root);
		printTreeDetailed(newRoot);

	}

}
