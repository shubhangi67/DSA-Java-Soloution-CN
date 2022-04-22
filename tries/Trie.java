package tries;

class TrieNode {
	char data;
	boolean isTerminating;
	TrieNode children[];
	int childCount;
	public TrieNode(char data) {
		this.data = data;
		isTerminating = false;
		children = new TrieNode[26];
		childCount=0;
	}

}
//Mam Explained Coding ninjas
public class Trie {

	private TrieNode root;
	public int count;
	public Trie() {
		root = new TrieNode('\0');
	}

	public boolean search(String word) {
        return search(root, word);
    }
    private boolean search(TrieNode root,String word) {
        if(word.length()==0) {
            // if(root.isTerminating) {
            //     return true;
            // }
            // return false;
            return root.isTerminating;
        }
        int childIndex = word.charAt(0)-'a';
        TrieNode child = root.children[childIndex];
        if(child==null) {
            return false;
        }
        return search(child, word.substring(1));

    }


	private void add(TrieNode root, String word){
		if(word.length() == 0){
			root.isTerminating = true;
			return;
		}		
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if(child == null){
			child = new TrieNode(word.charAt(0));
			root.children[childIndex] = child;
			root.childCount++;
		}
		add(child, word.substring(1));

	}

	public void add(String word){
		add(root, word);
	}
	public int count()
	{
		return root.childCount;
	}
	public void remove(String word)
	{
		remove(root,word);
	}

	private void remove(TrieNode root, String word) {
		if(word.length() == 0){
			root.isTerminating = false;
			return;
		}		
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if(child == null){
			return;
		}
		remove(child,word.substring(1));
	}
}
