package stack;

public class StackUsingArray {
	private int data[];
	private int topIndex;

	public StackUsingArray() {
		data = new int[10];
		topIndex = -1;
	}
	public StackUsingArray(int size) {
		data = new int[size];
		topIndex = -1;
	}
	public boolean isEmpty() {
//		if(topIndex==-1)
//		{
//			return true;
//		}
//		return false;
		return topIndex == -1;

	}

	public void push(int element) throws StackFullException {
		//If stack is full
		{
			if(topIndex == data.length - 1)
			{
				throw new StackFullException();
			}
		}
		data[++topIndex] = element;

	}

	public int size() {
		return topIndex + 1;

	}

	public int top() throws StackFullException {
		if(topIndex == data.length - 1)
		{
			throw new StackFullException();
		}
		return data[topIndex];

	}
	
	public int pop() throws StackFullException {
		if(topIndex == data.length - 1)
		{
			throw new StackFullException();
		}
		int temp = data[topIndex];
		topIndex--;
		return temp;

	}

}
