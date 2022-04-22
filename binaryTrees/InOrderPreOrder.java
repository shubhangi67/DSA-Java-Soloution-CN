package binaryTrees;

public class InOrderPreOrder {
	public static BinaryTreeNode<Integer> buildTreefromPreIn(int[] pre, int[] in) {
		BinaryTreeNode<Integer> root = buildTreefromPreInHelper(pre, in, 0, pre.length - 1, 0, in.length - 1);
		return root;
	}

	public static BinaryTreeNode<Integer> buildTreefromPreInHelper(int[] pre, int[] in, int siPre, int eiPre, int siIn,
			int eiIn) {

		if (siPre > eiPre) {
			return null;
		}
		int rootData = pre[siPre];
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);

		int rootIndex = -1;
		for (int i = siIn; i <= eiIn; i++) {
			if (in[i] == rootData)
				;
			rootIndex = i;
			break;
		}

		int siPreLeft = siPre + 1;
		int siInLeft = siIn;
		int eiInLeft = rootIndex - 1;

		int eiPreRight = eiPre;
		int siInRight = rootIndex + 1;
		int eiInRight = eiIn;

		int leftSubTreeLength = eiInLeft - siInLeft + 1;

		int eiPreLeft = siPreLeft + leftSubTreeLength - 1;

		int siPreRight = eiPreLeft + 1;

		BinaryTreeNode<Integer> left = buildTreefromPreInHelper(pre, in, siPreLeft, eiPreLeft, siInLeft, eiInLeft);
		BinaryTreeNode<Integer> right = buildTreefromPreInHelper(pre, in, siPreRight, eiPreRight, siInRight, eiInRight);
		root.left = left;
		root.right = right;
		return root;
	}

	public static BinaryTreeNode<Integer> buildTree(int[] pre, int[] in) {

		return buildTree(pre, in, 0, pre.length - 1, 0, in.length - 1);

	}

	public static BinaryTreeNode<Integer> buildTree(int[] pre, int[] in, int preSI, int preEI, int inSI, int inEI) {

		if (inSI > inEI || preSI > preEI) {
			return null;
		}
		int mid = 0;
		int data = pre[preSI];
		for (int i = inSI; i <= inEI; i++) {
			if (in[i] == data) {
				mid = i;
				break;
			}
		}

		int leftPreSI = preSI + 1;
		int leftPreEI = leftPreSI + mid - inSI - 1;
		int leftInSI = inSI;
		int leftInEI = mid - 1;
		int rightPreSI = leftPreEI + 1;
		int rightPreEI = preEI;
		int rightInSI = mid + 1;
		int rightInEI = inEI;

		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(data);
		root.left = buildTree(pre, in, leftPreSI, leftPreEI, leftInSI, leftInEI);
		root.right = buildTree(pre, in, rightPreSI, rightPreEI, rightInSI, rightInEI);
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
			System.out.print("R-" + root.right.data + ", ");
		}
		System.out.println();
		printTree(root.left);
		printTree(root.right);
	}

	public static void main(String[] args) {
		int in[] = { 4, 2, 5, 1, 3 };
		int pre[] = { 1, 2, 4, 5, 3 };
		BinaryTreeNode<Integer> root = buildTree(pre, in);
		printTree(root);
	}

}
