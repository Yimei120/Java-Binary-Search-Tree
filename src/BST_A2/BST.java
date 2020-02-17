package BST_A2;

public class BST implements BST_Interface{
	public BST_Node root;
	  int size;
	  
	  public BST(){ size=0; root=null; }
	  

	  //used for testing, please leave as is
	  public BST_Node getRoot(){ return root; }


	@Override
	public boolean insert(String s) {
		BST_Node n = new BST_Node(s);
		BST_Node root_copy = null;	
		BST_Node pseu_root = root;
		
		if (root == null) {
			root = new BST_Node(s);
			return true;
		}
		
		
		int compare = 0;
		while(pseu_root != null) {
			root_copy = pseu_root;
		    compare = s.compareTo(root_copy.data);
			if(compare <0) {
				pseu_root = pseu_root.left;
			}else if (compare >0) {
				pseu_root = pseu_root.right;
			}
	
		}
		
		if (compare<0) {
			root_copy.left = n;
		}else if (compare >0) {
			root_copy.right = n;
			
		}else {return false;}
		
		return true;
	}


	@Override
	public boolean remove(String s) {
		BST_Node pseu_root = root;
		root = deletNode(pseu_root, s);
		return true;
	}
	
	public BST_Node deletNode(BST_Node n, String key) {
		
		if (n == null) {
			return null;
		}
		int compare = key.compareTo(n.data);
		if (compare < 0) {
			n.left = deletNode(n.left,key);
		}else if(compare >0) {
			n.right = deletNode(n.right,key);
		}
		
		else {
			if (n.left == null) {
				return n.right;
			}
			if (n.right == null) {
				return n.left;
			}
			
			// if node has two childs
			// find the smallest in the right tree
			n.data = minHelper(n.right);
			
			n.right = deletNode(n.right,n.data);
		}
		
		
		return n;
		
	}
	
	public String minHelper(BST_Node n) {
		if (n == null) {
			return null;
		}
		
		if (n.left == null) {
			return n.data;
		}
		n = n.left;
		return minHelper(n);
	}


	@Override
	public String findMin() {
		BST_Node pseu_root = root;
		return minHelper(pseu_root);
		
	}


	@Override
	public String findMax() {
		BST_Node pesu_root = root;
		if (pesu_root == null) {
			return null;
		}
		while(pesu_root.right != null) {
			pesu_root = pesu_root.right;
		}
		return pesu_root.data;
	}


	@Override
	public boolean empty() {
		if (root == null) {
			return true;
		}
		return false;
	}


	@Override
	public boolean contains(String s) {
		BST_Node pesu_root = root;
		if (containHelper(pesu_root,s) != null) {
			return true;
		}
		return false;
		
	}
	
	public BST_Node containHelper(BST_Node n,String s) {
		if (n == null) {
			return null;
		}
		int compareResult = s.compareTo(n.data);
		
		if (compareResult < 0 ) {
			n = n.left;
			return containHelper(n,s);
		}else if (compareResult >0) {
			n = n.right;
			return containHelper(n,s);
			
		}else {
			return n;
		}
		
		
	}


	@Override
	public int size() {
		if (root != null) {
			return root.getSize();
		}
		return 0;
	}


	@Override
	public int height() {
		if (root != null) {
			return root.getHeight() - 1;
		}
		return 0;
	}

	  //--------------------------------------------------
	  //
	  // of course, fill in the methods implementations
	  // for the interface
	  //
	  //--------------------------------------------------

}
