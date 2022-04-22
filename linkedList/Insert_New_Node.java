package linkedList;

import java.util.Scanner;

public class Insert_New_Node {

	public static Node<Integer> takeInput() {
		@SuppressWarnings("resource")
		// Time complextixity of taking of output is 0(n2)
		Scanner s = new Scanner(System.in);
		int data = s.nextInt();
		Node<Integer> head = null, tail = null;
		while (data != -1) {
			Node<Integer> currentNode = new Node<Integer>(data);
			if (head == null) {
				// Make thsi node as head node
				head = currentNode;
				tail = currentNode;
			} else {
				//				Node<Integer> tail = head;
				//				while(tail.next!= null)
				//				{
				//					tail= tail.next;
				//				}
				//				//Now tail will refer to klast node
				//				//connect current node after last node
				tail.next = currentNode;
				tail = currentNode;
			}

			data = s.nextInt();
		}
		return head;

	}

	public static void print(Node<Integer> head) {
		Node<Integer> temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	public static Node<Integer> insertNewNode(Node<Integer> head, int pos, int element) {
		Node<Integer> newNode = new Node<Integer>(element);

		if(pos==0)
		{
			newNode.next=head;
			//head=newNode;
			return newNode;

		}
		else
		{
			int count = 0;
			Node<Integer> prev = head;
			while (count < pos - 1 && prev != null) {
				count++;
				prev = prev.next;
			}
			if (prev != null) {
				newNode.next = prev.next;
				prev.next = newNode;
			}
			return head;
		}
		
	}

	public static void main(String[] args) {
		Node<Integer> d = takeInput();
		Node<Integer> t=insertNewNode(d, 0, 8);
		print(t);
	}

}
