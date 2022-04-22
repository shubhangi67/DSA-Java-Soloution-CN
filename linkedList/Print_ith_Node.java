package linkedList;

public class Print_ith_Node {
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

	public static void printIthNode(Node<Integer> head, int i){
		//Your code goes here
		Node<Integer> temp = head;
        for(int j=0;j<=i && temp!= null;j++)
        {	
        	if(j==i)
        	{
        		System.out.print(temp.data);
        	}
        temp = temp.next;  
        }
       
	}

	public static void print(Node<Integer> head) {
		Node<Integer> temp = head;
		if(temp == null)
		{
			return;
		}
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> head = createdLinkedList();
		printIthNode(head, 4);
		//print(head);
	}

}
