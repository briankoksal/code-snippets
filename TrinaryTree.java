/* Java Trinary-Tree */

public class TrinaryTree {
	
	/*  Method to insert new value into tree structure*/
	public void Insert(Node node, int value){

		if (node.value == value){  //middle
			if (node.center != null){ 
				Insert(node.center, value);
			}else{
				node.center = new Node(value);
			}
		}
		if (node.value > value){ //left
			if (node.left != null){
				Insert(node.left, value);
			}else{
				node.left = new Node(value);
			}
		}
		if (node.value < value){ //right
			if (node.right != null){
				Insert(node.right, value);
			}else{
				node.right = new Node(value);
			}
		}
	}
	
	/* Delete helper function to handle special case where root node is to be deleted */
	public boolean Delete(Node root, int val){
		
		if (root == null){
			return false;
		}
		
		if (root.value == val){
			Node dummy = new Node(0);
			dummy.left = root;
			boolean result = root.Delete(dummy, val);
			root = dummy.left;
			return result;
		
		}else{
			return root.Delete(null, val);
		}
	}
		
	public class Node{
		Node left;
		Node right;
		Node center;
		
		int value = Integer.MIN_VALUE;
				
		public Node(int value)
		{
			this.value = value;
		}
		
	    public int minVal() {
	    	if (this.left == null){
	              return this.value;
	    	}
	        else{
	              return this.left.minVal();
	        }
        }
		
		/*  Method searches subtree for node to be removed and restructures children Nodes accordingly.  */
	    public boolean Delete(Node parent, int value){
			
			if (value < this.value){ 
				if (this.left != null){
					return this.left.Delete (this, value);
				}else{
					return false; 
				}	
			}
			else if (value > this.value){
				if(this.right != null){
					return this.right.Delete(this,value);
				}else{
					return false;
				}
			}
			else{ //value found
				if(this.center != null){ 
					this.center.Delete(this, value); //last center Node is deleted if multiple exist
				}else if(this.left != null && this.right != null){
					this.value = this.right.minVal(); //replace target Node with smallest from the right target's subtree then delete smallest
					this.right.Delete(this, this.value);
				}else if (parent.left == this){
					parent.left = (this.left != null) ? this.left : this.right;
				}else if (parent.right == this){
					parent.right = (this.left != null) ? this.left : this.right;
				}else if (parent.center == this){ 
					parent.center = null;
				}
			
				return true;
			}
		}
	}
}
