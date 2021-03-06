package BST_A2;

public class BST_Node {
	
	 String data;
	  BST_Node left;
	  BST_Node right;
	  
	  BST_Node(String data){ this.data=data; }

	  // --- used for testing  ----------------------------------------------
	  //
	  // leave these 3 methods in, as is

	  public String getData(){ return data; }
	  public BST_Node getLeft(){ return left; }
	  public BST_Node getRight(){ return right; }

	  // --- end used for testing -------------------------------------------
	  
	  // --------------------------------------------------------------------
	  // you may add any other methods you want to get the job done
	  // --------------------------------------------------------------------
	  public int getSize() {
		 int leftSize = 0;
		 int rightSize = 0;
		 
		 if (left !=  null) {
			 leftSize = left.getSize();
		 }
		 if (right != null) {
			 rightSize = right.getSize();
		 }
		 
		 return leftSize + rightSize + 1;
	  }
	  public int getHeight() {
		  int leftHeight = 0;
		  int rightHeight = 0;
		  if (left != null) {
			  leftHeight = left.getHeight();
		  }
		  if (right != null) {
			  rightHeight = right.getHeight();
		  }
		  
		  return Math.max(leftHeight, rightHeight) + 1;
	  }
	  
	  public String toString(){
	    return "Data: "+this.data+", Left: "+((this.left!=null)?left.data:"null")
	            +",Right: "+((this.right!=null)?right.data:"null");
	  }

}
