package binaryTrees;

import java.util.*;

public class LevelWiseInput {

	public static BinaryTreeNode<Integer> takeinputlevelWise() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the root");
		int rootData = s.nextInt();
		if (rootData == -1) {
			return null;
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		Queue<BinaryTreeNode<Integer>> pendingChildren = new LinkedList<BinaryTreeNode<Integer>>();
		pendingChildren.add(root);
		while (!pendingChildren.isEmpty()) {
			BinaryTreeNode<Integer> front = pendingChildren.poll();
			System.out.println("Enter the left Child " + front.data);
			int left = s.nextInt();
			if (left != -1) {
				BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(left);
				front.left = leftChild;
				pendingChildren.add(leftChild);
			}

			System.out.println("Enter the right Child " + front.data);
			int right = s.nextInt();
			if (right != -1) {
				BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(right);
				front.right = rightChild;
				pendingChildren.add(rightChild);
			}
		}

		return root;

	}

	// time Complexity O(n)
	public static void printLevelWise(BinaryTreeNode<Integer> root) {
		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {

			BinaryTreeNode<Integer> frontNode = queue.poll();

			System.out.print(frontNode.data + ":");
			if (frontNode.left != null) {
				System.out.print("L:" + frontNode.left.data + ",");
				queue.add(frontNode.left);
			} else {
				System.out.print("L:" + -1 + ",");
			}
			if (frontNode.right != null) {
				System.out.print("R:" + frontNode.right.data);
				queue.add(frontNode.right);
			} else {
				System.out.print("R:" + -1);
			}
			System.out.println();
		}
	}
	public static void inOrder​(BinaryTreeNode<Integer> root) 
	{ 
//		if(root == null) {   ​// Base case when node’s value is null 
//			return​; 
//		} 
//		inOrder​(root.left);  ​//Recursive call over left part as it needs  
//		                           // to be printed first 
//		System.out.print(root.data);  ​// Now printed root’s data 
//		inOrder​(root.right); ​//Finally recursive call made over right subtree 
		// Base case when node’s value is null 
		if(root == null)
		{
			return;
		}
		inOrder​(root.left);      
		System.out.println(root.data);
		inOrder​(root.right);
		
	} 
	public static boolean isBST(BinaryTreeNode<Integer> root)
	{
		if(root == null)
		{
			return true;
		}
		int leftMax = maximum(root.left);
		if(leftMax >= root.data)
		{
			return false;
		}
		int rightMin = minimum(root.right);
		if(rightMin < root.data)
		{
			return false;
		}
		boolean isLeftBST = isBST(root.left);
		boolean isRightBST = isBST(root.right);
		return isLeftBST && isRightBST;
	}
	public static int minimum(BinaryTreeNode<Integer> root)
	{
		if(root == null)
		{
			return Integer.MAX_VALUE;
		}
		int leftMin = minimum(root.left);
		int RightMin = minimum(root.right);
		return Math.min(root.data, Math.min(leftMin, RightMin));
	}
	public static int maximum(BinaryTreeNode<Integer> root)
	{
		if(root == null)
		{
			return Integer.MAX_VALUE;
		}
		int leftMin = maximum(root.left);
		int RightMin = maximum(root.right);
		return Math.max(root.data, Math.max(leftMin, RightMin));
	}
	
	public static ArrayList<Integer> nodeToRootPath(BinaryTreeNode<Integer> root , int x)
	{
		if(root == null)
		{
			return null;
		}
		if(root.data == x)
		{
			ArrayList<Integer> output = new ArrayList<>();
			output.add(root.data);
			return output;
		}
		ArrayList<Integer> leftOutput = nodeToRootPath(root.left, x);
		if(leftOutput != null)
		{
			leftOutput.add(root.data);
			return leftOutput;
		}
		ArrayList<Integer> rightOutput = nodeToRootPath(root.right, x);
		if(rightOutput != null)
		{
			rightOutput.add(root.data);
			return rightOutput;
		}
		return null;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeNode<Integer> root = takeinputlevelWise();
		printLevelWise(root);

	}

}
