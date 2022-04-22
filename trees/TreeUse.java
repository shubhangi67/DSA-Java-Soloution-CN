package trees;

import java.util.LinkedList;
import java.util.Scanner;

import queue.QueueUsingArray;
import queue.QueueusingLinkedlist;

@SuppressWarnings("unused")
public class TreeUse {
	public static TreeNode<Integer> takeInput(Scanner s) {
		int n;

		System.out.println("Enter next node data");
		n = s.nextInt();
		TreeNode<Integer> root = new TreeNode<Integer>(n);
		System.out.println("Enter number of children for " + n);
		int childCount = s.nextInt();
		for (int i = 0; i < childCount; i++) {
			TreeNode<Integer> child = takeInput(s);
			root.children.add(child);
		}
		return root;

	}

	public static void print(TreeNode<Integer> root) {
		String s = root.data + ":";
		for (int i = 0; i < root.children.size(); i++) {
			s = s + root.children.get(i).data + ",";
		}
		System.out.println(s);
		for (int i = 0; i < root.children.size(); i++) {
			print(root.children.get(i));
		}

	}

	public static TreeNode<Integer> takeInputlevelWise() {
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		System.out.println("Enter root data");
		int rootData = s.nextInt();
		QueueusingLinkedlist<TreeNode<Integer>> pendingNodes = new QueueusingLinkedlist<>();
		TreeNode<Integer> root = new TreeNode<Integer>(rootData);
		pendingNodes.enqueue(root);
		while (!pendingNodes.isEmpty()) {
			TreeNode<Integer> frontNode = pendingNodes.dequeue();
			System.out.println("Enter num of children of " + frontNode.data);
			int numChildren = s.nextInt();
			for (int i = 0; i < numChildren; i++) {
				System.out.println("Enter " + (i+1) +"th child of " + frontNode.data);
				int child = s.nextInt();
				TreeNode<Integer> childNode = new TreeNode<Integer>(child);
				frontNode.children.add(childNode);
				pendingNodes.enqueue(childNode);
			}
		}
		return root;
	}
	
	public static void printLevelWise(TreeNode<Integer> root){
        if(root==null) {
			return ;
		}
		QueueusingLinkedlist<TreeNode<Integer>> queue = new QueueusingLinkedlist<>();
		queue.enqueue(root);
		queue.enqueue(null);
		while(!queue.isEmpty()) {
			TreeNode<Integer> frontNode = queue.front();
			if(frontNode==null) {
				System.out.println();
				if(!queue.isEmpty()) {
					queue.enqueue(null);
				}
			}else {
				System.out.print(frontNode.data+" ");
				for(int i=0;i<frontNode.children.size();i++) {
//					System.out.print(frontNode.children.get(i).data+",");
					queue.enqueue(frontNode.children.get(i));
				}
			}
		}
		

	}

	public static int largest(TreeNode<Integer> root)
	{
		if(root == null)
		{
			return Integer.MIN_VALUE;
		}
		int ans = root.data;
		for(int i=0;i<root.children.size();i++)
		{
			int childLargest = largest(root.children.get(i));
			if(childLargest > ans)
			{
				ans = childLargest;
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		//TreeNode<Integer> root = takeInput(s);
        TreeNode<Integer> root = takeInput(s);
		print(root);
		System.out.println(largest(root));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
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
