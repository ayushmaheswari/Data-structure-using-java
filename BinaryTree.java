public class BinaryTree
{
	Node root;
	static class Node
	{
		int key;
		Node left,right;

		public Node(int item)
		{
			key = item;
			left = right = null;
		}
	}

	public BinaryTree()
	{
		root = null;
	}

	public Node insert(Node root,int value)
	{
		if(root==null)
		{
			root = new Node(value);
			return root;
		}
		else if(root.key > value)
		{
			root.left = insert(root.left,value);
		}
		else if(root.key < value)
		{
			root.right = insert(root.right,value);
		}
		return root;
	}
	public void insertValue(int value)
	{
		root = insert(root,value);
	}
	public void pre(Node root)
	{
		if(root!=null)
		{
			System.out.print(root.key+" ");
			pre(root.left);
			pre(root.right);
		}
	}
	public void preorder()
	{
		pre(root);
		System.out.println("");
	}

	public void in(Node root)
	{
		if(root!=null)
		{
			in(root.left);
			System.out.print(root.key+" ");
			in(root.right);
		}
	}
	public void inorder()
	{
		in(root);
		System.out.println("");
	}


	public void post(Node root)
	{
		if(root!=null)
		{
			post(root.left);
			post(root.right);
			System.out.print(root.key+" ");
		}
	}
	public void postorder()
	{
		post(root);
		System.out.println("");
	}

	static int minValue(Node root)
	{
		int min = root.key;
		while(root.left!=null)
		{
			min = root.left.key;
			root = root.left;
		}
		return min;
	}

	public Node delete(Node root,int value)
	{
		if(root==null)
		{
			return root;
		}
		else if(root.key < value)
		{
			root.right = delete(root.right,value);
		}
		else if(root.key > value)
		{
			root.left = delete(root.left,value);
		}
		else
		{
			if(root.left == null)
			{
				return root.right;
			}
			else if(root.right == null)
			{
				return root.left;
			}
			root.key = minValue(root.right);
			root.right = delete(root.right,root.key);
		}
		return root;
	}
	public void deleteValue(int value)
	{
		root = delete(root,value);
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		
		tree.insertValue(10);
		tree.insertValue(15);
		tree.insertValue(18);
		tree.insertValue(100);
		tree.insertValue(47);
		tree.insertValue(19);
		tree.insertValue(5);

		tree.preorder();
		tree.inorder();
		tree.postorder();

		tree.deleteValue(100);
		tree.deleteValue(19);

		tree.preorder();
		tree.inorder();
		tree.postorder();

		tree.insertValue(100);
		tree.insertValue(1);
		tree.insertValue(180);
		tree.insertValue(170);
		tree.insertValue(140);
		tree.insertValue(1500);
		tree.insertValue(1260);

		tree.preorder();
		tree.inorder();
		tree.postorder();

		tree.deleteValue(1);
		tree.deleteValue(1500);

		tree.preorder();
		tree.inorder();
		tree.postorder();

	}
}