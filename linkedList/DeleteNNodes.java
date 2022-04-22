package linkedList;

public class DeleteNNodes {
	public static Node<Integer> delete(Node<Integer> head ,int M, int N)
	{
		if(head==null)
            return head;
        if(M==0)
            return null;
        if(N==0)
            return head;
        Node<Integer> curr=head,t;
        int count;
        while(curr!=null)
        {
        for(count=1;count<M && curr!=null;count++)
        {
            curr=curr.next;
        }
        if(curr==null)
            return head;
        t=curr.next;
        for(count=1;count<=N && t!=null;count++)
        {
            t=t.next;
        }
        curr.next=t;
        curr=t;}
        return head;
	}
	public static void main(String[] args) {
		
	}

}
