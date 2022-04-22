package trees;

import java.util.ArrayList;

public class TreeNode<T> {
	public T data;
	public ArrayList<TreeNode<T>> children;
	/**
	 * @param data
	 * @param children
	 */
	public TreeNode(T data) {
		
		this.data = data;
		children = new ArrayList<>();
	}

}
