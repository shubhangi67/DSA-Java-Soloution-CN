package linkedList;

import java.util.Scanner;

public class TakeInputLL {
	public static Node<Integer> takeInput() {
		//Time complexity of taking of output is 0(n2)
		Scanner s = new Scanner(System.in);
		int data = s.nextInt();
		Node<Integer> head = null, tail=null;
		while (data != -1) {
			Node<Integer> currentNode = new Node<Integer>(data);
			if (head == null) {
				// Make this node as head node
				head = currentNode;
				tail = currentNode;
			} else {
//				Node<Integer> tail = head;
//				while(tail.next!= null)
//				{
//					tail= tail.next;
//				}
//				//Now tail will refer to last node
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
		while (temp!= null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}

	public static void main(String[] args) {
		 Node<Integer> d =takeInput();
		 print(d);
	}

}
