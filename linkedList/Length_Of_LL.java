package linkedList;

public class Length_Of_LL {
	public static Node<Integer> createdLinkedList() {
		Node<Integer> n1 = new Node<>(10);
		Node<Integer> n2 = new Node<>(20);
		Node<Integer> n3 = new Node<>(30);
		Node<Integer> n4 = new Node<>(40);
		Node<Integer> n5 = new Node<>(50);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		return n1;
	}
	public static int length(Node<Integer> head) {
		Node<Integer> temp = head;
		int count=1;
		if(head == null)
		{
			return 0;
		}
		while (temp!= null) {
			
			temp = temp.next;
			count++;
		}
		return count;
	}
	public static void main(String[] args) {
		Node<Integer> head = createdLinkedList();
		//print(head);
		System.out.println(length(head));
		

	}

}
