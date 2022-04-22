package queue;

import linkedList.Node;

public class QueueusingLinkedlist<T> {
	private Node<T> front;
	private Node<T> rear;
	int size;
	public QueueusingLinkedlist() {
		front = null;
		rear = null;
		size = 0;
	}
	public int size()
	{
		return size;
	}
	public boolean isEmpty()
	{
		return size == 0;
	}
	public void enqueue(T elem)
	{
		Node<T> newNode = new Node<T>(elem);
		if(rear == null)
		{
			front = newNode;
			rear = newNode;
		}
		else
		{
			rear.next = newNode;
			rear = newNode;
		}
	}
	public T front()
	{
		if(front == null)
		{
			return null;
		}
		return front.data;
	}
	public T dequeue()
	{
		if(front == null)
		{
			return null;
		}
		T temp = front.data;
		front = front.next;
		if(front == null)
		{
			rear = null;
		}
		size--;
		return temp;
	}

}
