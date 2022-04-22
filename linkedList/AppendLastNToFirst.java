package linkedList;

import java.util.Scanner;

public class AppendLastNToFirst {
	public static Node<Integer> appendLastNToFirst(Node<Integer> head, int n) {
		if (head == null || n == 0) {
			return head;
		}
		Node<Integer> slow = head;
		Node<Integer> fast = head;
		Node<Integer> initialHead = head;
		for (int i = 0; i < n; i++) {
			fast = fast.next;
		}
		while(fast.next!=null)
		{
			slow = slow.next;
			fast = fast.next;
		}
		Node<Integer> temp = slow.next;
		slow.next=null;
		fast.next=initialHead;
		head = temp;
		return head;
	}
	public static Node<Integer> takeInput()
	{
		// Time Complexity is O(n) 
		Scanner s = new Scanner(System.in);
		int data = s.nextInt();
		Node<Integer> head = null, tail = null;
		while(data != -1)
		{
			Node<Integer> currentNode = new Node<Integer>(data);
			if(head == null)
			{
				// Make this node as head node;
				head = currentNode;
				tail = currentNode;
			}
			else
			{
				tail.next = currentNode;
				tail = currentNode;
				
			}
			data = s.nextInt();
		}
		return head;
	}
	public static void print(Node<Integer> head) {
		Node<Integer> temp = head;
		while (temp!= null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}

	public static void main(String[] args) {
		Node<Integer> head = takeInput();
		//appendLastNToFirst(head, 2);
		print(head);
	}

}
