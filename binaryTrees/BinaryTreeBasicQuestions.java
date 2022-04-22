package binaryTrees;

import java.util.Scanner;

public class BinaryTreeBasicQuestions {
	// Complexity is O(n)
	public static BinaryTreeNode<Integer> takeTreeInput(boolean isRoot, int parentData, boolean isLeft) {
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
		BinaryTreeNode<Integer> leftChild = takeTreeInput(false, rootData, true);
		BinaryTreeNode<Integer> rightChild = takeTreeInput(false, rootData, false);
		root.left = leftChild;
		root.right = rightChild;
		return root;
	}

	public static void printTree(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + ":");
		if (root.left != null) {
			System.out.print("L-" + root.left.data + ", ");
		}
		if (root.right != null) {
			System.out.print("L-" + root.right.data + ", ");
		}
		System.out.println();
		printTree(root.left);
		printTree(root.right);
	}

	// Its time complexity is O(n);
	public static int countNodes(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		int leftNode = countNodes(root.left);
		int rightNode = countNodes(root.right);
		return 1 + leftNode + rightNode;
	}

	// Its Time Complexity is O(n);
	public static int LargestNodeinBinaryTree(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return -1;
		}
		int leftLargest = LargestNodeinBinaryTree(root.left);
		int rightLargest = LargestNodeinBinaryTree(root.right);
		return Math.max(root.data, Math.max(leftLargest, rightLargest));
	}

	// Its Time Complexity is O(n);
	public static void printAtDepthk(BinaryTreeNode<Integer> root, int k) {
		if (root == null) {
			return;
		}
		if (k == 0) {
			System.out.println(root.data);
			return;
		}
		printAtDepthk(root.left, k - 1);
		printAtDepthk(root.right, k - 1);
	}

	public static int TotalNumberOfLeaves(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 1;
		}
		return TotalNumberOfLeaves(root.left) + TotalNumberOfLeaves(root.right);
	}

	public static BinaryTreeNode<Integer> removeLeaves(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return null;
		}

		if (root.left == null && root.right == null) {
			return null;
		}
		root.left = removeLeaves(root.left);
		root.right = removeLeaves(root.right);
		return root;
	}

	public static void mirrorBinaryTree(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		mirrorBinaryTree(root.left);
		mirrorBinaryTree(root.right);
		BinaryTreeNode<Integer> temp;
		temp = root.left;
		root.left = root.right;
		root.right = temp;
	}
	public static BinaryTreeNode<Integer> buildTreeFromPretoInorderHelper(int[] pre, int[] in, int siPre, int eiPre, int siIn, int eiIn)
	{
		return null;
	}
	public static BinaryTreeNode<Integer> buildTreeFromPretoInoder(int pre[], int in[]) {
		BinaryTreeNode<Integer> root = buildTreeFromPretoInorderHelper(pre, in, 0, pre.length, 0, pre.length);
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeNode<Integer> root = takeTreeInput(true, 0, true);
		printTree(root);
		System.out.println("Total Number of the nodes are :- " + countNodes(root));
		System.out.println("Largest Node value in Binary tree :- " + LargestNodeinBinaryTree(root));
		printAtDepthk(root, 1);
		System.out.println("Total Number of the Leaves :-" + TotalNumberOfLeaves(root));
		BinaryTreeNode<Integer> head = removeLeaves(root);
		printTree(head);
	}

}
