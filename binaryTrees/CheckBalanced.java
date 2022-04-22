package binaryTrees;

import java.util.Scanner;

public class CheckBalanced {
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
	//The complexity in worst case O(n2)
	//in normal is n(logn)
	public static boolean isBalanced(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return true;
		}
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);

		if (Math.abs(leftHeight - rightHeight) > 1) {
			return false;
		}
		boolean isLeftBalanced = isBalanced(root.left);
		Boolean isRightBalanced = isBalanced(root.right);

		return isLeftBalanced && isRightBalanced;
	}

	public static int height(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(height(root.left), height(root.right));
	}

	public static BalancedTreeBetter isBalancedBetter(BinaryTreeNode<Integer> root)
	{
		if(root == null)
		{
			int height = 0;
			boolean isBal = true;
			BalancedTreeBetter ans =new BalancedTreeBetter();
			ans.height=height;
			ans.isBal = isBal;
			return ans;
		}
		BalancedTreeBetter leftOutput = isBalancedBetter(root.left);
		BalancedTreeBetter rightOutput = isBalancedBetter(root.right);
		boolean isBal = true;
		int height = 1 + Math.max(leftOutput.height, rightOutput.height);
		
		
		if(Math.abs(leftOutput.height - rightOutput.height)>1)
		{
			isBal = false;
		}
		
		if(!leftOutput.isBal || !rightOutput.isBal)
		{
			isBal = false;
		}
		
		BalancedTreeBetter ans = new BalancedTreeBetter();
		ans.height=height;
		ans.isBal = isBal;
		return ans;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeNode<Integer> root = takeTreeInputBetter(true, 0, true);
		System.out.println(isBalanced(root));
		System.out.println("Is Balanced " + isBalancedBetter(root).isBal);

	}

}
