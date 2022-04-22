package trees;

import java.util.Scanner;



public class TreeUse2 {
	public static TreeNode<Integer> takeInput(Scanner s)
	{
		
		System.out.println("Enter next node  data");
		int n = s.nextInt();
		TreeNode<Integer> root = new TreeNode<Integer>(n);
		System.out.println("Enter number of children "+ n);
		int childCount = s.nextInt();
		for(int i = 0; i< childCount; i++)
		{
			TreeNode<Integer> child = takeInput(s);
			root.children.add(child);
		}
		return root;
	}

	public static void print(TreeNode<Integer> root)
	{
		String s = root.data + ":";
		for(int i =0; i< root.children.size();i++)
		{
			s = s + root.children.get(i).data + ",";
		}
		System.out.println(s);
		for(int i =0; i< root.children.size();i++)
		{
			print(root.children.get(i));
		}
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		TreeNode<Integer> root = takeInput(s);
		print(root);
		
//		TreeNode<Integer> root = new TreeNode<Integer>(4);
//		TreeNode<Integer> node1 = new TreeNode<Integer>(6);
//		TreeNode<Integer> node2 = new TreeNode<Integer>(8);
//		TreeNode<Integer> node3 = new TreeNode<Integer>(10);
//		TreeNode<Integer> node4 = new TreeNode<Integer>(12);
//		root.children.add(node1);
//		root.children.add(node2);
//		root.children.add(node3);
//		node2.children.add(node4);
//		
//		System.out.println(root);
	}

}
