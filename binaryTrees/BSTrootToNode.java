package binaryTrees;

import java.util.ArrayList;

public class BSTrootToNode {
	public static ArrayList<Integer> nodeToRootpath(BinaryTreeNode<Integer> root, int x) {
		if (root == null) {
			return null;
		}
		if (root.data == x) {
			ArrayList<Integer> output = new ArrayList<>();
			output.add(root.data);
			return output;
		}
		ArrayList<Integer> leftOutput = nodeToRootpath(root.left, x);
		if (leftOutput != null) {
			leftOutput.add(root.data);
			return leftOutput;
		}
		ArrayList<Integer> rightOutput = nodeToRootpath(root.right, x);
		if (rightOutput != null) {
			rightOutput.add(root.data);
			return rightOutput;
		}
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

}
